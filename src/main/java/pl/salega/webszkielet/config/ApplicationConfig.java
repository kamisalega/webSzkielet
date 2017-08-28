package pl.salega.webszkielet.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sun.misc.Contended;

import javax.persistence.Entity;

@Configuration
@EnableJpaRepositories(basePackages = "pl.salega.webszkielet.backend.persistence.repositories")
@EntityScan(basePackages = "pl.salega.webszkielet.backend.persistence.domain.backend")
@EnableTransactionManagement
public class ApplicationConfig {
}
