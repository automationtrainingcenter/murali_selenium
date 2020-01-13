package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	/*
	 * To automate multiple windows or tabs first we have retrieve all the window ids opened by
	 * driver instance.
	 * To automate multiple windows we have to switch driver focus from one window (main window) to another window
	 * by using window(String windosId) of TargetLocator interface
	 * 
	 * with in Webdriver interface we have switchTo() which will return TargetLocator interface reference
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		// locate open window button in main window and click on it
		// it will open another window
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(3000);
		
		// now retrieve all the window handles 
		Set<String> windowHandles = driver.getWindowHandles();
//		System.out.println("number of windows are "+windowHandles.size());
//		System.out.println(windowHandles);
		// convert that set to list
		List<String> windowIds = new ArrayList<>(windowHandles);
		// in index of above list contains main or parent window id, index 1 contains first child window id
		// index 2 contains 2nd child window id and so on
		
		// now driver focus is in main window and switch that focus focus child window or second window
		driver.switchTo().window(windowIds.get(1));
		
		// now driver focus is in second window or child window
		// automate child window
		// locate search courses text filed in child window and type some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(2000);

		
		// now driver focus is in child window and switch that focus to parent window or main window
		driver.switchTo().window(windowIds.get(0));
		
		// now driver focus is in main window.
		// automate main window
		// locate enter your name text field and type some data
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

}
