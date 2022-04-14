package com.app.ecommerce.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.ecommerce.pojos.User;
 
 public class CustomUserDetails implements UserDetails {
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
 	private User user;
 
 	public CustomUserDetails(User user) {
 		super();
 		this.user = user;
 	}
 
 	@Override
 	public Collection<? extends GrantedAuthority> getAuthorities() {
 		System.out.println("get authorities " + user.getRoles());
 		return user.getRoles() // Set<Role>
 				.stream() // Stream<Role>
 				.map(role -> new SimpleGrantedAuthority(role.getRole().name()))
 				.collect(Collectors.toList());
 	}

 
 	@Override
 	public String getPassword() {
 		System.out.println("get password");
 		return user.getPassword();
 	}
 
 	@Override
 	public String getUsername() {
 		return user.getEmail();
 	}
 
 	@Override
 	public boolean isAccountNonExpired() {
 		return true;
 	}
 
 	@Override
 	public boolean isAccountNonLocked() {
 		return true;
 	}
 
 	@Override
 	public boolean isCredentialsNonExpired() {
 		return true;
 	}
 
 	@Override
 	public boolean isEnabled() {
 		return true;
 	}
 
 }
