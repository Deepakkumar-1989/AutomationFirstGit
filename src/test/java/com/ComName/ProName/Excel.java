package com.ComName.ProName;

public class Excel {

	public static void main(String[] args) {
		
		ExcelReader excel = new ExcelReader("E:\\JAVA Collection\\Java Training\\Master_Sheet.xlsx");
		
		String s = excel.getCellData("Test_Cases",1,2);
		System.out.println("The out put of sheet is -  "+ s);
		
		String s1 = excel.getCellData("Test_Data",1,6);
		System.out.println("The out put of sheet is -  "+ s1);
		
		String s2 = excel.getCellData("Test_Cases","TestCaseName",5);
		System.out.println("The out put of sheet is -  "+ s2);
		int row = excel.getRowCount("Test_Cases");
		System.out.println("The out put of sheet is -  "+ row);
		int row2 = excel.getRowCount("Test_Cases");
		System.out.println("The out put of sheet is -  "+ row2);
		

	} 

}
