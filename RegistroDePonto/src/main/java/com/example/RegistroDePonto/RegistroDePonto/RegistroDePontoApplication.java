package com.example.RegistroDePonto.RegistroDePonto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RegistroDePontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroDePontoApplication.class, args);
	}

}
