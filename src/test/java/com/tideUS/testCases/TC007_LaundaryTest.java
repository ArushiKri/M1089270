package com.tideUS.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.tideUS.pageObjects.HomePage;

public class TC007_LaundaryTest extends BaseClass {
	
	@Test
	public void laundary() {
		test = extent.createTest("TC007- laundary Test ");
		HomePage home= new HomePage(driver);
		driver.get("https://tide.com/en-us");
		home.Laundary().click();
		home.skinarticle().click();
		System.out.println(home.article().getText());
		if(home.article().getText().equals("How to Care for Sensitive Skin")){
			test.pass("Laundary test is successul");
			Assert.assertTrue(true);
		}
		else {
			test.fail("Laundary test is not successul");
			Assert.assertTrue(false);
		}
			
	}

}
