package com.skilldistillery.borrowit.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="rating")
public class Rating {
	
	@EmbeddedId
	private RatingId id;

	private int rating;
	@Column(name="rating_comment")
	private String ratingComment;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	@MapsId(value="productId")
	private Product product;

	@ManyToOne
	@JoinColumn(name="user_id")
	@MapsId(value="userId")
	private User user;


	public Rating(int rating, String ratingComment, RatingId id) {
		super();
		this.rating = rating;
		this.ratingComment = ratingComment;
		this.id = id;
	}

	public Rating() {
		super();
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRatingComment() {
		return ratingComment;
	}

	public void setRatingComment(String ratingComment) {
		this.ratingComment = ratingComment;
	}

	public RatingId getId() {
		return id;
	}

	public void setId(RatingId id) {
		this.id = id;
	}

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
		Rating other = (Rating) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rating [rating=");
		builder.append(rating);
		builder.append(", ratingComment=");
		builder.append(ratingComment);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
