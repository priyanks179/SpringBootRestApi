package com.example.demo.request;

import io.swagger.annotations.ApiModelProperty;

public class UserRequest {
	private String name;
	private Integer age;
	private String gender;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email + "]";
	}
	public UserRequest(String name, Integer age, String gender, String email) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}
	 public UserRequest() {
		 
	 }
}
