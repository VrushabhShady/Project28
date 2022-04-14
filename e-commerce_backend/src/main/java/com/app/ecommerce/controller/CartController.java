package com.app.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.dto.AddToCartDTO;
import com.app.ecommerce.dto.CartDTO;
import com.app.ecommerce.pojos.Product;
import com.app.ecommerce.pojos.User;
import com.app.ecommerce.service.ICartService;
import com.app.ecommerce.service.IProductService;
import com.app.ecommerce.service.IUserService;

@RestController
@RequestMapping("/user/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
	@Autowired
	private IUserService userService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private IProductService productService;

	@PostMapping("/add")
	public ResponseEntity<?> addProductToCart(@RequestBody AddToCartDTO addToCartDto) {
		System.out.println("In add to cart ");
		User user = userService.getUserById(addToCartDto.getId());
		Product product = productService.getProductDetailsById(addToCartDto.getProductId());
		return new ResponseEntity<>(cartService.addToCart(addToCartDto, product, user), HttpStatus.CREATED);
	}

	// **********************************************************************
	
	@GetMapping
	public ResponseEntity<CartDTO> getCartItems(@RequestParam int userId) {
		User user = userService.getUserById(userId);
		CartDTO cartDto = cartService.listCartItems(user);
		return new ResponseEntity<CartDTO>(cartDto, HttpStatus.OK);
	}
	
	// **********************************************************************
	
	@PutMapping("/update/{cartItemId}")
	public ResponseEntity<?> updateCartItem(@RequestBody @Valid AddToCartDTO cartDto) {
		User user = userService.getUserById(cartDto.getId());
		Product product = productService.getProductDetailsById(cartDto.getProductId());
		return new ResponseEntity<>(cartService.updateCartItem(cartDto, user, product), HttpStatus.OK);
	}
	
	// **********************************************************************
	
	@DeleteMapping("/delete/{cartItemId}")
	public ResponseEntity<?> deleteCartItem(@PathVariable("cartItemId") int itemID) {		
		int userId = 0;
		return new ResponseEntity<>(cartService.deleteCartItem(itemID, userId), HttpStatus.OK);
	}
}
