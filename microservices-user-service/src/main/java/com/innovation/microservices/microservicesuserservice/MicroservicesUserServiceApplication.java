package com.innovation.microservices.microservicesuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.innovation.microservices.microservicesuserservice.controller")
@EnableJpaRepositories(basePackages="com.innovation.microservices.microservicesuserservice.repository")
@EntityScan(basePackages="com.innovation.microservices.microservicesuserservice.entity")
public class MicroservicesUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesUserServiceApplication.class, args);
	}
}
