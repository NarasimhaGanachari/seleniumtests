import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoImplicitWait {
	
	
	
	public void test()
	{
		System.setProperty("webdriver.gecko.driver","c:\\browser-drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		 driver.navigate().to("http://www.rminfotechsolutions.com");
		 
		 driver.manage().window().maximize();  // short cut
		 
		//	driver.manage().timeouts().implicitlyWait(40L, TimeUnit.SECONDS);
		 
		 // longcut
		 
		 WebDriver.Options opt=driver.manage();
		 WebDriver.Timeouts tm=opt.timeouts();
		 tm.implicitlyWait(30L, TimeUnit.SECONDS);
		 
		 
			
			//driver.findElement(By.xpath("//html/body/div/nav/div/div[2]/ul[1]/li[3]/a")).click();
		 
		 //longcut
		 
		
		 
		 By b = By.partialLinkText("IT Train");
		WebElement e= driver.findElement(b);
		e.click();
			
			driver.findElement(By.xpath("//*[@id=\"submenu3\"]")).click();
			
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
DemoImplicitWait d = new DemoImplicitWait();
d.test();
	}

}
