package org.DataProvider;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DataDrivenExample extends DataForTest {
	
	//@Test(dataProvider = "dataForPost")
	public void testPost(String firstName, String lastname, int subjectId) {
		
		JSONObject req = new JSONObject();
		req.put("first_name", firstName);
		req.put("last_name", lastname);
		req.put("subjectId", subjectId);
		System.out.println(req.toJSONString());
		
		baseURI = "http://localhost:3000";
		given().
			header("content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/employees").
		then().
			statusCode(201)
			.log().all();
		
	}
	
	
	
	@Test(dataProvider = "DeleteData")
	public void testDelete(int userId) {
		
		baseURI = "http://localhost:3000";
		given().
		when().
			delete("/employees/"+userId).
		then().
			statusCode(404)
			.log().all();
		
	}
	
	@Parameters({"userId"})
	@Test
	public void testDelete2(int userId) {
		System.out.println("Value for userId is : " + userId);
		baseURI = "http://localhost:3000";
		given().
		when().
			delete("/employees/"+userId).
		then().
			statusCode(404)
			.log().all();
		
	}
	
}
