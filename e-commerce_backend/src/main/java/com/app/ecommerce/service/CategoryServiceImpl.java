package com.app.ecommerce.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ecommerce.dao.CategoryRepository;
import com.app.ecommerce.pojos.Category;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryRepository categoryRepo;

	//add a new category
	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	// get all categories
	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryDetails(int categoryId) {
		return categoryRepo.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category by ID " + categoryId + " not found!!!!"));
	}
	
	
	@Override
	public Category getCategoryDetailsByName(String categoryName) {
		return categoryRepo.findByCategoryName(categoryName)
				.orElseThrow(() -> new RuntimeException("Category by ID " + categoryName + " not found!!!!"));
	}
	
	@Override
	public String deleteCategoryDetails(int categoryId) {
		categoryRepo.deleteById(categoryId);
		return "Category Details with ID " + categoryId + " deleted successfuly... ";
	}

}
