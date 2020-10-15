package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.UserRequest;
import com.example.demo.response.GetUserResponse;
import com.example.demo.response.GetUsersResponse;
import com.example.demo.response.PostUserResponse;
import com.example.demo.services.UserServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("User CRUD Resource")
public class MyController {

	@Autowired
	private UserServices obj;
	

	@ApiOperation(value="Returns All the users present in DB")
	@GetMapping("/v1/users")
	public GetUsersResponse GetUsers(){
		return this.obj.getUsers();
		
	}
	
	@ApiOperation(value="Returns user of specific Id")
	@GetMapping("/v1/user/{userId}")
	public GetUserResponse GetUser(@PathVariable String userId){
		//pathVar will put this userId in param to this func arg
		
		return this.obj.getUser(userId);
	}
	
	
	@ApiOperation(value="Saves user to DB")
	@PostMapping("/v1/user")
	public PostUserResponse PostUser(@RequestBody UserRequest reqObj) {
		return this.obj.postUser(reqObj);
		
	}
}
