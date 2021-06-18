import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test1 extends Config
 {
	
	
	public void test() throws Exception
	{
		
		Connection con=makeConnection("C:\\corejava\\DemoWebdriver\\titletest.xlsx");
		
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery("select * from Sheet1");
		
		
		
		while(rs.next())		{
			String browser = rs.getString(1);  // getting from excel
			String url = rs.getString(2);
			
			String expectedtitle = rs.getString(3).trim();
			
//String resolution1 = rs.getString(4); // read from excel
			
			// Break string from ,
		//	StringTokenizer str = new StringTokenizer(resolution1,",");
			
		//	int reswidth1 = Integer.parseInt(str.nextToken().trim());
		//	System.out.println(reswidth1);
			
		//	int resheight1 = Integer.parseInt(str.nextToken().trim());
		//	System.out.println(resheight1);
			
//String resolution2 = rs.getString(5); // read from excel
			
			// Break string from ,
		//	StringTokenizer str2 = new StringTokenizer(resolution2,",");
			
		//	int reswidth2 = Integer.parseInt(str2.nextToken().trim());
		//	System.out.println(reswidth1);
			
		//	int resheight2 = Integer.parseInt(str2.nextToken().trim());
		//	System.out.println(resheight1);
			
			

			
			
			
			System.out.println(browser +" "+url);
			
			WebDriver driver=openBrowser(browser,url);
			
		//	driver.manage().window().setSize(new org.openqa.selenium.Dimension(reswidth2, resheight2));
			
			
			String actualtitle = driver.getTitle().trim();
			
			if(expectedtitle.equals(actualtitle))
			{
				// pass
				stm.executeUpdate("insert into Sheet2(url,expectedtitle,actualtitle,status) values('"+url+"','"+expectedtitle+"','"+actualtitle+"','Pass')");
			con.commit();
			con.close();
			
			con=makeConnection("C:\\corejava\\DemoWebdriver\\titletest.xlsx");
			stm = con.createStatement();
			
			}
			else {
				// fail
				stm.executeUpdate("insert into Sheet2(url,expectedtitle,actualtitle,status) values('"+url+"','"+expectedtitle+"','"+actualtitle+"','Fail')");
				con.commit();
				con.close();
				
				con=makeConnection("C:\\corejava\\DemoWebdriver\\titletest.xlsx");
				stm = con.createStatement();
				
			}
			
			
		} 

		
		//WebDriver driver=openBrowser("chrome","http://www.google.com"); // inheritef from parent
		
		//driver.findElement(By.xpath("//html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("rm infotech");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Test1 t = new Test1();
t.test();
	}

}
