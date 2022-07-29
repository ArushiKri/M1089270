package com.tideUS.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tideUS.pageObjects.LoginPage;

public class TC008_RecoverPassword extends BaseClass {

	@Test
	public void recover() throws InterruptedException {
		test = extent.createTest("TC008- Recover password");
	
			LoginPage login= new LoginPage(driver);
			driver.get("https://www.pggoodeveryday.com/login/");
			
			login.forgotPassword().click();
			login.forgotEmail().sendKeys("agarwal23871@gmail.com");
			login.submit().click();
			
			test.pass("PAssword was recovered");
			
			
			//el.click();
			//driver.switchTo().alert().getText();
		//	driver.switchTo().alert().accept();
	
}
	
}
