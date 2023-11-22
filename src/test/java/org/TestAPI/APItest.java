package org.TestAPI;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.Base.APIBaseClass;


public class APItest extends APIBaseClass {

	@Test
	
	private void get() {
		given()
		.when()
		.queryParam("id", 25)
		.queryParam("first_name", "pooja")
		.get("http://localhost:3000/employees")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	/*
	private void post() throws Exception {
		String data = excelRead(0, 0);
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/employees")
		.then()
		.statusCode(201)
		.log().all();
	}
	
	
	private void delete() throws Exception {
//		String data = excelRead(0, 1);
		given()
		.contentType("application/json")
		.body(" {\r\n" + " \"id\" : \"25\"}")
		.when()
		.delete("http://localhost:3000/employees")
		.then()
		.statusCode(404)
		.log().all();
	}
	*/
	}
	
	
	
	
	
	
	



