package com.app.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CartDTO {
	private List<CartItemDTO> cartItems = new ArrayList<>();

	private double totalCost;
}
