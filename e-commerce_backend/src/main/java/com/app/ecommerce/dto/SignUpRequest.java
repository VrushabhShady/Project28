package com.app.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignUpRequest {
	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String confirmPassword;

	private String phone;
}
