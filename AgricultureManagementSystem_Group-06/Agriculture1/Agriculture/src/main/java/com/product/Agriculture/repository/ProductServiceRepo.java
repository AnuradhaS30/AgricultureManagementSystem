package com.product.Agriculture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.Agriculture.model.Product;

public interface ProductServiceRepo extends JpaRepository<Product,Long>{

	List<Product> findAllByCategory_Id(int id);
}
