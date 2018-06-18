package com.innovation.microservices.microservicesgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.innovation.microservices.microservicesgateway.proxy")
public class MicroservicesGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesGateWayApplication.class, args);
	}
}
