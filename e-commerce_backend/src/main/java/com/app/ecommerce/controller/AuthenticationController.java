package com.app.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.dto.AuthenticationResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
	@GetMapping
	public AuthenticationResponse authenticateUser(HttpServletRequest request){
		System.out.println("in auth user "+request.getHeader("authorization"));			
		return new AuthenticationResponse("Successful Authentication");
	}
}
