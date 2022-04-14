package com.app.ecommerce.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.ecommerce.custom_exception.ResourceNotFoundException;
import com.app.ecommerce.dao.CategoryRepository;
import com.app.ecommerce.dao.ProductRepository;
import com.app.ecommerce.dto.ProductDTO;
import com.app.ecommerce.pojos.Category;
import com.app.ecommerce.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	@Value("${file.upload.location}")
	private String location;

	// dependency :
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Product addNewProduct(ProductDTO dto, MultipartFile imageFile) throws IOException {
		System.out.println("In add new product service " + dto + " file name " + imageFile.getOriginalFilename());

		imageFile.transferTo(new File(location, imageFile.getOriginalFilename()));

		// get category from category id , from the dto
		Category category = categoryRepo.findById(dto.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Invalid category ID!!!!!!!"));

		Product product = new Product();
		BeanUtils.copyProperties(dto, product);
		product.setProductCategory(category);
		product.setImageName(imageFile.getOriginalFilename());
		category.addProduct(product); // establish a bi-directional link
		return productRepo.save(product);
	}

	// *********************************************************************

	@Override
	public Product getProductDetailsById(int id) {
		return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid Product ID"));
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepo.findAll();
	}
	
	@Override
	public List<Product> getAllProductsByCategory(int categoryId) {
		return productRepo.findByCategory_id(categoryId);
	}
	
	// ********************************************************************

	@Override
	public Product updateProduct(ProductDTO dto, MultipartFile imageFile, int productId) throws IllegalStateException, IOException {
		System.out.println("In add new product service " + dto + " file name " + imageFile.getOriginalFilename());

		imageFile.transferTo(new File(location, imageFile.getOriginalFilename()));

		// get category from category id , from the dto
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new RuntimeException("Invalid product ID!!!!!!!"));

		// get category from category id , from the dto
		Category category = categoryRepo.findById(dto.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Invalid category ID!!!!!!!"));

		product.setId(productId);
		product.setProductName(dto.getProductName());
		product.setProductManufacturer(dto.getProductManufacturer());
		product.setProductDescription(dto.getProductDescription());
		product.setProductPrice(dto.getProductPrice());
		product.setQuantity(dto.getQuantity());
		product.setProductCategory(category);
		product.setImageName(imageFile.getOriginalFilename());
		return productRepo.save(product);
	}
	
	// *********************************************************************

	@SuppressWarnings("null")
	@Override
	public String deleteProductById(int productId) {
		// get category from category id , from the dto
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new RuntimeException("Invalid product ID!!!!!!!"));
		if (product != null) {
			product.getProductCategory().removeProduct(product);
			productRepo.delete(product);
			return "Product Details with ID " + productId + " deleted successfuly... ";
		} else
			// raise custom un-checked exception
			throw new ResourceNotFoundException("Product with Id = " + productId + " not found");
	}

}
