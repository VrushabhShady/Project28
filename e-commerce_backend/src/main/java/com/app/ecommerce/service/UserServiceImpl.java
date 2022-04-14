package com.app.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecommerce.dao.RoleRepository;
import com.app.ecommerce.dao.UserRepository;
import com.app.ecommerce.dto.SignUpRequest;
import com.app.ecommerce.pojos.Role;
import com.app.ecommerce.pojos.User;
import com.app.ecommerce.pojos.UserRole;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	// dependency : DAO layer i/f
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public String authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found!!!!"));
		boolean isPasswordMatch = encoder.matches(password, user.getPassword());
		if (isPasswordMatch) {
				return "User with email id = " + email + " logged in successfully";
		} else
			return "Please provide correct password";
	}
	
	// **********************************************************************

	// user registration
	@Override
	public User registerUser(SignUpRequest request) {
		User user = new User();
		BeanUtils.copyProperties(request, user);
		Role userRole = roleRepo.findByRole(UserRole.ROLE_CUSTOMER).orElseThrow(() -> new RuntimeException("Role not found!!!!"));
		user.getRoles().add(userRole);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	// **********************************************************************
	
	// add new the roles
	@Override
	public Role addRole(Role role) {
		return roleRepo.save(role);
	}

	// verify role and user details
	@Override
	public String linkUserRole(String email, UserRole role) {
		// get user from user name
		User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found!!!!"));

		// get role from role name
		Role userRole = roleRepo.findByRole(role).orElseThrow(() -> new RuntimeException("Role not found!!!!"));

		// add role to user // set
		user.getRoles().add(userRole);
		return "Linked role to User....";
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		users = userRepo.findAll();
		return users;
	}

	@Override
	public User getUserByEmail(String email) {
		// get user from user name
		User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found!!!!"));
		System.out.println(user);
		return user;
	}
	
	@Override
	public User getUserById(int userId) {
		// get user from user name
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found!!!!"));
		System.out.println(user);
		return user;
	}

}
