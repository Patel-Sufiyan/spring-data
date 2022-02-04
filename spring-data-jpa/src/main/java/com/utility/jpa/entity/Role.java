package com.utility.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sufiyan patel
 * this class is created for the implementation of one to many relation
 * one role can have many users and when the role is deleted all the users of that role should be deleted . 
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	private String name;
	private String description;
	@OneToMany(targetEntity = User.class)
	private List<User> Users;
	
}
