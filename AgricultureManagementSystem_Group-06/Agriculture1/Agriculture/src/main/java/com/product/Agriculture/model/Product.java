package com.product.Agriculture.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name="name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "category_id",referencedColumnName = "category_id")
	private Category category;
	@Column(name = "price")
	private double price;
	@Column(name = "description")
	private String description;
	@Column(name = "imageName")
	private String imageName;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Product(Long id, String name, Category category, double price, String description, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.imageName = imageName;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public String getImageName() {
		return imageName;
	}



	public void setImageName(String imageName) {
		this.imageName = imageName;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
