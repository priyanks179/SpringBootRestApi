package com.example.demo.services;

import java.util.Map;

import com.example.demo.request.UserRequest;
import com.example.demo.response.GetUserResponse;
import com.example.demo.response.GetUsersResponse;
import com.example.demo.response.PostUserResponse;

public interface UserServices {
	public GetUsersResponse getUsers();
	public GetUserResponse getUser(String userId);
	public PostUserResponse postUser(UserRequest userObj);
	
}
