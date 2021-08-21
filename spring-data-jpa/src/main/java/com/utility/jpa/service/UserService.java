package com.utility.jpa.service;

import org.springframework.http.ResponseEntity;

import com.utility.jpa.entity.User;

public interface UserService {

	boolean  createuser(User user);
}
