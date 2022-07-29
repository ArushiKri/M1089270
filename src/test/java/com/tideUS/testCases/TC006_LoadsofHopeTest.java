package com.tideUS.testCases;

import org.testng.annotations.Test;

import com.tideUS.pageObjects.HomePage;

public class TC006_LoadsofHopeTest extends BaseClass{
	@Test
	public void hope() {
		test=extent.createTest("checkk for Loads of hope functionality");
	HomePage home= new HomePage(driver);
	driver.get("https://tide.com/en-us");
	 home.LoadsOfHope().click();
	System.out.println(driver.getTitle());
	test.pass("shopping is successul");
	
	}

}
