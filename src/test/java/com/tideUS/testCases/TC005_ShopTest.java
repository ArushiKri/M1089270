package com.tideUS.testCases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.tideUS.pageObjects.ShopProducts;

public class TC005_ShopTest extends BaseClass{
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
			test.fail("shopping is  not successul");
			Assert.assertTrue(false);
		}	
		/*shopit.Retailer().click();
		shopit.buy().click();
		shopit.Checkout().click(); */
		
	}

}
