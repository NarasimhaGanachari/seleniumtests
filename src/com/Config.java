package com;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.*;

public class Config {
	
	
	WebDriver driver = null;  // global
	Connection con = null;
	
	public WebDriver openBrowser(String browser,String url) // take input from child and return webdriver to child
	{
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","c:\\browser-drivers\\chromedriver.exe");
				 driver = new ChromeDriver();
			 
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","c:\\browser-drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
			
		}
		
		driver.navigate().to(url);
		// driver.navigate().refresh();
		 
		 driver.manage().window().maximize();  // short cut
		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS); 
		
		return driver;
		
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public Connection makeConnection(String wb) throws Exception
	{
		// Register Driver
				Class.forName("com.googlecode.sqlsheet.Driver");

				// Connect to Excel – xls format only

			 con = DriverManager.getConnection("jdbc:xls:file:"+wb);
			 return con;

	}

}
