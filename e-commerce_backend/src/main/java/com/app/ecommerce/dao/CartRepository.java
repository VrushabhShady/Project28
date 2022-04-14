package com.app.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.ecommerce.pojos.Cart;
import com.app.ecommerce.pojos.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	@Query("select c from Cart c where c.user.id = ?1")
	List<Cart> findAllById(Integer id);

	List<Cart> deleteByUser(User user);

}
