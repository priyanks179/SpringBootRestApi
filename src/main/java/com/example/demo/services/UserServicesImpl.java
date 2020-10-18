package com.example.demo.services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.entities.User;
import com.example.demo.request.UserRequest;
import com.example.demo.response.GetUserResponse;
import com.example.demo.response.GetUsersResponse;
import com.example.demo.response.PostUserResponse;
import com.fasterxml.jackson.core.util.VersionUtil;

@Service // this will tell that it implem some interface
public class UserServicesImpl implements UserServices {
	
	private static final Logger Log = LogManager.getLogger(UserServicesImpl.class);

	@Autowired
	private UserDao userdao;

	
	
	private Properties prop = new Properties();
	
	{try{
		InputStream input = new FileInputStream("WEB-INF/classes/message.properties");
		prop.load(input);


	}catch(Exception e) {
		Log.info(e.getMessage()+"/n");
	}}
	 
	public UserServicesImpl() {
	}
	
	@Override
	public GetUsersResponse getUsers() {
		try {
			List<User> listOfUsers = userdao.findAll();
			if(listOfUsers.isEmpty()) return new GetUsersResponse(200, prop.getProperty("No_user_present"), listOfUsers);
			return new GetUsersResponse(200, prop.getProperty("Success_msg"), listOfUsers);
		}catch(Exception e) {
			Log.info(e.getMessage()+"\n");
			return new GetUsersResponse(404,prop.getProperty("System_error"),null);
		}
		
	}


	@Override
	public GetUserResponse getUser(String userId) {
		try {
			try {
				Long no = Long.parseLong(userId);
			}catch(Exception e){
				return new GetUserResponse(404,prop.getProperty("Number_msg"), null);
			}

			try {
				Optional<User> Obj = userdao.findById(Long.parseLong(userId));
				User uObj = Obj.get();
				return new GetUserResponse(200,prop.getProperty("Success_msg"), uObj);
			}catch(Exception e) {
				return new GetUserResponse(404,prop.getProperty("No_id_msg"), null);
			}
		}catch(Exception e) {
			Log.info(e.getMessage()+"\n");
			return new GetUserResponse(404,prop.getProperty("System_error_msg"),null);
		}
		
		
	}

	@Override
	public PostUserResponse postUser(UserRequest reqObj) {
		try {
			int age = reqObj.getAge();
			String name = reqObj.getName();
			String gender = reqObj.getGender().toLowerCase();
			String email = reqObj.getEmail().toLowerCase();
			
			if( reqObj.getGender()==null || reqObj.getName()==null || reqObj.getAge()==null || reqObj.getEmail()==null) {
				return new PostUserResponse(404,prop.getProperty("Null_msg"), null);
			}
			
			if(!reqObj.getName().matches("[a-zA-Z]+")) {
				return new PostUserResponse(404,prop.getProperty("Name_msg"), null);
			}
			
			if(reqObj.getAge()<18 || reqObj.getAge()>60) {
				return new PostUserResponse(404,prop.getProperty("Age_msg"), null);
			}
			
			if(!(gender.equals("m") || gender.equals("f"))) {
				return new PostUserResponse(404,prop.getProperty("Gender_msg"), null);
			}
			
			if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
				return new PostUserResponse(404,prop.getProperty("Email_msg"), null);
			}
			
			User testUser = userdao.findByEmail(email);
			if(testUser!=null) {
				return new PostUserResponse(400, prop.getProperty("Email_exist_msg"), null);
			}
			
			User userObj = new User();
			userObj.setAge(age);
			userObj.setEmail(email);
			userObj.setGender(gender);
			userObj.setName(name);

			
			userdao.save(userObj);
			PostUserResponse result =  new PostUserResponse(200, prop.getProperty("Success_msg"), userObj);
			return result;
		}catch(Exception e) {
			Log.info(e.getMessage()+"\n");
			return new PostUserResponse(404,prop.getProperty("System_error_msg"), null);
		}
		
	}

}
