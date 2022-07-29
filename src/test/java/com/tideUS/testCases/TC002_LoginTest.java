package com.tideUS.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tideUS.pageObjects.LoginPage;
import com.tideUS.pageObjects.SignupPage;
import com.tideUS.utilities.ReadExcel;

public class TC002_LoginTest extends BaseClass {
	@Test
	public void login() throws IOException {
	LoginPage login= new LoginPage(driver);
	driver.get("https://www.pggoodeveryday.com/login/");
	/*login.registerLink().click();
	login.getSignupLink().click();
	System.out.println(driver.getTitle());
	ArrayList<String> handles =new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(handles.get(1));
	WebElement ele = login.getLoginLink();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", ele);
	
	*/
	 
	driver.navigate().to(loginURL);
	ReadExcel excel = new ReadExcel();
	
	
	
	login.setEmail().sendKeys(excel.excelData(1, 2));
	login.setPassword().sendKeys(excel.excelData(1, 3));
	
	login.submit().click();
	//WebDriverWait wait = new WebDriverWait(driver, 1000);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(login.message())); // give an element locator, such a way that you can confirm that visibility of that elements represents the complete loading of the page.
	System.out.println(driver.getTitle());
}
}

