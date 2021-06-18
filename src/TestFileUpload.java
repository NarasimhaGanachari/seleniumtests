import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.io.*;
public class TestFileUpload {

	
	public static void main(String[] args)throws Exception {
		try{
		Config c=new Config();
		WebDriver driver=c.openBrowser("chrome", "https://gofile.io/uploadFiles");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"rowUploadButton-dropZone\"]")).click();
		System.out.println("element clicked..");

//Runtime is a java.lang class and exec() is java method to run .exe program
 // call a script
Thread.sleep(5000);
System.out.println("calling script");
Runtime.getRuntime().exec("C:\\autoit\\attachfile.exe"); // call exe
//driver.quit();

Thread.sleep(3000);

driver.findElement(By.xpath("//*[@id=\"rowUploadProgress-startUpload-uploadBtn\"]")).click();

	       
		
           
		  }catch(Exception e){e.printStackTrace();}

	}

}
