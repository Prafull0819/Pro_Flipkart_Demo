package com.flipkart.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.SearchPage;

public class SearchPageTest extends TestBase {
	
	SearchPage searchPage;
	
	public SearchPageTest()
	{
		super();
	}

	@BeforeTest()
	public void SetUp()
	{
		Initialization();
		searchPage = new SearchPage();
	}
	
	@Test(priority=1)
	public void CheckTitle()
	{
		String Actual_title = searchPage.TitleVerification();
		Assert.assertEquals(Actual_title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	    
	}
	
	@Test
	public void searchPhone()
	{
		searchPage.SearchItem(prop.getProperty("Phone"));
	}
	
	
	@AfterMethod
	public void endUp()
	{
		driver.close();
	}
}
