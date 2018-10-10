package com.innovation.microservices.microservicesgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.microservices.microservicesgateway.proxy.GateWayProxy;
import com.innovation.microservices.microservicesgateway.proxy.SalaryProxy;

@RestController
public class GateWayController {

	@Autowired
	GateWayProxy gateWayProxy;
	
	@Autowired
	SalaryProxy salaryProxy;

	@RequestMapping(method = RequestMethod.GET, value = "/users/login/{email}/{password}")
	public ResponseEntity<String> checkExistedUser(@PathVariable(name = "email") String email,
			@PathVariable(name = "password") String password) {
		return gateWayProxy.callLogin(email, password);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<String> getAllUser() {
		return gateWayProxy.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public ResponseEntity<String> getUserInformation(@PathVariable(name = "id") int id) {
		return gateWayProxy.getUserInformation(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}/salary")
	public ResponseEntity<String> getSalary(@PathVariable(name = "id") int id) {
		return salaryProxy.getSalary();
	}
}
