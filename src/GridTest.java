// simple socket program type hai .. ek mach A (hub/server) per hub.bat and mach b (node / client) per nod.bat chala lo har mach per node.bat chalni chahiye
// hub will register node machines..request (java prog run on hub)  will move from hub to client mach
// open grid console http://localhost:4444/grid/console and check browser config by moving mouse on image browser name and platform information
// run GridTest on server mach A it will run test(open browser) on client machine B
// for firefox no problem but for chrome chromedriver should be available on client machine and has to be added on node.bat -Dwebdriver.chrome.driver=path of chrome.exe (System.setProperty will not work..)
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.net.*;
public class GridTest
  {
     public static void main(String args[]) throws Exception
        {

DesiredCapabilities capability1= DesiredCapabilities.chrome();
capability1.setBrowserName("chrome");  // firefox client mach
capability1.setPlatform(Platform.WIN10);  //VISTAclient mach WIN10
System.out.println("capability set..");

WebDriver driver1=new RemoteWebDriver(new URL("http://192.168.212.37:5566/wd/hub"),capability1);  //  ip adr / name of client (node) mach name
//WebDriver driver=new RemoteWebDriver(new URL("http://localhost:5566/wd/hub"),capability);  

driver1.navigate().to("http://www.google.co.in/");
driver1.manage().window().maximize();

      }
 }