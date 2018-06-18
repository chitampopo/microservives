package com.innovation.microservices.microserviceswebinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.innovation.microservices.microserviceswebinterface.proxy")
public class MicroservicesWebInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesWebInterfaceApplication.class, args);
	}
}
