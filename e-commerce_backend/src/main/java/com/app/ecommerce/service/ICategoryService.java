package com.app.ecommerce.service;

import java.util.List;

import com.app.ecommerce.pojos.Category;

public interface ICategoryService {
	// add a new category
	public Category addCategory(Category category);

	// get All the Category List
	public List<Category> getAllCategories();

	//delete the category by id
	public String deleteCategoryDetails(int id);

	public Category getCategoryDetails(int id);

	public Category getCategoryDetailsByName(String categoryName);
}
