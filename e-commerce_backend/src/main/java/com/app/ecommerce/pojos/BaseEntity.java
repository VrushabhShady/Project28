package com.app.ecommerce.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@MappedSuperclass //common super class for all other entities
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity {
	// common data members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
