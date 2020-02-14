package utilities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

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

	public static String captureScreenshot(WebDriver driver, String folderName, String fileName) {
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
			// copy the image field from RAM location to permanent location using FileHandler
			// class copy()
			FileHandler.copy(srcImg, destImg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return destImg.getAbsolutePath();
	}
	
	
	public static void captureAlertScreenshot(String folderName, String fileName) {
		/**
		 * Selenium's TakeScreenshot interface can not capture the screen of a webpage with alert
		 * so We have to use Java Robot class createScreenCapture() which belongs to java.awt package
		 */
		Robot robo;
		try {
			robo = new Robot();
			// retrieve the size of the screen using getScreenSize() of ToolKit class
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			// create a Rectangle class object using above screenSize
			Rectangle rect = new Rectangle(screenSize);
			// capture the screenshot of webpage using above rectangle class object
			BufferedImage bi = robo.createScreenCapture(rect);
			// create a File class object with location where you want to save the screenshot permanently
			File desImg = new File(getFilePath(folderName, fileName));
			// save the captured screenshot to the above location using write() of ImageIO class
			ImageIO.write(bi, "png", desImg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) {
//		String path = getFilePath("screenshots", "test");
//		System.out.println(path);
//	}

}
