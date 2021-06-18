import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.io.*;

public class TestVideo1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	
	public static void main(String[] args) throws InterruptedException {

//https://developers.google.com/youtube/flash_api_reference#Playback_controls

Config c=new Config();
WebDriver driver=c.openBrowser("firefox", "http://www.youtube.com/watch?v=cF0EfKPwt3k");

((JavascriptExecutor)driver).executeScript("movie_player.playVideo()");
System.out.println("1 video played...");
Thread.sleep(10000);

((JavascriptExecutor)driver).executeScript("movie_player.pauseVideo()");
System.out.println("2 video paused.");
Thread.sleep(10000);

 
((JavascriptExecutor)driver).executeScript("movie_player.playVideo()");
System.out.println("3 video played");
Thread.sleep(20000);


((JavascriptExecutor)driver).executeScript("movie_player.mute()");
System.out.println("4 video muted");
Thread.sleep(10000);



((JavascriptExecutor)driver).executeScript("movie_player.unMute()");
System.out.println("5 video unmuted");
Thread.sleep(20000);

/*  */
driver.quit();		
		
		
	}

}
