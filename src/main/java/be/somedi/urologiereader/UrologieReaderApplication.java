package be.somedi.urologiereader;

import be.somedi.urologiereader.entity.Person;
import be.somedi.urologiereader.model.UroWriter;
import be.somedi.urologiereader.model.XMLCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

@SpringBootApplication
@PropertySource("path.properties")
public class UrologieReaderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(UrologieReaderApplication.class, args);

        System.out.println("App started!");

//        UroWriter uroWriter = applicationContext.getBean(UroWriter.class);
//        List<Person> patients = uroWriter.getPatients();
//        patients.forEach(System.out::println);

        XMLCreator xmlCreator = applicationContext.getBean(XMLCreator.class);
        try {
            xmlCreator.createNewXMLFiles();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        applicationContext.close();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
