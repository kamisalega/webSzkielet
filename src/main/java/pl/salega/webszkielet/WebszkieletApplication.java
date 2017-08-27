package pl.salega.webszkielet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.salega.webszkielet.backend.persistence.repositories")
public class WebszkieletApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebszkieletApplication.class, args);
	}
}
