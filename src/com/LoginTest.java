package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import utility.POIConfig;

public class LoginTest extends Config{
	
	public void test() throws Exception
	{
		WebDriver driver =openBrowser("chrome","http://www.nethorizonconsultancy.com/Seeker.aspx");
		
		Connection con=makeConnection("C:\\corejava\\DemoWebdriver\\Book3.xls"); // have to make connection as before data is added to array from getData() yaha connection open nahi hai
		Statement stm=con.createStatement();
		
		ResultSet rs = stm.executeQuery("select * from Sheet1");
		
		while(rs.next())
		{
			
			String uid = rs.getString(1);
			String pwd = rs.getString(2);
			driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1_UserName\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1_UserName\"]")).sendKeys(uid);
		
		driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1_Password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1_Password\"]")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1_LoginButton\"]")).click();
		}
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
LoginTest l = new LoginTest();
l.test();
	}

}
