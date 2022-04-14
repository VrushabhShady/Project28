package com.app.ecommerce.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.ecommerce.dto.ProductDTO;
import com.app.ecommerce.pojos.Product;

public interface IProductService {
	// add new product
	public Product addNewProduct(ProductDTO dto, MultipartFile imageFile) throws IOException;

	// find product by its id
	public Product getProductDetailsById(int productId);

	// get list of all products
	public List<Product> getAllProducts();

	// get all products under specific category
	public List<Product> getAllProductsByCategory(int categoryId);

	// update product details
	public Product updateProduct(ProductDTO details, MultipartFile imageFile, int productId) throws IOException;

	// delete product of id = productId
	public String deleteProductById(int productId);
}
