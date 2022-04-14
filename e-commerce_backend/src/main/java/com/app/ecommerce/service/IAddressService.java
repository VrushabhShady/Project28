package com.app.ecommerce.service;

import com.app.ecommerce.dto.AddressDTO;
import com.app.ecommerce.pojos.Address;

public interface IAddressService {
	// add address
	public Address assignAddressToUser(AddressDTO addr);

	public String deleteAddressOfUser(int userId);
	
	public Address findDeliveryAddress(int userId);
}
