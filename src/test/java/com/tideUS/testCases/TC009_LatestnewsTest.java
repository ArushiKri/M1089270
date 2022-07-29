package com.tideUS.testCases;

import org.testng.annotations.Test;

import com.tideUS.pageObjects.HomePage;

public class TC009_LatestnewsTest extends BaseClass {

	
	
	@Test
	public void whatslatest() {
		test = extent.createTest("TC009- Latest news test  Test ");
	HomePage home= new HomePage(driver);
	driver.get("https://tide.com/en-us");
	 home.WhatsNew().click();
	System.out.println(driver.getTitle());
	test.pass("latest news test pass");
	log.info("latest news test pass");
	}
	}


