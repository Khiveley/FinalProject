package com.skilldistillery.borrowit.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	//ToString
	@Override
	public String toString() {
		return "Borrow [id=" + id + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + "]";
	}
	
	
	
	
	
	

}
