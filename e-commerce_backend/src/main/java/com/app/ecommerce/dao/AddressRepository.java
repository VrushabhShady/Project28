package com.app.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecommerce.pojos.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
