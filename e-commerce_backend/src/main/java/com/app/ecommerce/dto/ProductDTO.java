package com.app.ecommerce.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private @NotBlank String productName;

	private @NotBlank String productManufacturer;

	private @NotNull int categoryId;

	private @NotBlank String productDescription;

	private @NotNull double productPrice;

	private @NotNull int quantity;

	private @NotBlank String imageName;
}
