package be.somedi.urologiereader.model;

import be.somedi.urologiereader.entity.Person;
import be.somedi.urologiereader.service.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UroWriter {

    @Value("${path-read}")
    private Path pathToRead;
    @Value("${startname-file}")
    private String startNameOfFile;

    private static final int SIZE_INSS = 11;

    private final PersonService personService;

    @Autowired
    public UroWriter(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> getPatients() {
        List<Person> patients = null;
        try {
            System.out.println("Path to read: " + pathToRead);
            patients = Files.list(pathToRead)
                    .filter(Files::isRegularFile)
                    .filter(path -> StringUtils.endsWith(path.toString(), ".pdf"))
                    .map(path -> {
                        Person patient = null;
                        try {
                            Path toPath = Paths.get(pathToRead + backUpPdf(path));
                            if(Files.notExists(toPath)){
                                Files.createDirectories(toPath);
                            }
                            Files.copy(path, toPath , StandardCopyOption.REPLACE_EXISTING);
                            patient = personService.findByInss(StringUtils.left(path.getFileName().toString(), SIZE_INSS));

                            String urlToPDF = startNameOfFile + backUpPdf(path);
                            patient.setUrlToPDF(urlToPDF);

                            Files.delete(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return patient;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }

    private String backUpPdf(Path path){
        LocalDate now = LocalDate.now();
        return "/" + now.getYear()+ "/" + now.getYear() + "-"
                + now.getMonthValue() + "-" + now.getDayOfMonth() + "/" + path.getFileName().toString().replaceAll(" ", "_");
    }
}
