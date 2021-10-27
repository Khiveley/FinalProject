package com.skilldistillery.borrowit.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String category;
	
	@OneToMany(mappedBy="category")
	private List<Product> products;
	
	
	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProducts(Product product) {
		if(products == null) products = new ArrayList<>();
		
		if(!products.contains(product)) {
			products.add(product);
			if(product.getCategory() !=null) {
				product.getCategory().getProducts().remove(product);
			}
			product.setCategory(this);
		}
	}
	
	public void removeProduct(Product product) {
		product.setCategory(null);
		if(product !=null) {
			products.remove(products);
		}
	}

	public Category() {}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + " ]";
	}
}
