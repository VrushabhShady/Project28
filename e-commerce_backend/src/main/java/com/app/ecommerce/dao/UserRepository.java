package com.app.ecommerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.ecommerce.pojos.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	// find by email
	@Query("select u from User u where u.email = ?1")
	Optional<User> findByEmail(String email);
}
