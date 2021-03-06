package com.ComName.ProName.testCase;

import java.io.IOException;
import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ComName.ProName.pages.HomePage;
import com.ComName.ProName.pages.YourPersonalInformationPage;
import com.ComName.ProName.testBase.TestBase;


public class TC002_Create_an_Account extends TestBase{
	
@BeforeClass	
	public static void isSkip() {
		
		if(!isExecutable("TC002_Create_an_Account"))
			
			throw new SkipException("Skiping this Test Case as it's Run Mode is marked as N in excel sheet");
	}
			
@Test(dataProvider = "Data_Collections")

public static void TC002_Create_An_Account(Hashtable <String, String>  testdata) throws IOException, InterruptedException {
	
	launchBrowser();
	
	HomePage.CreateAnAccount(testdata);

	YourPersonalInformationPage.enterYourPersonalInformation(testdata);

	
	closeBrowser();
}

/*@DataProvider 	
public static Object[][] Data_Collections() {
	
	DataCollection dc = new DataCollection(excel , "Test_Data", "TC002_Create_an_Account");
	
	return dc.dataArray();
	// Hash Table	-- htdata
	}*/
}
