package com.skilldistillery.borrowit.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Borrow {
	
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="borrow_date")
	private LocalDateTime borrowDate;
	
	@Column(name="return_date")
	private LocalDateTime returnDate;
	
	@Column(name="product_item_id")
	private int productItem;
	
	@Column(name="borrower_id")
	private int borrowerId;
	
	@Column(name="borrower_rating")
	private int borrowerRating;
	@Column(name="borrower_rating_comments")
	private String borrowerRatingComment;
	@Column(name="lender_rating")
	private int lenderRating;
	@Column(name="lender_rating_comments")
	private String lenderRatingComment;
	
	@ManyToOne
	@JoinColumn(name="lender_id")
	private User user;
	
	
	//Constructors

	public Borrow() {
		super();
	}
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDateTime borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	
	
	public int getProductItem() {
		return productItem;
	}
	
	public void setProductItem(int productItem) {
		this.productItem = productItem;
	}
	
	public int getBorrowerId() {
		return borrowerId;
	}
	
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	
	
	public int getBorrowerRating() {
		return borrowerRating;
	}
	
	public void setBorrowerRating(int borrowerRating) {
		this.borrowerRating = borrowerRating;
	}
	
	public String getBorrowerRatingComment() {
		return borrowerRatingComment;
	}
	
	public void setBorrowerRatingComment(String borrowerRatingComment) {
		this.borrowerRatingComment = borrowerRatingComment;
	}
	
	public int getLenderRating() {
		return lenderRating;
	}
	
	public void setLenderRating(int lenderRating) {
		this.lenderRating = lenderRating;
	}
	
	public String getLenderRatingComment() {
		return lenderRatingComment;
	}
	
	public void setLenderRatingComment(String lenderRatingComment) {
		this.lenderRatingComment = lenderRatingComment;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	

	//hashcode and equals
	

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
		Borrow other = (Borrow) obj;
		return id == other.id;
	}

	public Borrow(int id, LocalDateTime borrowDate, LocalDateTime returnDate, int productItem, int borrowerId,
			int borrowerRating, String borrowerRatingComment, int lenderRating, String lenderRatingComment, User user) {
		super();
		this.id = id;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.productItem = productItem;
		this.borrowerId = borrowerId;
		this.borrowerRating = borrowerRating;
		this.borrowerRatingComment = borrowerRatingComment;
		this.lenderRating = lenderRating;
		this.lenderRatingComment = lenderRatingComment;
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Borrow [id=");
		builder.append(id);
		builder.append(", borrowDate=");
		builder.append(borrowDate);
		builder.append(", returnDate=");
		builder.append(returnDate);
		builder.append(", productItem=");
		builder.append(productItem);
		builder.append(", borrowerId=");
		builder.append(borrowerId);
		builder.append(", borrowerRating=");
		builder.append(borrowerRating);
		builder.append(", borrowerRatingComment=");
		builder.append(borrowerRatingComment);
		builder.append(", lenderRating=");
		builder.append(lenderRating);
		builder.append(", lenderRatingComment=");
		builder.append(lenderRatingComment);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
}
