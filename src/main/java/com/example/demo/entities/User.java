package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {
	@Id
	@ApiModelProperty(notes = "unique id of user")
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(notes = "name of user")
	@Column(nullable=false)
	private String Name;
	
	@ApiModelProperty(notes = "Age of user")
	@Column(nullable=false)
	private int age;
	
	@ApiModelProperty(notes = "Gender of user")
	@Column(nullable=false)
	private String Gender;
	
	@ApiModelProperty(notes = "Email of user")
	@Column(nullable=false)
	private String email;
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User( String name, int age, String gender, String email) {
		super();
		Name = name;
		this.age = age;
		Gender = gender;
		this.email = email;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return Gender;
	}



	public void setGender(String gender) {
		Gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + ", age=" + age + ", Gender=" + Gender + ", email=" + email + "]";
	}

	
	
}
