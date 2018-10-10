package com.innovation.microservices.microservicesuserservice.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.innovation.microservices.microservicesuserservice.entity.User;
import com.innovation.microservices.microservicesuserservice.repository.UserRepository;

@RestController
@RequestMapping("/users")
@SessionAttributes("userSession")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String process() {
		userRepository.save(new User("user1", "user1@gmail.com", "user@user1"));
		userRepository.save(new User("user2", "user2@gmail.com", "user@user2"));
		userRepository.save(new User("user3", "user3@gmail.com", "user@user3"));
		userRepository.save(new User("user4", "user4@gmail.com", "user@user4"));
		userRepository.flush();
		return "Done";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public User getUserInformation(@PathVariable(name = "id") int id) {
		for(User user : userRepository.findAll()) {
			if(user.getUserId() == id) {
				return user;
			}
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login/{email}/{password}")
	public String checkExistedUser(@PathVariable(name = "email") String email,
			@PathVariable(name = "password") String password, HttpSession session) {
		Optional<User> user = userRepository.findByEmailAndPassword(email, password);
		if (user.isPresent()) {
			return user.get().getUserName();
		}
		return "";
	}

}
