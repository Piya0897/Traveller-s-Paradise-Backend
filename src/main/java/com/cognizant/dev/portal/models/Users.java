package com.cognizant.dev.portal.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table (name = "users")
@NamedNativeQuery(name = "Users.getBookingsByUserId",query = "select distinct * from booking as b where b.user_user_id = ?1",resultClass = Booking.class)
public class Users {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "user_id")
	private long userId;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "email", length = 50)
	private String email;
	
	@Column (name = "first_name", length = 50)
	private String firstName;
	@Column (name = "last_name", length = 50)
	private String lastName;
	

	@Column (name = "telephone", length = 15)
	private String telephone;
	
	
	/*@JsonManagedReference*/
	@OneToMany (cascade = CascadeType.ALL,  orphanRemoval = true, fetch = FetchType.LAZY)
	Set<Booking> listOfBookings;

	
	public Users() {
		
	}

	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Set<Booking> getListOfBookings() {
		return listOfBookings;
	}

	public void addBooking(Booking booking) {
		this.listOfBookings.add(booking);
	}

	public void setListOfBookings(Set<Booking> listOfBookings) {
		this.listOfBookings = listOfBookings;
	}


	public Users(long userId, String password, String email, String firstName, String lastName, String telephone) {
		super();
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", telephone=" + telephone + ", listOfBookings=" + listOfBookings
				+ ", getUserId()=" + getUserId() + ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getTelephone()="
				+ getTelephone() +  ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

    
	
	
}
	