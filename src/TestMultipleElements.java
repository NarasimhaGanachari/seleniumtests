import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class TestMultipleElements extends Config{

	public void test()
	{
		WebDriver driver=openBrowser("chrome","https://www.wikipedia.org/");
		
		
		// webdriver find method find on webpage
		
		
		
		WebElement e2 = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		Select select = new Select(e2);
		
			
		//select.selectByVisibleText("Eesti");
		//or
		select.selectByValue("ar");
		
		// getting all options inside select
		
		
		List<WebElement> l=e2.findElements(By.tagName("option"));  // multiple
		Iterator<WebElement> it=l.iterator();
		int c=0;
		  while(it.hasNext())
		  {
			 WebElement e1= it.next(); 
			 String language=e1.getText();
			 
			 String attribute = e1.getAttribute("value");
			 System.out.println(language +"  "+attribute);
			 c++;
		  }
		   System.out.println("options are "+c);
		     
		
		// Getting All Links 
		  
		  WebElement e1=driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]"));
		  
		 List<WebElement> l1= e1.findElements(By.tagName("a"));
		 Iterator<WebElement> it1=l1.iterator();
		  while(it1.hasNext())
		  {
			 System.out.println( it1.next().getText());
			 System.out.println(it1.next().getAttribute("href"));
		  }
		  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMultipleElements tt=new TestMultipleElements();
		tt.test();
	}

}
