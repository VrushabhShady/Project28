package com.app.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.pojos.Category;
import com.app.ecommerce.service.ICategoryService;

@RestController
@RequestMapping("/admin/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;

	// add a new Category
	@PostMapping
	public ResponseEntity<?> addCategoryDetails(@RequestBody @Valid Category category) {
		System.out.println("In add new category");
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
	}

	// ************************************************************************
	
	// get all categories present
	@GetMapping
	public ResponseEntity<?> getAllCategoryDetails() {
		System.out.println("In get all categories");
		return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
	}

	// *************************************************************************
	
	// get Category details by category id
	@GetMapping("/id/{categoryId}")
	public ResponseEntity<?> getCategoryDetails(@PathVariable int categoryId) {
		System.out.println("In get category details " + categoryId);
		return new ResponseEntity<>(categoryService.getCategoryDetails(categoryId), HttpStatus.OK);
	}
	
	// ************************************************************************
	
	// get Category details by category name
	@GetMapping("/name/{categoryName}")
	public ResponseEntity<?> getCategoryDetailsByName(@PathVariable String categoryName) {
		System.out.println("In get category details " + categoryName);
		return new ResponseEntity<>(categoryService.getCategoryDetailsByName(categoryName), HttpStatus.OK);
	}

	// ************************************************************************
	
	// delete category by ID
	@DeleteMapping("/{categoryId}")
	public String deleteCategoryDetailsByID(@PathVariable int categoryId) {
		return categoryService.deleteCategoryDetails(categoryId);
	}
}
