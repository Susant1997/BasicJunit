package org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APIBaseClass {

	static String attribute;
	static String value;
	
	public Response getMethod(String url, String id) throws IOException {
//		String id = excelRead(0, 3);
//		int i = Integer.parseInt(id);
		
		Response response = given()
		.when()
		.queryParam("id", id)
		.get(url);
		
		return response;
	}
	
	public Response postMethod(String url,  String data) {
		Response post = given()
		.contentType("application/json")
		.body(data)
		.when()
		.post(url);
		
		return post;

	}

	public static String excelRead(int rowNo, int cellNo) throws IOException {

		File f = new File("C:\\Users\\susan\\eclipse-workspace\\RestAssureAPI\\data\\API data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);

		int cellType = c.getCellType();
		// Type ==1 - String
		// Type ==0 - Integer
		if (cellType == 1) {

			value = c.getStringCellValue();
		}

		if (cellType == 0) {

			if (DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat dateformate = new SimpleDateFormat("dd/MM/yy");
				value = dateformate.format(date);

			}

			else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				value = String.valueOf(l);
			}

		}
		return value;

	}

	public static void writeExcel(int rowNo, int cellNo1) throws IOException {
		File f = new File("C:\\Users\\susan\\eclipse-workspace\\RestAssureAPI\\data\\API data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet s = wb.getSheet("Sheet2");
//		Row r = s.createRow(rowNo);
		Row r = s.getRow(rowNo);
		Cell c1 = r.createCell(cellNo1);
		c1.setCellValue(attribute);
//		Cell c2 = r.createCell(cellNo2);
//		c2.setCellValue(value2);
//		Cell c3 = r.createCell(cellNo3);
//		c3.setCellValue(value3);
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
	}

}
