package screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class ScreenshotsDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.facebook.com");
		sleep(3000);
//		// capture the screenshot of the web page
//		// to capture the screenshot selenium provides getScreenshotAs() with in TakesScreenshot 
//		// interface. To call these method we have to type cast WebDriver object reference to
//		// TakesScreenshot object reference
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File srcImg = ts.getScreenshotAs(OutputType.FILE);
//		// the above line saves the images to a RAM location
//		// create a File class object with path where we want to save the image in a permanant loaction 
//		File destImg = new File(".//screenshots//facebook.png");
//		try {
//			// copy the image fiel from RAM location to permanent location using FileHandler class copy()
//			FileHandler.copy(srcImg,destImg);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		// test screenshothelper class
		ScreenshotHelper.captureScreenshot(driver, "screenshots", "facebook1");
		
		closeBrowser();
	}

}
