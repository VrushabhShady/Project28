package com.app.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.dto.AuthenticationResponse;
import com.app.ecommerce.dto.SignInRequest;
import com.app.ecommerce.dto.SignUpRequest;
import com.app.ecommerce.jwt_utils.JwtUtils;
import com.app.ecommerce.pojos.User;
import com.app.ecommerce.service.IUserService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private AuthenticationManager authManager;

	// auto wire JwtUtils for sending signed JWT back to the client
	@Autowired
	private JwtUtils jwtUtils;

	// dependency : service layer i/f
	@Autowired
	private IUserService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid SignInRequest request) {
		System.out.println("In authenticate user " + request);
		try {
			Authentication authenticate = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			System.out.println("auth success " + authenticate);
			return ResponseEntity.ok(new AuthenticationResponse(jwtUtils.generateJwtToken(authenticate)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("User authentication Failed ", e);
		}
	}

	// *********************************************************************

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody @Valid SignUpRequest request) {
		System.out.println("In register user " + request);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(request));
	}

	// ********************************************************************

	@GetMapping("/admin/users")
	public List<User> getAllUsersRegistered() {
		List<User> users = new ArrayList<>();
		users.addAll(userService.getAllUsers());
		return users;
	}

	// *******************************************************************

	@GetMapping("/user")
	public User getUserDetailsbyEmail(@RequestParam String email) {
		System.out.println("In get user " + email);
		return userService.getUserByEmail(email);
	}

	@GetMapping("/user/{userId}")
	public User getUserDetailsId(@PathVariable int userId) {
		System.out.println("In get user " + userId);
		return userService.getUserById(userId);
	}
}
