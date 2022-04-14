package com.app.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.ecommerce.dao.UserRepository;
import com.app.ecommerce.pojos.User;

@Service
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// invoke dao's method to get user details
		User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
		return new CustomUserDetails(user);
	}

}
