import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.io.*;

public class testFrame {

	
public static void main(String[] args) throws Exception {

Config c=new Config();
//WebDriver driver=c.openBrowser("chrome", "https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_fonts_arial");

WebDriver driver=c.openBrowser("chrome", "http://www.rminfotechsolutions.com/selenium-automation-software-testing-training.html");

// with Frame  id

/* 
driver.switchTo().frame("iframeResult");

String txt=driver.findElement(By.xpath("//html/body/div/h2")).getText();
System.out.println(txt);
 */

// without Frame id

//driver.switchTo().frame(0);


driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(0));
driver.findElement(By.xpath("//*[@id=\"t1\"]")).sendKeys("Parag");


//driver.switchTo().defaultContent(); //go back to old frame / parent window
//System.out.println("back to main frame");
//Thread.sleep(5000);
//String email=driver.findElement(By.xpath("//*[@id=\"textt2\"]/table/tbody/tr/td/strong[4]")).getText();
//System.out.println("Email "+email);
   
	}

}
