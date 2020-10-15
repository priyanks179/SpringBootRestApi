package com.example.demo.response;

import java.util.List;

import com.example.demo.entities.User;

public class GetUsersResponse extends BaseResponse{
	
	List<User> userObj;

	public GetUsersResponse(int status, String message, List<User> uObj) {
		super(status, message);
		userObj = uObj;
		// TODO Auto-generated constructor stub
	}

	public GetUsersResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<User> getUserObj() {
		return userObj;
	}

	public void setUserObj(List<User> userObj) {
		this.userObj = userObj;
	}
	

}
