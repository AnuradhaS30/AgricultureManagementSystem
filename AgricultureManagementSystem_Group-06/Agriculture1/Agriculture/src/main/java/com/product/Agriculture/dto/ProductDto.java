package com.product.Agriculture.dto;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "productDto")
public class ProductDto {
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="categoryid")
	private int categoryId;
	@Column(name="price")
	private double price;
	@Column(name="description")
	private String description;
	@Column(name="imagename")
	private String imageName;
	
	
	
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductDto(long id,String name, int categoryId, double price, String description, String imageName) {
		super();
		this.id=id;
		this.name = name;
		this.categoryId = categoryId;
		this.price = price;
		this.description = description;
		this.imageName = imageName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
