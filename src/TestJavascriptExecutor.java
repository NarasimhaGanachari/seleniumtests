import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class TestJavascriptExecutor {

	
	public static void main(String[] args) throws Exception {

Config c=new Config();
WebDriver driver=c.openBrowser("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_events1");

Thread.sleep(2000);

driver.switchTo().frame(driver.findElement(By.id("iframeResult")));

System.out.println("moved to iframe..");

JavascriptExecutor js=(JavascriptExecutor) driver;


		
js.executeScript("displayDate()");  // call script function on webpage directly

System.out.println("JS Exceuted..");
	}

}
