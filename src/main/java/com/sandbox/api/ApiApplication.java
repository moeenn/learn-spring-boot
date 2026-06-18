package com.sandbox.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "file:.env", ignoreResourceNotFound = true)
public class ApiApplication {

	static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
