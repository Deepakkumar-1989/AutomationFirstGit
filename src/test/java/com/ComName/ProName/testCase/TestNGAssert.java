package com.ComName.ProName.testCase;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.ComName.ProName.testBase.TestBase;


public class TestNGAssert extends TestBase{
	
	@Test
	public static void testNGAssert() {
		
		String expecteds = "deepak";
		String actuals = "deepak.";
		
		//Assert.fail();
		
		Assert.assertEquals(expecteds, actuals);
		System.out.println("Test case passed");
	}

}
