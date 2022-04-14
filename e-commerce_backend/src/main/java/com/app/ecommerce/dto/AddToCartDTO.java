package com.app.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AddToCartDTO {
	private Integer id;

	private Integer productId;

	private Integer quantity;
}
