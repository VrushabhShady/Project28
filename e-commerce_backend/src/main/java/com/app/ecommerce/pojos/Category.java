package com.app.ecommerce.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// One | Parent | INVERSE side
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Category name is required")
	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<>();

	// setters and getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	// add helper method to establish a bi-directional link between Category and Product
	public void addProduct(Product p) {
		products.add(p); // link Category ---> Product
		p.setProductCategory(this);// Product --> Category // this : current Category object
	}

	// add helper method to remove a bi-directional link between Category and Product
	public void removeProduct(Product p) {
		products.remove(p); // Category ----x----> Product
		p.setProductCategory(null);// Product ----x----> Category
	}
}
