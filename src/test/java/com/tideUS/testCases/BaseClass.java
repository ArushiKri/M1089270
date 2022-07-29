package com.tideUS.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tideUS.pageObjects.HomePage;
import com.tideUS.pageObjects.LoginPage;
import com.tideUS.pageObjects.SignupPage;
import com.tideUS.utilities.ReadConfig;






public class BaseClass {
	
	public ExtentHtmlReporter  reporter ;
	public ExtentReports extent;
	public ExtentTest logger;

	
	public static WebDriver driver;
	public  Properties prop;
	public  Logger log =  LogManager.getLogger(BaseClass.class);
	public String baseURL;
	public String loginURL;
	//ExtentSparkReporter spark;
	ExtentTest test;
	public static int count=0;
	
	@BeforeClass
	public void setup_reporter() {
		/*
		System.out.println(1);
		htmlReporter =new ExtentHtmlReporter("./reports/extentreport"+java.time.LocalDate.now()+".html");
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		extent=new ExtentReports();
		
		
		extent.setSystemInfo("Organization", "Done");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);*/
		
		
		
		
		reporter = new ExtentHtmlReporter("./reports/ExtentReport"+java.time.LocalDate.now()+".html");
		extent=new ExtentReports();
		
		extent.attachReporter(reporter );
		reporter .config().setEncoding("utf-8");
		reporter .config().setDocumentTitle("Automation Reports");
		reporter .config().setReportName("Automation Test Results");
		reporter .config().setTheme(Theme.DARK);
		reporter.config().setAutoCreateRelativePathMedia(true);
		 
		
		extent.flush();
		
	}
	
	
/*	@AfterMethod
	public void getResult(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.fail(MarkupHelper.createLabel(result.getName()+" Test case failed", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName()+" Test case passed", ExtentColor.GREEN));
		}
		else {
			test.skip(MarkupHelper.createLabel(result.getName()+" Test case skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
		
	}*/
	
	
	   	
	   
	
		@BeforeSuite
		public void setup() throws IOException {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		log.info("hello");
		driver = new ChromeDriver();
		
		 prop = new Properties();
		 
			FileInputStream fis = new FileInputStream("C:\\Users\\mindc1may256\\CA\\tideUS\\Configuration\\config.properties");
			prop.load(fis);
			
			baseURL = prop.getProperty("url");
			loginURL = prop.getProperty("url_");
		// ReadConfig readconfig= new ReadConfig();
	   // baseURL= readconfig.baseURL();
	   
		
		
		//PropertyConfigurator.configure("log4j.properties");
	}
	
		
		
		public String getScreenshot() throws IOException {
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			File dest= new File("./Screenshots/screenshot" + count +"-"+java.time.LocalDate.now()+".png");
			FileUtils.copyFile(src, dest);
			String spath="./Screenshots/screenshot"+count+"-"+java.time.LocalDate.now()+".png";
			count++;
			
			return spath;
		}
	
	
	@AfterSuite
	public void exit() {
		extent.flush();
		//driver.quit();
	}
	

}
