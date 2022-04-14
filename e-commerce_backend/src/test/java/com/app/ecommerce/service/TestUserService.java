package com.app.ecommerce.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.ecommerce.pojos.Role;
import com.app.ecommerce.pojos.UserRole;

@SpringBootTest
class TestUserService {
	@Autowired
	private IUserService userService;

	@Test
	void testAddAdminRole() {
		Role role1 = userService.addRole(new Role(UserRole.ROLE_ADMIN));
		System.out.println(role1);
	}

	@Test
	void testAddCustomerRole() {
		Role role1 = userService.addRole(new Role(UserRole.ROLE_CUSTOMER));
		System.out.println(role1);
	}

	@Test
	void testLinkUserRole() {
		// add admin role to admin@admin.com
		System.out.println(userService.linkUserRole("admin@admin.com", UserRole.ROLE_ADMIN));
	}

	// ***************************************************************
	@Test
	void testLinkUserRole1() {
		// add customer role to user1
		System.out.println(userService.linkUserRole("user1@gmail.com", UserRole.ROLE_CUSTOMER));
	}

	@Test
	void testLinkUserRole2() {
		// add customer role to user2
		System.out.println(userService.linkUserRole("user2@gmail.com", UserRole.ROLE_CUSTOMER));
	}

	@Test
	void testLinkUserRole3() {
		// add customer role to user2
		System.out.println(userService.linkUserRole("user3@gmail.com", UserRole.ROLE_CUSTOMER));
	}
}
