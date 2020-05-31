package com.ComName.ProName;

import java.util.Hashtable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ComName.ProName.Utility.DataCollection;


public class ReadingDataFromXlsx {
	
	static ExcelReader excel = new ExcelReader("E:\\JAVA Collection\\Java Training\\Master_Sheet.xlsx");
	
@Test(dataProvider = "Data_Collections")
	public void dataReading(Hashtable <String, String>  xyzht)
	{
		
 	
	/*String s = excel.getCellData("Test_Cases",1,2);
	System.out.println("The out put of sheet is -  "+ s);
	
	String s1 = excel.getCellData("Test_Data",1,3);
	System.out.println("The out put of sheet is -  "+ s1);
	
	String s2 = excel.getCellData("Test_Cases","TestCaseName",5);
	System.out.println("The out put of sheet is -  "+ s2);*/
	
System.out.println("Value in Hash Table is **** " +xyzht);
	
	System.out.println(xyzht.get("First_Name"));
	System.out.println(xyzht.get("Last_Name"));
	System.out.println(xyzht.get("Address"));
	System.out.println(xyzht.get("Phone_No"));
	
	}
	
@DataProvider 	
public static Object[][] Data_Collections() {
	
	DataCollection dc = new DataCollection(excel , "Test_Data", "TC005_Create_an_Account");
	
	return dc.dataArray();
	// Hash Table	-- htdata
	

}

}
