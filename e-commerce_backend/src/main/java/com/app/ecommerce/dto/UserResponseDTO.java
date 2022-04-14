package com.app.ecommerce.dto;

import java.util.HashSet;
import java.util.Set;

import com.app.ecommerce.pojos.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserResponseDTO {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;		
	private Set<Role> roles = new HashSet<>();	
}
