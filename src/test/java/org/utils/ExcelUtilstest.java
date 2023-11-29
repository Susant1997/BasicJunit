package org.utils;

public class ExcelUtilstest {
	
	public static void main(String[] args) {
		
		String excelPath = "C:\\Users\\susan\\eclipse-workspace\\RestAssureAPI\\data\\Data.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		excel.getRowCount();
		excel.getCellData(2, 1);
		excel.getCellData(2, 2);
		excel.getCellData(2, 3);
	}

}
