package com.ComName.ProName.pages;

import java.io.IOException;
import java.util.Hashtable;
import org.junit.Assert;
import com.ComName.ProName.Utility.CommonMethods;
import com.ComName.ProName.testBase.TestBase;

public class HomePage extends TestBase {

	public static void CreateAnAccount(Hashtable<String, String> testdata) throws IOException {

		Assert.assertEquals(CommonMethods.getTitle(), "My Store"); // Verifying the correct lending Page

		CommonMethods.clickOnWebelement("XSignInBtn", "Sign In Button");

		Assert.assertEquals(CommonMethods.getText("XCreateAnAcctText"), "CREATE AN ACCOUNT");

		CommonMethods.writeIntoInputBox("XEmail_add", testdata, "Email_Id");

		CommonMethods.clickOnWebelement("XCreatAcnt_btn", "Create An Account Button");

		Assert.assertTrue("YOUR PERSONAL INFORMATION Page has displayed", CommonMethods.isDisplayed("XperInfotext"));

	}

	public static void AlReadtRegistered(Hashtable<String, String> testdata) throws IOException {

		/*
		 * String Actual_title = driver.getTitle(); Assert.assertEquals(Actual_title,
		 * "My Store");
		 * 
		 * CommonMethods.clickOnWebelement("XSignInBtn", "Sign In Button");
		 * 
		 * String Act_Text =
		 * driver.findElement(By.xpath(OR.getProperty("XCreateAnAcctText"))).getText();
		 * 
		 * Assert.assertEquals(Act_Text, "CREATE AN ACCOUNT");
		 * 
		 * CommonMethods.writeIntoInputBox("XEmail_add", testdata, "Email_Id");
		 * CommonMethods.clickOnWebelement("XCreatAcnt_btn",
		 * "Create An Account Button");
		 */

	}

	public static void ContactUs(Hashtable<String, String> testdata) throws IOException {

		/*
		 * String Actual_title = driver.getTitle(); Assert.assertEquals(Actual_title,
		 * "My Store");
		 * 
		 * CommonMethods.clickOnWebelement("XSignInBtn", "Sign In Button");
		 * 
		 * String Act_Text =
		 * driver.findElement(By.xpath(OR.getProperty("XCreateAnAcctText"))).getText();
		 * 
		 * Assert.assertEquals(Act_Text, "CREATE AN ACCOUNT");
		 * 
		 * CommonMethods.writeIntoInputBox("XEmail_add", testdata, "Email_Id");
		 * CommonMethods.clickOnWebelement("XCreatAcnt_btn",
		 * "Create An Account Button");
		 */

	}

}
