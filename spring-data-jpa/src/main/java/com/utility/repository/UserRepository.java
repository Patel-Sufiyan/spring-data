package com.utility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utility.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
