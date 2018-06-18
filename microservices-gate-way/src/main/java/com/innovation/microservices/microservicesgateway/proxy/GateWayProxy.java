package com.innovation.microservices.microservicesgateway.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="USER-SERVICE")
@RibbonClient(name="USER-SERVICE")
public interface GateWayProxy {

	@GetMapping("/users/login/{email}/{password}")
	public ResponseEntity<String> callLogin(@PathVariable("email") String email, @PathVariable("password") String password);
}
