package com.utility.jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utility.jpa.entity.User;
import com.utility.jpa.repository.UserRepository;
import com.utility.jpa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	
	@PostMapping("/create")
	private ResponseEntity<?> createUser(@RequestBody User user) {

		if (userRepository.findByEmail(user.getEmail().trim()).isPresent()) 
			return ResponseEntity.badRequest().body("Email already exists");
		else {
			if (userService.createuser(user)) {
				return ResponseEntity.ok("User Successfully created");
			}
		}
		return ResponseEntity.internalServerError().body("User Creation Failed");
	};
	
	@GetMapping("/getUser/{email}")
	private ResponseEntity<?> getUser(@PathVariable String email) {
		
		Optional<User> activeUser = userRepository.findByEmail(email);
		
		if(activeUser.isPresent())
			return ResponseEntity.ok(activeUser);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User Found with the given email");		
	}

}
