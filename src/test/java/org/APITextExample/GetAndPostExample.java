package org.APITextExample;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExample {
	
	//@Test
	
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given()
			.get("/users?page=2").
		then()		
			.statusCode(200).
			body("data[3].first_name", equalTo("Byron")).
			body("data.first_name", hasItems("George", "Rachel"));
		

	}
	
	@Test
	public void testPost() {
		Map<String, Object> mp = new HashMap<String, Object>();
//		mp.put("name", "Susant");
//		mp.put("job", "Tester");
//		System.out.println(mp);
		
		JSONObject req = new JSONObject(mp);
		req.put("name", "Susant");
		req.put("job", "Tester");
		System.out.println(req.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
			header("content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log().all();
		
	}
	
	

}
