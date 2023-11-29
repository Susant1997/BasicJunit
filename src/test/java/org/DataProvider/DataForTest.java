package org.DataProvider;

import org.testng.annotations.DataProvider;

public class DataForTest {
	
	@DataProvider(name = "dataForPost")
	public Object[][] dataForPost() {
		/*
		Object[][] data = new Object[2][3];
		data [0][0] = "Puja";
		data [0][1] = "Thapa";
		data [0][2] = 2;
		
		data [1][0] = "Sus";
		data [1][1] = "Giri";
		data [1][2] = 1;
		return data;
		*/
		
		return new Object[][] {
			{"Raju", "Khadka", 1},
			{"Sanju", "Sharma", 2}
		};

	}
	
	@DataProvider(name = "DeleteData")
	public Object[] dataForDelete() {
		
		return new Object[] {
			4,5,6,7	
		};
	}
}
