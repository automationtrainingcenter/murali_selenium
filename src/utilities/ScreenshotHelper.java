package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotHelper {
	
	private static String getTime() {
		Date date = new Date();
		// 01-Feb-2020_10_59_21_AM
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy_HH_mm_ss_z");
		return df.format(date);
	}
	
	private static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName +File.separator + fileName+getTime()+".png";
	}

	public static void captureScreenshot(WebDriver driver, String folderName, String fileName) {
		// capture the screenshot of the web page
		// to capture the screenshot selenium provides getScreenshotAs() with in
		// TakesScreenshot
		// interface. To call these method we have to type cast WebDriver object
		// reference to
		// TakesScreenshot object reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		// the above line saves the images to a RAM location
		// create a File class object with path where we want to save the image in a
		// permanent loaction
		File destImg = new File(getFilePath(folderName, fileName));
		try {
			// copy the image fiel from RAM location to permanent location using FileHandler
			// class copy()
			FileHandler.copy(srcImg, destImg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
//	public static void main(String[] args) {
//		String path = getFilePath("screenshots", "test");
//		System.out.println(path);
//	}

}
