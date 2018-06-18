package com.innovation.microservices.microserviceswebinterface.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="GATE-WAY")
@RibbonClient(name="GATE-WAY")
public interface WebInterfaceProxy {

	@GetMapping("/users/login/{email}/{password}")
	public ResponseEntity<String> callLogin(@PathVariable("email") String email, @PathVariable("password") String password);
}
