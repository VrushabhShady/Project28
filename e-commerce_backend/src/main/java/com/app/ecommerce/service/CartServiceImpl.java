package com.app.ecommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ecommerce.custom_exception.ResourceNotFoundException;
import com.app.ecommerce.dao.CartRepository;
import com.app.ecommerce.dto.AddToCartDTO;
import com.app.ecommerce.dto.CartDTO;
import com.app.ecommerce.dto.CartItemDTO;
import com.app.ecommerce.pojos.Cart;
import com.app.ecommerce.pojos.Product;
import com.app.ecommerce.pojos.User;

@Service
@Transactional
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartRepository cartRepo;

	// add to cart
	// createdDate, quantity, product, user
	@Override
	public String addToCart(AddToCartDTO addToCartDto, Product product, User user) {
		System.out.println("In add to cart service");
		Cart cart = new Cart(new Date(), addToCartDto.getQuantity(), product, user);
		cartRepo.save(cart);
		return "Product added to cart successfully";
	}

	// ********************************************************************
	
	// get all cart items
	@Override
	public CartDTO listCartItems(User user) {
		List<Cart> cartList = cartRepo.findAllById(user.getId());
		List<CartItemDTO> cartItems = new ArrayList<>();
		for (Cart cart : cartList) {
			CartItemDTO cartItemDto = getDtoFromCart(cart);
			cartItems.add(cartItemDto);
		}
		double totalCost = 0;
		for (CartItemDTO cartItemDto : cartItems) {
			totalCost += (cartItemDto.getProduct().getProductPrice() * cartItemDto.getQuantity());
		}
		return new CartDTO(cartItems, totalCost);
	}

	public static CartItemDTO getDtoFromCart(Cart cart) {
		return new CartItemDTO(cart);
	}
	
	// **********************************************************************
	
	// update cart
	public String updateCartItem(AddToCartDTO cartDto, User user, Product product){
        Cart cart = cartRepo.getById(cartDto.getId());
        cart.setQuantity(cartDto.getQuantity());
        cart.setCreatedDate(new Date());
        cartRepo.save(cart);
        return "Cart updated successfully.";
    }

	// **********************************************************************
	
	@Override
	public String deleteCartItem(int id, int userId) {
		if (!cartRepo.existsById(id))
			throw new ResourceNotFoundException("Cart with id " + id + " is not found");
		cartRepo.deleteById(id);
		return "Cart with id " + id + " deleted successfully.";
	}
	
    public void deleteCartItems(int userId) {
        cartRepo.deleteAll();
    }

    public void deleteUserCartItems(User user) {
        cartRepo.deleteByUser(user);
    }
	
}
