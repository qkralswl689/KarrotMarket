package com.karrot.karrotmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.karrot.karrotmarket"})
public class KarrotmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarrotmarketApplication.class, args);
	}


}
