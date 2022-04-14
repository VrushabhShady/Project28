package com.app.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.ecommerce.pojos.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	@Query("select p from Product p where p.productCategory.id=:id")
	List<Product> findByCategory_id(int id);
}
