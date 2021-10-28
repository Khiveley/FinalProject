package com.skilldistillery.borrowit.entities;


import java.time.LocalDateTime;
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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	@CreationTimestamp
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	private Boolean enabled;
	private String role;
	
	@Column(name="profile_image")
	private String profileImage;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@JsonIgnoreProperties({"user"})
	@OneToMany(mappedBy="user")
	private List<Borrow> borrows;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Rating> ratings;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<ProductItem> products;
	
	
	//constructor
	public User(int id, String username, String password, Boolean enabled, String role, Address address,
			List<Borrow> borrows, List<Rating> ratings, List<ProductItem> products) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.address = address;
		this.borrows = borrows;
		this.ratings = ratings;
		this.products = products;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}


	public String getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}


	//no arg constructor
	public User() {
		super();
	}
	

	// setters and getters	
	public List<Borrow> getBorrows() {
		return borrows;
	}
	public void setBorrow(List<Borrow>  borrows) {
		this.borrows = borrows;
	}
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<ProductItem> getProducts() {
		return products;
	}

	public void setProducts(List<ProductItem> products) {
		this.products = products;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}


	// hashcode and equals
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
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", createDate=" + createDate + ", enabled=" + enabled
				+ ", role=" + role + ", profileImage=" + profileImage + "]";
	}  
}