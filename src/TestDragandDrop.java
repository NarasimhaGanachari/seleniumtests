import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.io.*;


public class TestDragandDrop {

	public static void main(String[] args) throws Exception {


Config c=new Config();
WebDriver driver=c.openBrowser("firefox", "http://dhtmlx.com/docs/products/dhtmlxTree/samples/05_drag_n_drop/01_drag_in_simple.html");
		
		WebElement draggable = driver.findElement(By.xpath("//*[@id=\"treeboxbox_tree\"]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[4]/span"));

		WebElement droppable = driver.findElement(By.xpath("//*[@id=\"treeboxbox_tree\"]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[2]/table/tbody/tr[1]/td[4]/span"));
		
		
		
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();
		
		
		System.out.println("element dragged..");
		
	}

}
