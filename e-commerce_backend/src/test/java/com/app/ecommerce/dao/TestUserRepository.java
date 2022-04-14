package com.app.ecommerce.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.app.ecommerce.pojos.User;

@SpringBootTest
class TestUserRepository {
	@Autowired
	private UserRepository userRepo;

	@Test
	@Transactional
	@Rollback(false)
	void test() {
		Optional<User> user = userRepo.findByEmail("admin@admin.com");
		System.out.println(user);
	}

//	@Test
//	void testUser() {
//		Optional<User> user1 = repo.findByEmailAndPassword("user1@gmail.com", "user1@123");
//		System.out.println(user1.get());
//	}

}
