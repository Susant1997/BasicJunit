package org.APITextExample;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class TestsOnLocalAPI {
	
//	@Test
	
	public void get() {
		baseURI = "http://localhost:3000/";
		given()
		.get("/users").
		then()		
		.statusCode(200). 
		log().all();
	
	}
	
//	@Test
	public void post() {
		JSONObject req = new JSONObject();
		req.put("fristName", "Suraj");
		req.put("lastName", "Giri");
		req.put("subjectID", 1);
		
		baseURI = "http://localhost:3000/";
		given().
			header("content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
		log().all();
	}
	
	
//	@Test
	public void put() {
		JSONObject req = new JSONObject();
		req.put("fristName", "Punam");
		req.put("lastName", "Thapa");
		req.put("subjectID", 2);
		
		baseURI = "http://localhost:3000/";
		given().
			header("content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).
		log().all();
	}
	
	
//	@Test
	public void patch() {
		JSONObject req = new JSONObject();
		
		req.put("lastName", "Giri");
		
		
		baseURI = "http://localhost:3000/";
		given().
			header("content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).
		log().all();
	}
	
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000/";
		given().
		when().
			delete("/users/4").
		then().
			statusCode(404)
			.log().all();
	}
	
}
