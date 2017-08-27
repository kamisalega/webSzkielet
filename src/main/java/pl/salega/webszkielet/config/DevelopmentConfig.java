package pl.salega.webszkielet.config;


import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import pl.salega.webszkielet.backend.service.EmailService;
import pl.salega.webszkielet.backend.service.impl.MockEmailService;

/**
 * Created by kamilsalega on 08.08.2017.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/Documents/Programista/szkielet/.webSzkielet/application-dev.properties")
public class DevelopmentConfig {

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }

    @Bean
    public ServletRegistrationBean h2ConsoleServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
        bean.addUrlMappings("/console/*");
        return bean;
    }

}
