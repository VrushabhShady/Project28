package com.app.ecommerce.service;

import java.util.List;

import com.app.ecommerce.dto.SignUpRequest;
import com.app.ecommerce.pojos.Role;
import com.app.ecommerce.pojos.User;
import com.app.ecommerce.pojos.UserRole;

public interface IUserService {
	// authenticate user
	String authenticateUser(String email, String password);

	// register user
	User registerUser(SignUpRequest request);

	// add roles
	Role addRole(Role role);

	// link role to user
	String linkUserRole(String email, UserRole role);

	// get all registered users
	List<User> getAllUsers();

	// get user details by email
	User getUserByEmail(String email);

	User getUserById(int userId);
}
