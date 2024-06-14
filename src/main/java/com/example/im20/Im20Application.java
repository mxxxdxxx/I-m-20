package com.example.im20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.im20.repository")
@EntityScan(basePackages = "com.example.im20.entity")
public class Im20Application {

	public static void main(String[] args) {
		SpringApplication.run(Im20Application.class, args);
	}

}
