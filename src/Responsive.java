import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Responsive extends Config{
	
	
	
	public Logger logs =null;  // logger for logs
	
public ExtentTest test=null;  // for extent report
public ExtentReports report=null;

	
	public void test() throws Exception
	{
		// initialize log
		logs = Logger.getLogger("responsiveLogger");
		logs.debug("test called..");  // message in log
		
		// initialize extentreport..
		report = new ExtentReports("C:\\corejava\\DemoWebdriver\\src\\Logs\\ExtentReportResults.html");
		test = report.startTest("ResponsiveDemo");
		test.log(LogStatus.INFO, "test called");  // message in extent report
		
		
	Connection con=	makeConnection("C:\\corejava\\DemoWebdriver\\responsive.xlsx");
	Statement stm = con.createStatement();
	ResultSet rs = stm.executeQuery("select * from Sheet1");
	logs.debug("connected to excel sheet");
	test.log(LogStatus.PASS, "connected to excel sheet");
	while(rs.next())
	{
		// getting data from excel sheet1
		
		String browser = rs.getString(1);
		String url = rs.getString(2);
		String resolution = rs.getString(3);
		String Expimgw = rs.getString(4);
		String Expimgh = rs.getString(5);
		
		logs.debug("got data from excel to test..");
		test.log(LogStatus.PASS, "got data from excel to test..");
		
		// Break string from resolution
					StringTokenizer str = new StringTokenizer(resolution,",");
					
					int reswidth = Integer.parseInt(str.nextToken().trim());
					
					int resheight = Integer.parseInt(str.nextToken().trim());
					
					WebDriver driver=openBrowser(browser,url);  // calling method passing value from excel
					
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(reswidth, resheight));
		
		Thread.sleep(1500);
		
		// screen shot
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // store file to temprary location
		 //Now you can do whatever you need to do with it, for example copy somewhere download org.apache.commons.io.FileUtils class API set classpath and use this class to copy.
		 FileUtils.copyFile(scrFile, new File("C:\\corejava\\DemoWebdriver\\src\\screenshot\\img"+resolution+".png"));

		 logs.debug("screen shot for responsive page taken");
		 test.log(LogStatus.PASS, "screen shot for responsive page taken");
		
		 // read xpath from OR.properties
		 Properties OR = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\OR.properties");
			System.out.println("read "+fis);
			OR.load(fis);
			String imgxpath=OR.getProperty("imgxpath"); // getting from or.properties
			
		
		// css - step1 locate element
		WebElement e=driver.findElement(By.xpath(imgxpath));
		
		// css - step2 get css value by css property
		String actualwidth=e.getCssValue("width");
		
		String actualheight = e.getCssValue("height");
		
		if(actualwidth.equals(Expimgw) && actualheight.equals(Expimgh))
		{
			//pass
			stm.executeUpdate("insert into Sheet2(url,resolution,expw,actualw,exph,actualh,status) values('"+url+"','"+resolution+"','"+Expimgw+"','"+actualwidth+"','"+Expimgh+"','"+actualheight+"','Pass')");
			con.commit();
			con.close();
			con=	makeConnection("C:\\corejava\\DemoWebdriver\\responsive.xlsx");
			stm = con.createStatement();
			
			logs.debug("pass - recirded in excel sheet2");
			test.log(LogStatus.PASS, "pass - recirded in excel sheet2");
			
		}
		else {
			// fail
			//pass
			stm.executeUpdate("insert into Sheet2(url,resolution,expw,actualw,exph,actualh,status) values('"+url+"','"+resolution+"','"+Expimgw+"','"+actualwidth+"','"+Expimgh+"','"+actualheight+"','Fail')");
			con.commit();
			con.close();
			con=	makeConnection("C:\\corejava\\DemoWebdriver\\responsive.xlsx");
			stm = con.createStatement();
			logs.debug("fail- recorded in excel sheet2");
			test.log(LogStatus.FAIL, "fail- recorded in excel sheet2");
			
		}
		
						
	}
		// close extent report
	
	report.endTest(test);
	  
	  report.flush();
// send email
	  
	//  monitoringMail m = new monitoringMail();
	  
	//  m.sendMail(TestMailConfig.server, TestMailConfig.from, TestMailConfig.to, TestMailConfig.subject, TestMailConfig.messageBody, TestMailConfig.attachmentPath , TestMailConfig.attachmentName);
//	System.out.println("mail sent..");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Responsive r = new Responsive();
r.test();
	}

}
