package com.flipkart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.qa.util.TestUtil;

public class TestBase {

	// This is base class
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			// Read property file here
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("H:\\Final_Selenium\\Prafull_Selenuim\\Flipkart_Demo\\Demo\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties"));
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void Initialization()
	{
		
		// Initiliztion done
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
				{
			System.setProperty("webdriver.chrome.driver",
					"H:\\Final_Selenium\\Software\\chromedriver_win32\\chromedriver.exe");
			     driver = new ChromeDriver();
				}
		else
		{
			   System.setProperty("webdriver.gecko.driver", "H:\\Final_Selenium\\Software\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		       driver = new FirefoxDriver();         			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait ,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
		
		
}
}