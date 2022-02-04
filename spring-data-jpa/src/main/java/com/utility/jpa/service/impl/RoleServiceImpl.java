package com.utility.jpa.service.impl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utility.jpa.entity.Role;
import com.utility.jpa.entity.User;
import com.utility.jpa.repository.RoleRepository;
import com.utility.jpa.repository.UserRepository;
import com.utility.jpa.service.RoleService;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean createRole(Role role) {
		
		try {
			
			for (int i = 0; i < role.getUsers().size(); i++) {
				
				User newUser= userRepository.save(role.getUsers().get(i));
				if(!userRepository.findById(newUser.getUser_Id()).isPresent())
				{
					log.error("failed saving user");
					return false;
				}
				
			}
			Role newRole =roleRepository.save(role);
			if(roleRepository.findById(newRole.getRoleId()).isPresent()) {
				log.info("role Created successfully with ID :"+role.getRoleId());
				return true;
			}
			log.error("error occured while saving role to db ");
			return false;
		} catch (Exception e) {
			log.error("error occured while saving role to db :"+e.getMessage());
			return false;
		}
		
		
	}

	
	
	
}
