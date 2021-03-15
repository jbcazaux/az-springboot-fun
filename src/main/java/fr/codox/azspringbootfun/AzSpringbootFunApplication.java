package fr.codox.azspringbootfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import fr.codox.azspringbootfun.configurations.MessageProperties;

@SpringBootApplication
@EnableConfigurationProperties(MessageProperties.class)
public class AzSpringbootFunApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzSpringbootFunApplication.class, args);
    }

}
