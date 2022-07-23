package com.timal1.spring.web.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("secret.properties")
public class SpringWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
