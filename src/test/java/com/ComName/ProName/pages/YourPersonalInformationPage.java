package com.ComName.ProName.pages;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.Assert;

import com.ComName.ProName.testBase.TestBase;
import com.ComName.ProName.Utility.CommonMethods;

public class YourPersonalInformationPage extends TestBase {
	
	public static void enterYourPersonalInformation(Hashtable<String, String> testdata) throws IOException {

		
		Assert.assertTrue("Mr Title has displayed", CommonMethods.isDisplayed("XGender"));
		
		CommonMethods.clickOnWebelement("XGender", "Mr Title has been selected");
		
		//Assert.assertEquals(CommonMethods.getTitle(), "My Store"); // Verifying the correct lending Page

		CommonMethods.writeIntoInputBox("XFirstName", testdata, "First_Name");

		//Assert.assertEquals(CommonMethods.getText("XCreateAnAcctText"), "CREATE AN ACCOUNT");

		CommonMethods.writeIntoInputBox("XLastName", testdata, "Last_Name");

		//Assert.assertTrue("YOUR PERSONAL INFORMATION Page has displayed", CommonMethods.isDisplayed("XperInfotext"));
		
		CommonMethods.writeIntoInputBox("Xpwd", testdata, "Password");

	}

}
