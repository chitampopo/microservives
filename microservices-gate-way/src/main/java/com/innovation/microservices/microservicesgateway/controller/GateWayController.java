package com.innovation.microservices.microservicesgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.microservices.microservicesgateway.proxy.GateWayProxy;

@RestController
public class GateWayController {

	@Autowired
	GateWayProxy gateWayProxy;

	@RequestMapping(method = RequestMethod.GET, value = "/users/login/{email}/{password}")
	public ResponseEntity<String> checkExistedUser(@PathVariable(name = "email") String email,
			@PathVariable(name = "password") String password) {
		return gateWayProxy.callLogin(email, password);
	}
}
