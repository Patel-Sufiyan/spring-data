package com.utility.jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utility.jpa.entity.Role;
import com.utility.jpa.repository.RoleRepository;
import com.utility.jpa.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	private RoleService roleService;
	
	private RoleRepository roleRepository;
	
	//this is Constructor dependency injection 
	//we might use @Autowired when there are multiple constructors.
	@Autowired
	RoleController(RoleService roleService,RoleRepository roleRepository){
		
		this.roleService=roleService;
		this.roleRepository=roleRepository;
	}
	
	
	@Transactional//adding transactional to avoid issues during error.
	@RequestMapping("/create")
	public ResponseEntity<?> createRole(@RequestBody Role role){
		
		if(roleService.createRole(role))
			return ResponseEntity.ok("Role created Successfully");
		else
			return ResponseEntity.internalServerError().body("Cannot create role at the moment.");
		
	}
	
	@RequestMapping("/getrole/{roleId}")
	public ResponseEntity<?> getRole(@PathVariable Long roleId) {
		Optional<Role> roleFound=roleRepository.findById(roleId);
		if(roleRepository.findById(roleId).isPresent()) 
			return ResponseEntity.ok(roleFound);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No role found for particular id ");
		
	}
	
	
}
