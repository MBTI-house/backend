package com.house.mbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbitApplication.class, args);
	}
}
