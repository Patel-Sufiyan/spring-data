package com.utility.jpa.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_user",indexes = 	@Index(columnList="firstName")) // created an index
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_Id;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	@Column(unique = true)
	private String email;

}
