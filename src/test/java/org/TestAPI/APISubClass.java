package org.TestAPI;

import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;

import org.Base.APIBaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APISubClass extends APIBaseClass {

//	@Test
	public void getTest() throws Exception {
		System.out.println("URL =" + excelRead(0, 1));
		System.out.println("ID =" + excelRead(0, 3));
		
		Response getresponse = getMethod(excelRead(0, 1), excelRead(0, 3));
//		Assert.assertTrue(getresponse.getStatusCode() >= 200 && getresponse.getStatusCode() < 300,
//		        "GET request failed with status code: " + getresponse.getStatusCode()); // Check if the response is successful (status code 2xx)
		String getString = getresponse.asString();
		System.out.println("Post Method Response :" + getString);
		

		Map<Object, Object> map = getresponse.jsonPath().getMap("$");
		Object fname = map.get("first_name");
		Object lname = map.get("last_name");
		Assert.assertEquals(fname, excelRead(0, 4));
		Assert.assertEquals(lname, excelRead(0, 5));
		System.out.println("Get Method Verification Completed");



	}
	@Test
	
	 public void postTest() throws Exception {
		  
		 System.out.println("Data =" +excelRead(1, 3));
	 
		 Response postMethod = postMethod(excelRead(1, 1), excelRead(1, 3)); 
		 String postString = postMethod.asString(); 
		 System.out.println("Post Method Response :" + postString); 
		 
		 Map<String, String> map = postMethod.jsonPath().getMap("$");
		 String string1 = map.get("first_name");
		 System.out.println(string1);
		 String string2 = map.get("last_name");
		 System.out.println(string2);
		 Assert.assertEquals(string1, excelRead(1, 4));
		Assert.assertEquals(string2, excelRead(1, 5));
		 
	
	}
	 

}
