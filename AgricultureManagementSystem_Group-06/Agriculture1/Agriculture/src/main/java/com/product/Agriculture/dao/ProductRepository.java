package com.product.Agriculture.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Agriculture.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
