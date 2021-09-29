package com.product.Agriculture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.Agriculture.model.Category;
import com.product.Agriculture.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	public void addCategory(Category category)
	{
		categoryRepo.save(category);
	}
	
	public void removeCategoryById(int id)
	{
		categoryRepo.deleteById(id);
	}
	
	public Optional<Category> getCategoryById(int id)
	{
		return categoryRepo.findById(id);
	}
}
