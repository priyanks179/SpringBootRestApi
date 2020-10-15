package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Dao.UserDao;
import com.example.demo.entities.User;
import com.example.demo.request.UserRequest;
import com.example.demo.services.UserServicesImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrudAppApplicationTests {

	@Autowired
	private UserServicesImpl service;
	
	@MockBean
	private UserDao repo;



	@Test
	public void GetUsersTest() {
		when(repo.findAll()).thenReturn(Stream
				.of(new User("priyank",22,"m","priyanks179@gmail.com"), new User("kartik",20,"m","kartik@gmail.com"))
				.collect(Collectors.toList()));

		assertEquals(2,service.getUsers().getUserObj().size() );
	}
	
	@Test
	public void PostUserTest() {
		UserRequest userObj = new UserRequest();
		userObj.setAge(50);
		userObj.setEmail("kartik@gmail.com");
		userObj.setGender("m");
		userObj.setName("kartik");
		
		User user = new User("kartik",50,"m","kartik@gmail.com");
		when(repo.save(user)).thenReturn(user);
		when(repo.findByEmail("kartik@gmail.com")).thenReturn(user);
				
		assertEquals(null,service.postUser(userObj).getUserObj() );
	}
	
	@Test
	public void getUserTest() {
		String id = "2";
		
		User user = new User("Priyank",22,"m", "priyanks179@gmail.com");
		
		when(repo.findById(Long.parseLong(id))).thenReturn(Optional.ofNullable(user));
		User actualObj = service.getUser(id).getUserObj();

		assertEquals(user.getId(), actualObj.getId() );
	}
}
