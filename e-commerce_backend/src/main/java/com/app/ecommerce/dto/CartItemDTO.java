package com.app.ecommerce.dto;

import javax.validation.constraints.NotNull;

import com.app.ecommerce.pojos.Cart;
import com.app.ecommerce.pojos.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CartItemDTO {
	@NotNull
	private Integer id;

	@NotNull
	private Integer quantity;

	@NotNull
	private Product product;

	public CartItemDTO(Cart cart) {
        this.setId(cart.getId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public CartItemDTO(Cart cart) {
//        this.id = cart.getId();
//        this.setQuantity(cart.getQuantity());
//        this.setProduct(cart.getProduct());
//    }
}
