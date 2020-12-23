package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class People {

	private long id;
	private String name;
	private String email;
	private String dob;
	private String country, avatar;

	public People() {

	}

	public People(String name, String email, String dob, String country, String avatar) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.country = country;
		this.avatar = avatar;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "dob", nullable = false)
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "country", nullable = false)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "avatar", nullable = false)
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "People [id = " + id + ", Name = " + name + ", dob = " + dob + ", email = " + email
				+ ", country = " + country + ", avatar = " + avatar + "]";
	}

}
