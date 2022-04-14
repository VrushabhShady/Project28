package com.app.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ecommerce.dao.AddressRepository;
import com.app.ecommerce.dao.UserRepository;
import com.app.ecommerce.dto.AddressDTO;
import com.app.ecommerce.pojos.Address;
import com.app.ecommerce.pojos.User;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Address assignAddressToUser(AddressDTO addr) {
		System.out.println("In address assign " + addr);

		User user = userRepo.findById(addr.getUserId())
				.orElseThrow(() -> new RuntimeException("Invalid user ID!!!!!!!"));

		Address address = new Address();
		BeanUtils.copyProperties(addr, address);
		user.setAddress(address);
		address.setUser(user);
		return addressRepo.save(address);
	}

	// ******************************************************************

	@Override
	public String deleteAddressOfUser(int userId) {
		Address addr = addressRepo.findById(userId)
						.orElseThrow(() -> new RuntimeException("Invalid user ID!!!!!!!"));
		addressRepo.delete(addr);
		return "Address of user having Id = " + userId + " deleted.";
	}

	@Override
	public Address findDeliveryAddress(int userId) {
		return addressRepo.getById(userId);
	}

}
