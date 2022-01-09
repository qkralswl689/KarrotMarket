package com.karrot.karrotmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class KarrotmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarrotmarketApplication.class, args);
	}

}
