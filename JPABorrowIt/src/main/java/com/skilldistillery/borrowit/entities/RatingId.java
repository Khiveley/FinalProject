package com.skilldistillery.borrowit.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RatingId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "product_id")
	private int productId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RatingId(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

	public RatingId() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatingId other = (RatingId) obj;
		return productId == other.productId && userId == other.userId;
	}

        // Getters/setters, ctors, toString, equals/hashCode

	
	
}