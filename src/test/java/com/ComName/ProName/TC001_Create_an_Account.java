package com.ComName.ProName;

import java.io.IOException;
import java.util.Hashtable;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ComName.ProName.Utility.DataCollection;
import com.ComName.ProName.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class TC001_Create_an_Account extends TestBase{
			
@Test(dataProvider = "Data_Collections")

public static void TC001_Create_An_Account(Hashtable <String, String>  testdata) throws IOException, InterruptedException {
	
	test = extents.startTest("TC001_Create_an_Account"); 
		
	driver.findElement(By.xpath(OR.getProperty("XSignInBtn"))).click();
	System.out.println("Sign In button has been clicked");
	test.log(LogStatus.PASS, "Sign In button has been clicked");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(OR.getProperty("XEmail_add"))).sendKeys(config.getProperty("EmailAdd"));
	System.out.println("Email has been entered");
	test.log(LogStatus.PASS, "Email has been entered");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(OR.getProperty("XCreatAcnt_btn"))).click();
	System.out.println("Create an account button has been clicked");
	test.log(LogStatus.PASS, "Create an account button has been clicked");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(OR.getProperty("XGender"))).click();
	System.out.println("Mr Title has been selected");
	test.log(LogStatus.PASS, "Mr Title has been selected");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(OR.getProperty("XFirstName"))).sendKeys(testdata.get("First_Name"));
	System.out.println("First Name has been entered from excel file");
	test.log(LogStatus.PASS, "First Name has been entered from excel file");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(OR.getProperty("XLastName"))).sendKeys(testdata.get("Last_Name"));
	System.out.println("Last Name has been entered from excel file");
	test.log(LogStatus.PASS, "Last Name has been entered from excel file");
	Thread.sleep(2000);
	
}

@DataProvider 	
public static Object[][] Data_Collections() {
	
	DataCollection dc = new DataCollection(excel , "Test_Data", "TC001_Create_an_Account");
	
	return dc.dataArray();
	// Hash Table	-- htdata
	

}
}
