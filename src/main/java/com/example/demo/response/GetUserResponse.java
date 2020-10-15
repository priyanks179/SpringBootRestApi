package com.example.demo.response;

import com.example.demo.entities.User;

public class GetUserResponse extends BaseResponse{
	
	User userObj;

	public GetUserResponse(int status, String message, User uObj) {
		super(status, message);
		userObj = uObj;
		// TODO Auto-generated constructor stub
	}

	public User getUserObj() {
		return userObj;
	}

	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}
	

}
