package com.skilldistillery.borrowit.entities;

import java.util.Objects;

public class ProductItem {

// Entities
	
	private int id;
	private String quality;
	private int productId;
	private int userId;
	private String version;
	
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
// No Arg Constructor
	
	public ProductItem() {
		super();
	}

	
// Constructor with Fields
	
	public ProductItem(int id, String quality, int productId, int userId, String version) {
		super();
		this.id = id;
		this.quality = quality;
		this.productId = productId;
		this.userId = userId;
		this.version = version;
	}
	
// 	@Override
	public int hashCode() {
		return Objects.hash(id, productId, quality, userId, version);
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
		return id == other.id && productId == other.productId && Objects.equals(quality, other.quality)
				&& userId == other.userId && Objects.equals(version, other.version);
	}
	
// To String
	
	@Override
	public String toString() {
		return "ProductItem [id=" + id + ", quality=" + quality + ", productId=" + productId + ", userId=" + userId
				+ ", version=" + version + "]";
	}
	

	

}
