package com.ad.oas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-beans.xml")
public class OasApplication {

	public static void main(String[] args) {
		SpringApplication.run(OasApplication.class, args);
	}
}
