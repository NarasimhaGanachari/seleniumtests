import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.io.*;


public class TestAlerts {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {


		Config c=new Config();
		WebDriver driver=c.openBrowser("chrome", "http://www.rediff.com/");
				
		driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]")).click();
		
		driver.findElement(By.xpath("//html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText()); // display alert message
		
		//Thread.sleep(3000);
		alert.accept(); // click ok button to close alert 
	
		
		
		
		
		

	}

}
