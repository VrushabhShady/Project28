package com.app.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.ecommerce.dto.ProductDTO;
import com.app.ecommerce.pojos.Product;
import com.app.ecommerce.service.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	private IProductService productService;

	@Autowired
	private ObjectMapper mapper;

	@Value("${file.upload.location}")
	private String location;

	@RequestMapping(value="/admin/product/add", method=RequestMethod.POST)
	public Product addNewProduct(@RequestParam String productDetails, @RequestParam MultipartFile imageFile)
			throws IOException {
		ProductDTO details = mapper.readValue(productDetails, ProductDTO.class);
		return productService.addNewProduct(details, imageFile);
	}

	// **********************************************************************************
	
	// get the product details by id
	@RequestMapping(value="/admin/product/{productId}", method=RequestMethod.GET)
	public ResponseEntity<?> getProductDetailById(@PathVariable int productId) {
		return new ResponseEntity<>(productService.getProductDetailsById(productId), HttpStatus.OK);
	}
	
	// **********************************************************************************
	
	// get all the product details
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ResponseEntity<?> getAllProductDetails() {
		System.out.println("In all product details");
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);// constructor....(body,status)
	}

	// *********************************************************************************
	
	// get all the products under the specific category by id
	@RequestMapping(value={"/user/product/category/{categoryId}"}, method=RequestMethod.GET)
	public List<Product> getAllProductByCategoryId(@PathVariable int categoryId) {
		return productService.getAllProductsByCategory(categoryId);
	}
	
	// *********************************************************************************
	
	// update product details
	@RequestMapping(value="/admin/product/update/{productId}", method=RequestMethod.PUT)
	public Product updateProduct(@RequestParam String productDetails, @RequestParam MultipartFile imageFile, @PathVariable int productId)
			throws IOException {
		ProductDTO details = mapper.readValue(productDetails, ProductDTO.class);
		return productService.updateProduct(details, imageFile, productId);
	}

	// *********************************************************************************
	
	// delete product by product id
	@RequestMapping(value={"/admin/product/{productId}"}, method=RequestMethod.DELETE)
	public String deleteProductById(@PathVariable @Range(min = 1, message = "Product Id should not be 0 or less than 0") int productId) {
		return productService.deleteProductById(productId);
	}
}
