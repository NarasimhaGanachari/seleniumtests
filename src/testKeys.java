import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.io.*;

public class testKeys {

	
	public static void main(String[] args) {

		
		
		Config c=new Config();
		WebDriver driver=c.openBrowser("firefox", "http://www.nethorizonconsultancy.com/Seeker.aspx");
		
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_Login1_UserName']")).sendKeys("sdfdsf");
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_Login1_Password']")).sendKeys("sdfdf");
		
		
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

		

//To Select whole page:



driver.findElement(By.tagName("html")).sendKeys(
Keys.chord(Keys.CONTROL, Keys.ADD));
		driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, Keys.ADD));
		driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, Keys.ADD));
		driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, Keys.ADD));
		driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, Keys.ADD));
driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, Keys.ADD));
		driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, Keys.ADD));
		driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, Keys.ADD));
		
		driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		driver.findElement(By.tagName("html")).sendKeys(
				Keys.chord(Keys.CONTROL, "0"));
 	
		

	}

}
