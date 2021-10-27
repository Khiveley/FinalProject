package com.skilldistillery.borrowit.entities;

import java.util.Objects;

public class Product {

// Fields

	private int id;
	private String title;
	private String description;
	private String imageUrl;
	private int categoryId;

// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

// No Arg Constructor

	public Product() {
		super();
	}

// Constructor with Fields

	public Product(int id, String title, String description, String imageUrl, int categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;

	}

// Hash Code and Equals

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, description, id, imageUrl, title);
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
		return categoryId == other.categoryId && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(title, other.title);
	}

// To String

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", categoryId=" + categoryId + "]";
	}

}
