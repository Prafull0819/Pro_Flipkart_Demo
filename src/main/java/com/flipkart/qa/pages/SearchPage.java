package com.flipkart.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class SearchPage extends TestBase {

	// Page Factory
	
	@FindBy(name="q")
	WebElement Searchphone;
	
	public SearchPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String TitleVerification()
	{
		return driver.getTitle();
	}
	
	public boolean validateSearchbox()
	{
		return Searchphone.isDisplayed();
	}
	
	public void SearchItem(String Itemname)
	{
		Searchphone.sendKeys(Itemname);
		Searchphone.sendKeys(Keys.ENTER);
	}
}
