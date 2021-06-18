import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 {
	
	
	WebDriver driver = null;
	
	public void test()
	{
		System.setProperty("webdriver.gecko.driver","c:\\browser-drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 
		// driver.get("http://www.rminfotechsolutions.com");
		 
		 
		 //longcut
		 /*
		 WebDriver.Navigation n = driver.navigate();
		 n.to("http://www.rminfotechsolutions.com");
		 */
		 // short cut
		
		 driver.navigate().to("http://www.rminfotechsolutions.com");
		 driver.navigate().refresh();
		 
		 driver.manage().window().maximize();  // short cut
		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS); 
			
		
		 
		 System.setProperty("webdriver.chrome.driver","c:\\browser-drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		  
		// driver.get("http://www.nethorizonconsultancy.com/Seeker.aspx");
		
		 driver.navigate().to("http://www.nethorizonconsultancy.com/Seeker.aspx");
		 
		// driver.manage().window().maximize();
		 
		 // long cut
		 
		WebDriver.Options o = driver.manage();
		WebDriver.Window w=o.window();
		w.maximize();
			driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS); 
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Demo1 d = new Demo1();
d.test();
	}

}
