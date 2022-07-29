package com.tideUS.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tideUS.pageObjects.HomePage;
import com.tideUS.pageObjects.SignupPage;

public class TC004_TakeThePledgeTest extends BaseClass {
	
	
	
	@Test
	public void pledge() {
		
		test= extent.createTest("TC004- Take the pledge test ");
	HomePage home= new HomePage(driver);
	driver.get("https://tide.com/en-us");
	//log.info("passsed");
	
	home.LearnMore().click();
	home.TakeThePledge().click();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(home.ThankYou())); // give an element locator, such a way that you can confirm that visibility of that elements represents the complete loading of the page.
	System.out.println(element.getText());
	
	if(element.getText().equals("Thank you!")){
		test.pass("take the pledge functionally exeuted successfully");
		
		Assert.assertTrue(true);
	}
	else {
		Assert.assertTrue(false);
	}
	
	
		
		
		
		
		
		
		
	}
	@AfterClass
	public void endd() {
		extent.flush();
	}
	

	
}
