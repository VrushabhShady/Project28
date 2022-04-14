package com.app.ecommerce.service;

import javax.validation.Valid;

import com.app.ecommerce.dto.AddToCartDTO;
import com.app.ecommerce.dto.CartDTO;
import com.app.ecommerce.pojos.Product;
import com.app.ecommerce.pojos.User;

public interface ICartService {
	// add to cart
	public String addToCart(AddToCartDTO addToCartDto, Product product, User user);

	public CartDTO listCartItems(User user);

	public String deleteCartItem(int id,int userId);
	
	public void deleteCartItems(int userId);
	
	public void deleteUserCartItems(User user);

	public String updateCartItem(@Valid AddToCartDTO cartDto, User user, Product product);
}
