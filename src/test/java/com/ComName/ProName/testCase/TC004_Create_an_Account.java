package com.ComName.ProName.testCase;

import java.io.IOException;
import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ComName.ProName.Utility.CommonMethods;
import com.ComName.ProName.testBase.TestBase;

public class TC004_Create_an_Account extends TestBase{
	
@BeforeClass	
	public static void isSkip() {
		
		if(!isExecutable("TC004_Create_an_Account"))
			
			throw new SkipException("Skiping this Test Case as it's Run Mode is marked as N in excel sheet");
	}
			
@Test(dataProvider = "Data_Collections")

public static void TC004_Create_An_Account(Hashtable <String, String>  testdata) throws IOException, InterruptedException {
	
	launchBrowser();
	
    CommonMethods.clickOnWebelement("XSignInBtn", "Sign In Button");
	
	CommonMethods.writeIntoInputBox("XEmail_add", testdata, "Email_Id");
	
	CommonMethods.clickOnWebelement("XCreatAcnt_btn", "Create An Account Button");
			
	CommonMethods.clickOnWebelement("XGender", "Mr Title has been selected");
	
	CommonMethods.writeIntoInputBox("XFirstName", testdata, "First_Name");
			
	CommonMethods.writeIntoInputBox("XLastName", testdata, "Last_Name");
	
	CommonMethods.writeIntoInputBox("Xpwd", testdata, "Password");
	
	closeBrowser();
	
}


}
