package com.app.ecommerce.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Many | Child | OWNING side
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Product Name is required")
	@Column(name = "product_name")
	private String productName;

	@Column(name = "manufacturer")
	private String productManufacturer;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category productCategory;

	@Column(name = "product_description")
	private String productDescription;

	@NotNull(message = "Product price required")
	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "quantity")
	@Min(0)
	private Integer quantity;

	@Column(name = "product_image")
	private String imageName;
	
	
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts = new ArrayList<>();;
}
