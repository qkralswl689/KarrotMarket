package com.karrot.karrotmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.karrot.karrotmarket"})
@EnableJpaAuditing
public class KarrotmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarrotmarketApplication.class, args);
	}


}
