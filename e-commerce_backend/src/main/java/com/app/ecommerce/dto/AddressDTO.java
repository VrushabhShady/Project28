package com.app.ecommerce.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {
	@NotBlank
	private String city;

	@NotBlank
	private String state;

	@NotBlank
	private String country;

	@NotBlank
	private String zipCode;
	
	@NotNull
	private int userId;
}
