package br.edu.ifsp.spo.lp2a4.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "br.edu.ifsp.spo.lp2a4.spring")
@EnableJpaRepositories(basePackages = { "br.edu.ifsp.spo.lp2a4.spring" })
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
