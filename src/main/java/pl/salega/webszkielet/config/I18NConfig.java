package pl.salega.webszkielet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by kamilsalega on 07.08.2017.
 */
@Configuration
public class I18NConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("classpath:i18n/messages");

//        Sprawdzaca 30 min nową wiadomość
        resourceBundleMessageSource.setCacheSeconds(1800);
        return resourceBundleMessageSource;
    }

}
