package com.yipei.zhu.restauranthelper.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Access(AccessType.FIELD)
public class User extends ParentEntity{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -3739215973727746955L;
	
	@Column(name="first_name",nullable=false,length=255)
	private String firstName;
	
	@Column(name="last_name",nullable=false,length=255)
	private String lastName;
	
	@Column(name="email",nullable=false,unique=true,length=50)
	private String email;
	
	@Column(name="password",nullable=false,length=255)
	private String password;
	
	@Column(name="phone",nullable=true,length=30)
	private String phoneNumber;
	
	@Column(name="address",nullable=true,length=255)
	private String address;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastNName) {
		this.lastName = lastNName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
