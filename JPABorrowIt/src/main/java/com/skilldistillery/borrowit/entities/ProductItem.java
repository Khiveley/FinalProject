package com.skilldistillery.borrowit.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product_item")
public class ProductItem {

// Entities
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String quality;
	
	@JsonIgnoreProperties({"productItems"})
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private String version;
	
	private Boolean available;
	
// Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
// No Arg Constructor
	
	public ProductItem() {
		super();
	}

	
// Constructor with Fields

public ProductItem(int id, String quality, Product product, User user, String version, Boolean available) {
	super();
	this.id = id;
	this.quality = quality;
	this.product = product;
	this.user = user;
	this.version = version;
	this.available = available;
}
	

// Hash Code and Equals
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductItem other = (ProductItem) obj;
		return id == other.id;
	}
	
// To String
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductItem [id=");
		builder.append(id);
		builder.append(", quality=");
		builder.append(quality);
		builder.append(", product=");
		builder.append(product);
		builder.append(", user=");
		builder.append(user);
		builder.append(", version=");
		builder.append(version);
		builder.append(", available=");
		builder.append(available);
		builder.append("]");
		return builder.toString();
	}
}
