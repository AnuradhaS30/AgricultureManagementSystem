package com.product.Agriculture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Agriculture.model.Product;
import com.product.Agriculture.repository.ProductServiceRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductServiceRepo productServiceRepo;
	
	public List<Product> getAllProducts(){
		return productServiceRepo.findAll();
	}

	public void addProduct(Product product)
	{
		productServiceRepo.save(product);
	}
	
	public void removeProductById(Long id)
	{
		productServiceRepo.deleteById(id);
	}
	
	public Optional<Product> getProductById(long id)
	{
		return productServiceRepo.findById(id);
	}
	
	public List<Product> getAllProductsByCategoryId(int id)
	{
		return productServiceRepo.findAllByCategory_Id(id);
	}
	
	
}
