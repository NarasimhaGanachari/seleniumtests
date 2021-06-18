import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Moveinbetweenwindow {

	public void test() throws InterruptedException
	{
		Config c=new Config();
		WebDriver driver=c.openBrowser("chrome", "https://www.shine.com/");
		
		driver.findElement(By.xpath("//*[@id=\"id_showform\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"id_q\"]")).sendKeys("Java Developer");
		
		driver.findElement(By.xpath("//html/body/footer/div/div/div/div/div[1]/ul[1]/li[3]/a")).click();
		
		Thread.sleep(5000);
		
driver.findElement(By.xpath("//html/body/footer/div/div/div/div/div[1]/ul[1]/li[4]/a")).click();
		
		Thread.sleep(3000);
		
		
		
		Set<String> s=driver.getWindowHandles();  // return reference of open tabs
		
		 Iterator<String> it= s.iterator();
		 
		// String cuuwindow=it.next();   // current tab
		// String title1=driver.getTitle();
		//  System.out.println(title1);
		 // System.out.println(" size "+s.size());
		  
		  while(it.hasNext())
		  {
			  System.out.println("in while..");
			  driver.switchTo().window(it.next()); // move control to next tab
			  String title=driver.getTitle().trim(); // get title of tab on which we have focus
			  System.out.println(" title is "+title);
			  
			  if(title.equals("Job Search India - Latest Career Jobs and Employment"))
			  {
				  System.out.println("moved to job search tab..");
				  driver.findElement(By.xpath("//*[@id=\"id_searchBase\"]")).click();
				  driver.findElement(By.xpath("//*[@id=\"id_q\"]")).sendKeys("Software Testing");
			  }
			  else if(title.equals("Register Free on Shine.com | Apply Jobs Online"))
			  {
				  System.out.println("moved to register tab");
				  
				  driver.findElement(By.xpath("//html/body/div[3]/div[1]/div[2]/form/div[1]/div[1]/input")).sendKeys("Raj");
			  }
			  
		  }
		 // driver.switchTo().window(cuuwindow); // back to curr window 
		 // c.findMyElement("//*[@id=\"id_loc\"]").sendKeys("Pune");
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
Moveinbetweenwindow m=new Moveinbetweenwindow();
m.test();
	}

}



