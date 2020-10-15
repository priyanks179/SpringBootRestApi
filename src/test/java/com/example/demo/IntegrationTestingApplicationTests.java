package com.example.demo;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class IntegrationTestingApplicationTests {
	

	
	@org.testng.annotations.Test
	public void getUserAutomation() {
		
		Response resp = given().when().get("http://localhost:8080/v1/users");
		resp.then().assertThat().statusCode(200);
//		given().when().get("localhost:8080/v1/users").then().log().body();
		 
	}

}
