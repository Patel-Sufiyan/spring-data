package com.utility.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utility.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//since we are using a unique constraint for email we are expecting only one value for DB
	//or we can go with Optional<List<User>>
	Optional<User> findByEmail(String email);
}
