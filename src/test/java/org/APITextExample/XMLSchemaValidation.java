package org.APITextExample;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation {
	
	@Test
	 public void schemaXMLValidation() throws Exception {
		File f = new File("C:\\Users\\susan\\eclipse-workspace\\RestAssureAPI\\SoapRequest\\Add.xml");
		if (f.exists()) {
			System.out.println("File Exists");
		}
		
		FileInputStream fi = new FileInputStream(f);
		String requestBody = IOUtils.toString(fi, "UTF-8");
		
		baseURI = "https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService";
		given().
			contentType("text/xml"). 
			accept(ContentType.XML).
			body(requestBody). 
		when().	
			post("/Calc.asmx").
		then(). 
			statusCode(200).log().all().
		and().
//			body("//*:AddResult/text()", equalTo(5));
			assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Calculator.xsd"));


	}

}
