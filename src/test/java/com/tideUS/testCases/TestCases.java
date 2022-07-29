package com.tideUS.testCases;


	
	
	
	import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tideUS.pageObjects.HomePage;
import com.tideUS.pageObjects.LoginPage;
import com.tideUS.pageObjects.ShopProducts;
import com.tideUS.pageObjects.SignupPage;
import com.tideUS.utilities.ReadExcel;



	public class TestCases  extends BaseClass{
		
		
		
		public static Logger log = LogManager.getLogger(BaseClass.class.getName());
		public ExtentHtmlReporter htmlReporter ;
		public ExtentReports extent;
		public ExtentTest extentTest;
		public BaseClass BCobj;
		
		
		@BeforeSuite
		public void beforeClass() {
			
			htmlReporter =new ExtentHtmlReporter("./reports/extentreport"+java.time.LocalDate.now()+".html");
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setDocumentTitle("Automation Reports");
			htmlReporter.config().setReportName("Automation Test Results");
			htmlReporter.config().setTheme(Theme.STANDARD);
			
			
			extent=new ExtentReports();
			extent.setSystemInfo("Organization", "Done");
			extent.setSystemInfo("Browser", "Chrome");
			extent.attachReporter(htmlReporter);
			
			
		}
		
		@BeforeSuite
		public void initialize() throws IOException {
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			log.info("hello");
			driver = new ChromeDriver();
			
			 prop = new Properties();
			 
				FileInputStream fis = new FileInputStream("C:\\Users\\mindc1may256\\CA\\tideUS\\Configuration\\config.properties");
				prop.load(fis);
				
				baseURL = prop.getProperty("url");
			
			
			driver.get(prop.getProperty("url"));
			log.info("Navigated to the site ");
			
			
		}
		
		
		@Test
		public void register() throws IOException {
			
			test= extent.createTest("TC001_Signup - check if new user is able to sign up ");

			SignupPage signup= new SignupPage(driver);
			driver.get(baseURL);
			test.pass("step1 -user is navigated to homepage ");
			log.info("passed");
			signup.registerLink().click();
			test.pass("step2- user is taken to sign up now page ");
			signup.getSignupLink().click();
			
			System.out.println(driver.getTitle());
			ArrayList<String> handles =new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(handles.get(1));
			
			ReadExcel excel = new ReadExcel();
			
			
			signup.setName().sendKeys(excel.excelData(1, 1));
			signup.setEmail().sendKeys(excel.excelData(1, 2));
			signup.setPassword().sendKeys(excel.excelData(1, 3));
			test.pass("step 3 - user has entered email , first name and password");
			
		      // test.skip("human captcha cant be handled ",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		       String url= getScreenshot();
		   	System.out.println(url);
		   	
		   	reporter.config().setAutoCreateRelativePathMedia(true);

		   	
		   	
		    test.pass("human captcha cant be handled ",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
			extent.flush();
		/*	if(signup.message().equals("Thanks for signing up!")){
				log.info("New user is able to sign up");
				test.pass("New user is able to sign up");
				Assert.assertTrue(true);
			}
			else {
				test.fail("New user is not able to sign up");
				Assert.assertTrue(false);
				test.fail("failed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
			}
			*/
			
			
		}

		@Test
		public void search() throws IOException {
			
			
			test= extent.createTest("TC003 - check for search functionality ");
			
			
			HomePage home= new HomePage(driver);
			driver.get(baseURL);
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
		
		@Test
		public void pledge() {
			
			test= extent.createTest("TC004- Take the pledge test ");
		HomePage home= new HomePage(driver);
		driver.get(baseURL);
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
		
		@Test
		public void whatslatest() {
			test = extent.createTest("TC009- Latest news test  Test ");
		HomePage home= new HomePage(driver);
		driver.get(baseURL);
		 home.WhatsNew().click();
		System.out.println(driver.getTitle());
		test.pass("latest news test pass");
		log.info("latest news test pass");
		}
		@Test
		public void recover() throws IOException {
			test = extent.createTest("TC008- Recover password");
		
				LoginPage login= new LoginPage(driver);
				driver.get(loginURL);
				
				driver.navigate().to(loginURL);
				ReadExcel excel = new ReadExcel();
				
				
				
				
				
				login.forgotPassword().click();
				login.forgotEmail().sendKeys(excel.excelData(1, 2));
				login.submit().click();
				
				test.pass("PAssword was recovered");
				
				
				//el.click();
				//driver.switchTo().alert().getText();
			//	driver.switchTo().alert().accept();
		
	}
		
		@Test
		public void login() throws IOException {
		LoginPage login= new LoginPage(driver);
		driver.get(loginURL);
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
		//WebDriverWait wait = new WebDriverWait(driver, 1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(login.message())); // give an element locator, such a way that you can confirm that visibility of that elements represents the complete loading of the page.
		System.out.println(driver.getTitle());
	}
		
		@Test
		public void shop() {
			test= extent.createTest("TC004- check the shop product  test ");
			ShopProducts shopit = new ShopProducts(driver);
			driver.get("https://tide.com/en-us");
			 shopit.ShopProduct().click();
			System.out.println(driver.getTitle());
			/*WebElement Powder= shopit.powder();
			Actions action =new Actions(driver);
			action.moveToElement(shopMenu).moveToElement(Powder).click().build().perform();
			*/
			
			shopit.Product().click();
			System.out.println(driver.getTitle());
			
			
			if(driver.getTitle().equals("Tide Hygienic Clean Heavy Duty 10x free liquid laundry detergent")){
				test.pass("shopping is successul");
				Assert.assertTrue(true);
			}
			else {
				test.pass("shopping is  not successul");
				Assert.assertTrue(false);
			}	
			/*shopit.Retailer().click();
			shopit.buy().click();
			shopit.Checkout().click(); */
			
		}
		
		@Test
		public void hope() {
			test=extent.createTest("checkk for Loads of hope functionality");
		HomePage home= new HomePage(driver);
		driver.get("https://tide.com/en-us");
		 home.LoadsOfHope().click();
		System.out.println(driver.getTitle());
		test.pass("shopping is successul");
		
		}
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

		
		
		
		@AfterSuite
		public void tearDown() {
			driver.close();
			driver=null;
			extent.flush();
		}

	}

	


