package com.skilldistillery.borrowit.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product {

// Fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonIgnoreProperties({"product"})
	@OneToMany(mappedBy = "product")
	private List<ProductItem> productItems;
	
	private String title;
	private String description;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@JsonIgnoreProperties({"product"})
	@OneToMany(mappedBy="product")
	private List<Rating> ratings;

// Getters and Setters

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public String getTitle() {
		return title;
	}

	public List<ProductItem> getProductItems() {
		return productItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

// No Arg Constructor

	public Product() {
		super();
	}

// Constructor with Fields

	public Product(int id, List<ProductItem> productItems, String title, String description, String imageUrl,
			Category category) {
		super();
		this.id = id;
		this.productItems = productItems;
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
		this.category = category;
	}

// Hash Code and Equals

	@Override
	public int hashCode() {
		return Objects.hash(category, description, id, imageUrl, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return category == other.category && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(title, other.title);
	}

// To String

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", category=" + category + "]";
	}
}
