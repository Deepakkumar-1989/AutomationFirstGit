package com.ComName.ProName.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.ComName.ProName.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.ComName.ProName.Utility.DataCollection;

public class TestBase {

	public static WebDriver driver;
	public static Properties OR;
	public static Properties config;
	public static ExtentReports extents;
	public static ExtentTest test;
	public static String testCaseName, skip=null;

	static String timeStamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());

	public static ExcelReader excel = new ExcelReader("E:\\JAVA Collection\\Java Training\\Master_Sheet.xlsx");
	public static Hashtable<String, String> testCaseRunMode = new Hashtable<String, String>();

	@BeforeSuite

	public static void loadingFilesAndGenerateReport() throws IOException {

		OR = new Properties();
		FileInputStream fis1 = new FileInputStream(
				"E:\\workspaceNew\\MyLearningMvnProject\\src\\test\\resources\\PropertiesFiles\\OR.properties");
		OR.load(fis1);

		System.out.println("********* OR File Loaded ***********");

		config = new Properties();
		FileInputStream fis2 = new FileInputStream(
				"E:\\workspaceNew\\MyLearningMvnProject\\src\\test\\resources\\PropertiesFiles\\config.properties");
		config.load(fis2);

		System.out.println("********* OR File Loaded ***********");
		System.out.println("********* Excel File has been Loaded ***********");

		extents = new ExtentReports(
				"E:\\workspaceNew\\MyLearningMvnProject\\src\\test\\resources\\executionReport\\ExecutionReport_"
						+ timeStamp + ".html");
		loadHashTable(testCaseRunMode, "Test_Cases", "TestCaseName", "Run_Mode");

	}

	// @BeforeMethod
	public static void launchBrowser() throws IOException {

		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "E:\\Automation software\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (config.getProperty("Browser").equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.chrome.driver", "E:\\Automation software\\Driver New\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (config.getProperty("Browser").equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.chrome.driver", "E:\\Automation software\\Driver New\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		test = extents.startTest(testCaseName);

		driver.get(config.getProperty("Application_url"));
		System.out.println("Driver has been launch and redirected to application URL");

	}

	// @AfterMethod
	public static void closeBrowser() {

		driver.quit();
		test.log(LogStatus.PASS, "Test case execution has been conpleted and brouser has been closed");

	}

	@AfterSuite(alwaysRun = true)
	public static void writeIntoExtentReports() {

		extents.endTest(test);
		extents.flush();
	}

	public static void loadHashTable(Hashtable<String, String> testCaseRunMode, String SheetName, String KeyCol,
			String valueCol) {

		int row = excel.getRowCount(SheetName);

		for (int i = 2; i <= row; i++) {

			String key = excel.getCellData(SheetName, KeyCol, i);

			String val = excel.getCellData(SheetName, valueCol, i);

			testCaseRunMode.put(key, val);
		}

		System.out.println(testCaseRunMode);
	}

	public static boolean isExecutable(String TC_name) {
		testCaseName = TC_name;
		if (testCaseRunMode.get(TC_name).equalsIgnoreCase("Y")) { // Run Mode value
			 skip="No" ;
			return true;
		} else {
			 skip="Yes" ;
			return false;
		}
	}

	public static void takeScreenShot() throws IOException {
		
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String timeStamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() 
				+ "\\src\\test\\resources\\screenShots\\PassesdTC\\"+testCaseName+"_" +timeStamp+ ".png";
				
		File destFile = new File(reportDirectory);
		
		FileHandler.copy(scrfile, destFile);
		
		test.log(LogStatus.PASS, test.addScreenCapture(reportDirectory));

	}

	
public static void takeScreenShot_Fail() throws IOException {
		
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String timeStamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() 
				+ "\\src\\test\\resources\\screenShots\\FailedTC\\"+testCaseName+"_" +timeStamp+ ".png";
				
		File destFile = new File(reportDirectory);
		
		FileHandler.copy(scrfile, destFile);
		
		test.log(LogStatus.FAIL, test.addScreenCapture(reportDirectory));

	}
	
	
	
	@DataProvider
	public static Object[][] Data_Collections() {

		DataCollection dc = new DataCollection(excel, "Test_Data", testCaseName);

		return dc.dataArray();
		// Hash Table -- htdata

	}
}
