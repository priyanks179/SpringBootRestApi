package com.example.demo.response;

import com.example.demo.entities.User;

public class PostUserResponse extends BaseResponse {
	
	private User userObj;
	public PostUserResponse(int status, String msg, User uObj) {
		super(status, msg);
		this.userObj= uObj;
	}
	public User getUserObj() {
		return userObj;
	}
	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}
	@Override
	public String toString() {
		return "PostUserResponse [userObj=" + userObj + ", status=" + status + ", message=" + message + "]";
	}
	
}
