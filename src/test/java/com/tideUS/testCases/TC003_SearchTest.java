package com.tideUS.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tideUS.pageObjects.HomePage;
import com.tideUS.pageObjects.LoginPage;
import com.tideUS.pageObjects.SignupPage;
import com.tideUS.utilities.Reporting;

public class TC003_SearchTest extends BaseClass {
	
	

	@Test
	public void search() throws IOException {
		
		
		test= extent.createTest("TC003 - check for search functionality ");
		
		
		HomePage home= new HomePage(driver);
		driver.get("https://tide.com/en-us");
		home.getSearchBox().sendKeys("surf");
		home.getSearchBox().sendKeys(Keys.ENTER);
		

if(home.getResult().getText().equals("Search results")){
	Assert.assertTrue(true);
	test.pass("Search is successful");
	log.info("Search is successful");
	//extent.flush();
}

else {
	test.fail("Search is  not successful");
	
	String url= getScreenshot();
	System.out.println(url);
	
	reporter.config().setAutoCreateRelativePathMedia(true);

	
	
	test.fail("failed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
	
	//test.addScreenCaptureFromPath("C:\\Users\\mindc1may256\\eclipse-workspace\\ProjectFrameworkurl\\Screenshots\\screenshot0-2022-07-28.png" );
	
	log.info("Search is  not successful");
	
	//extent.flush();
	Assert.assertTrue(false);
	
}
		
	}
	
}
	