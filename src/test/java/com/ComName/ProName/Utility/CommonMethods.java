package com.ComName.ProName.Utility;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import com.ComName.ProName.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods extends TestBase {

	public static void clickOnWebelement(String xpath, String webelement) throws IOException {

		try {
			driver.findElement(By.xpath(OR.getProperty(xpath))).click();
			test.log(LogStatus.PASS, webelement + " has been clicked");
			takeScreenShot();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error while clicking element :- " + e.getMessage());
			takeScreenShot_Fail();
		}
	}

	public static void writeIntoInputBox(String xpath, Hashtable<String, String> testdata, String value)
			throws IOException {

		try {
			driver.findElement(By.xpath(OR.getProperty(xpath))).sendKeys(testdata.get(value));
			test.log(LogStatus.PASS, value + " has been entered");
			takeScreenShot();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error while entring value into text box :- " + e.getMessage());
			takeScreenShot_Fail();

		}

	}

	public static String getText(String xpath) {

		String Actual_Text = driver.findElement(By.xpath(OR.getProperty(xpath))).getText();
		test.log(LogStatus.PASS, "String on the screen is :- " + Actual_Text);
		return Actual_Text;
	}

	public static String getTitle() throws IOException {
		String Actual_title = driver.getTitle();
		test.log(LogStatus.PASS, "Page title is :- " + Actual_title);

		return Actual_title;
	}

	public static Boolean isDisplayed(String xpath) {

		Boolean webelement = driver.findElement(By.xpath(OR.getProperty(xpath))).isDisplayed();
		test.log(LogStatus.PASS, "String on the screen is :- " + webelement);
		return webelement;
	}

	public static void selectByIndex(String xpath, Hashtable<String, String> testdata, String HTKey,
			String webelement) {

		// Mechanism to select the value by Index for drop down
	}

	public static void selectByVisibleText(String xpath, Hashtable<String, String> testdata, String HTKey,
			String webelement) {

		// Mechanism to select the value by VisibleText for drop down
	}

	public static void selectByValue(String xpath, Hashtable<String, String> testdata, String HTKey,
			String webelement) {

		// Mechanism to select the value by Value for drop down
	}

	public static void getDropDownValues(String xpath, Hashtable<String, String> testdata, String HTKey,
			String webelement) {

		// Mechanism to select the value by Value for drop down
	}
	
	public static void verifyDropDownValues(String xpath, Hashtable<String, String> testdata, String HTKey,
			String webelement) {

		// Mechanism to select the value by Value for drop down
	}

}
