package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Frame is a web page inside another web page
 * whenever we launch a page which contains frames in it, the driver will have focus
 * only inside the main page, we have to switch that driver focus from main page 
 * to frame pages, to switch that focus we can use following methods of
 * TargetLocator interface
 * 
 * 1. frame(int index) - it will switch the driver focus from main page to the frame with given index number
 * 2. frame(String id_or_name_of_frame) - it will switch the driver focus from main page to the frame with
 * id or name attribute value
 * 3. frame(WebElement frameEle) -- locate the frame by using any attribute and store that in a 
 * WebElement reference, we can use this reference to switch the driver focus from main page to this
 * frame page
 * 4. parentFrame() -- it will switch driver focus from an inner frame to an outer frame
 * 5. defaultContent() -- it will switch driver focus from any frame to main page
 * 
 * In webdriver interface we have switchTo() which return TargetLocator interface reference
In TartgetLocator interface we have several methods to switch driver focus
from main page to frames or vice versa. the above are the methods in TargerLocator inteface which are
used to automate frames

TargetLocator tl = driver.switchTo();
 * 
 */

public class FramesHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate enter your name text field and type some data
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		// switch the driver focus from main page to frame which contains search couses text field
		driver.switchTo().frame("courses-iframe");

		// now driver focus is in frame
		// locate search courses text field which is inside a frame and type some data
		driver.findElement(By.id("search-courses")).sendKeys("javascript");
		Thread.sleep(2000);
		
		// switch the driver focus from frame to main page using defaultContent()
		driver.switchTo().defaultContent();

		// now driver focus is in mainpage
		// locate hide or show example field which is main page and type some data
		driver.findElement(By.id("displayed-text")).sendKeys("selenium");
		Thread.sleep(2000);

		driver.close();

	}

}
