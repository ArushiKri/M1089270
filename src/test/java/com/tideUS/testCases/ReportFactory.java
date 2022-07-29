package com.tideUS.testCases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportFactory {
	
	public ExtentTest logger;

	
	public static WebDriver driver;
	public  Properties prop;
	public  Logger log =  LogManager.getLogger(BaseClass.class);
	public String baseURL;
	//ExtentSparkReporter spark;
	ExtentTest test;
	public static int count=0;
	
	public static ExtentReports set() {
		ExtentReports extent;
		ExtentHtmlReporter  reporter ;
		String path="./reports/ExtentReport"+java.time.LocalDate.now()+".html";
		reporter = new ExtentHtmlReporter("./reports/ExtentReport"+java.time.LocalDate.now()+".html");
		extent=new ExtentReports();
		
		extent.attachReporter(reporter );
		reporter .config().setEncoding("utf-8");
		reporter .config().setDocumentTitle("Automation Reports");
		reporter .config().setReportName("Automation Test Results");
		reporter .config().setTheme(Theme.DARK);
		reporter.config().setAutoCreateRelativePathMedia(true);
		return extent;
	}

}
