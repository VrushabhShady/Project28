package com.app.ecommerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ecommerce.pojos.Role;
import com.app.ecommerce.pojos.UserRole;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRole(UserRole role);
}
