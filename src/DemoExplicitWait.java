import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoExplicitWait {
	
	
	public void test()
	{
		System.setProperty("webdriver.gecko.driver","c:\\browser-drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		 driver.navigate().to("http://www.rminfotechsolutions.com");
		 
		 driver.manage().window().maximize();  // short cut
		
		// explicit wait
		 WebDriverWait wait=new WebDriverWait(driver,120L); // long time in mil sec
		 WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div/nav/div/div[2]/ul[1]/li[3]/a")));

		 element.click(); // no need to find again
		 
		 driver.findElement(By.xpath("//*[@id=\"submenu3\"]")).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoExplicitWait d = new DemoExplicitWait();
		d.test();
	}

}
