package com.ComName.ProName.customListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.ComName.ProName.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class Listener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) { // Getting started 
		
		if(skip == "No") { // Skip if Run mode is "Y"
		try {
			launchBrowser();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
	}

	public void onTestSuccess(ITestResult result) { // When TC get Passed
		
		if(result.isSuccess()) {
			
			test.log(LogStatus.PASS, " *** Excript execution for "+testCaseName+ " is completed***");
			Reporter.log(" *** Excript execution for "+testCaseName+ " is completed***");
			closeBrowser();
			
		}
		
	}

	public void onTestFailure(ITestResult result) { // When TC get Failed
		
		if(!result.isSuccess()) {
			String formater = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
			String methodName = result.getName();
			test.log(LogStatus.FAIL, " Test Case Fail due to :- "+ result.getThrowable());
			Reporter.log(" Test Case Fail due to :- "+ result.getThrowable());
			
			try {
				File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() 
						+ "\\src\\test\\resources\\screenShots\\FailedTC\\"+methodName+"_" +formater+ ".png";
						
				File destFile = new File(reportDirectory);
				
				FileHandler.copy(scrfile, destFile);
				
				test.log(LogStatus.FAIL, test.addScreenCapture(reportDirectory));
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			test.log(LogStatus.FAIL, "*** Script execution for :- "+ testCaseName + " is failed. ***");
			Reporter.log("*** Script execution for :- "+ testCaseName + " is failed. ***");
		}
		closeBrowser();
		
	}

	public void onTestSkipped(ITestResult result) { // When Test case get Skipped
		
		System.out.println("Test Case got skipped as Run mode is 'N' in excel sheet");
		Reporter.log(testCaseName + "Test Case got skipped as Run mode is 'N' in excel sheet");
		
		//*****************************************************************
		
		if(skip == "No") {
			
			test.log(LogStatus.WARNING, " Test Case has skipped due to :- "+ result.getThrowable());
			Reporter.log(" Test Case has skipped due to :- "+ result.getMethod().getMethodName());
			closeBrowser();
		}
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { // on Fail but 50% -50%
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
