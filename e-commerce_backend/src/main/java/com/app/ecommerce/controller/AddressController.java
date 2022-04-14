package com.app.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.dto.AddressDTO;
import com.app.ecommerce.service.IAddressService;

@RestController
@RequestMapping("/user/address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {
	@Autowired
	private IAddressService addressService;

	// add address to user
	@PostMapping
	public ResponseEntity<?> assignAddressToUser(@RequestBody AddressDTO addr) {
		return new ResponseEntity<>(addressService.assignAddressToUser(addr), HttpStatus.OK);
	}
	
	// ***********************************************************************

	// add address to user
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteAddressOfUser(@PathVariable int userId) {
		return new ResponseEntity<>(addressService.deleteAddressOfUser(userId), HttpStatus.OK);
	}
}
