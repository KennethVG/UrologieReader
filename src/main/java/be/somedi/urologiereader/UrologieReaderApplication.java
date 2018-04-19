package be.somedi.urologiereader;

import be.somedi.urologiereader.model.XMLCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.xml.parsers.ParserConfigurationException;

@SpringBootApplication
@PropertySource("path.properties")
public class UrologieReaderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(UrologieReaderApplication.class, args);

        System.out.println("App started!");
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
