import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.io.*;
import org.openqa.selenium.support.ui.*;  

public class TestMouseOver {

	public static void main(String[] args) throws Exception {
     
		Config c=new Config();
		WebDriver driver=c.openBrowser("chrome", "http://timesofindia.indiatimes.com/");
Thread.sleep(2000);

// explicit wait		
WebDriverWait wait=new WebDriverWait(driver,80L); // long time in mil sec

// world on mouse over
WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div/div[2]/nav/ul/li[5]/a")));

  if(element != null)
     {
Actions action = new Actions(driver);
action.moveToElement(element).perform();  // mouse move
		System.out.println("mouse over world.. action performed..");


     // pak on mouse over on world
   element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div/div[2]/nav/ul/li[5]/div/div[1]/a[3]")));

   if(element != null)
     {
element.click();
System.out.println("link clicked..");
}
else{
System.out.println("pak element not clicked");
}

  }

else{
System.out.println("world link not click");
}
     

    }
 
	
		

	}


