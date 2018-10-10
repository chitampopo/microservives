package com.innovation.microservices.microservicesgateway.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="SALARY-SERVICE")
@RibbonClient(name="SALARY-SERVICE")
public interface SalaryProxy {

	@GetMapping("/web")
	public ResponseEntity<String> getSalary();
}
