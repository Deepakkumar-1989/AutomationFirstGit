package com.ComName.ProName;

import java.util.Hashtable;

import org.testng.annotations.Test;

public class HashTable {
	
	@Test
	
	public static void hashTable () {
		
		//ExcelCongic excel = new ExcelCongic("E:\\JAVA Collection\\Java Training\\Master_Sheet.xlsx");
		
	Hashtable <String, String>  htdata =new Hashtable <String, String> ();
	
	htdata.put("First_Name", "Deepak");
	htdata.put("Last_Name", "Kumar");
	htdata.put("Address", "Pune");
	htdata.put("Phone_No", "9762356025");
	
	
	System.out.println("Value in Hash Table is **** " +htdata);
	
	System.out.println(htdata.get("First_Name"));
	System.out.println(htdata.get("Last_Name"));
	System.out.println(htdata.get("Address"));
	System.out.println(htdata.get("Phone_No"));
	
	
	
	}
	
	
	

}
