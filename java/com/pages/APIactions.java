package com.pages;

import com.cucumberFramework.APIUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIactions {

	 private Response response;
	 
	public void launchurl() {
		response=RestAssured.given().get("https://reqres.in/api/users");
		
		System.out.println(response.asString());
		System.out.println(getStatusCode(response));
		
	}
	
	 public int getStatusCode(Response response) {
	        return response.statusCode();
	    }
	 
	public void postURL() {
		RestAssured.given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body("{\"name\":\"morpheus\",\"job\":\"leader\"}")
		.post("https://reqres.in/api/users")
		.then().statusCode(201).log().body();
	}
	
}
