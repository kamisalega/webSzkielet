package pl.salega.webszkielet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import pl.salega.webszkielet.backend.service.EmailService;
import pl.salega.webszkielet.backend.service.impl.SmptEmailService;

/**
 * Created by kamilsalega on 08.08.2017.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/Documents/Programista/szkielet/.webSzkielet/application-prod.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService() {
        return new SmptEmailService();
    }
}
