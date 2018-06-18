package com.innovation.microservices.microserviceswebinterface.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.innovation.microservices.microserviceswebinterface.entity.User;
import com.innovation.microservices.microserviceswebinterface.proxy.WebInterfaceProxy;

@Controller
@RequestMapping("/")
@SessionAttributes("userSession")
public class WebInterfaceController {

	@Autowired
	WebInterfaceProxy webInterfaceProxy;
	
	@RequestMapping(method = RequestMethod.GET, produces = "text/html")
	public String loginPage(Model m) {
		m.addAttribute("user", new User());
		m.addAttribute("userSession", new String());
		return "login-page";
	}
	
	@RequestMapping(value = "account", method = RequestMethod.GET, produces = "text/html")
	public String accountPage(Model m) {
		return "account";
	}
	
	@RequestMapping(value = "header", method = RequestMethod.GET, produces = "text/html")
	public String header(Model m, HttpSession session) {
		m.addAttribute("user", new User());
		m.addAttribute("userSession", session.getAttribute("userSession"));
		return "header";
	}

	@RequestMapping(method = RequestMethod.POST, value = "login", produces = "text/html")
	public String greetingSubmit(@ModelAttribute("user") User user, Model model, HttpSession session) {
		ResponseEntity<String> responseEntity = webInterfaceProxy.callLogin(user.getEmail(), user.getPassword());
		String response = responseEntity.getBody();
		session.setAttribute("userSession", response);
		model.addAttribute("userSession", response);
		return "landing-page";
	}
}
