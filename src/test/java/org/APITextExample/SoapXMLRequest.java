package org.APITextExample;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SoapXMLRequest {
	
	@Test
	public void validateSoapXML() throws Exception {
		
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
			body("//*:AddResult.text()", equalTo(5));

}
}
