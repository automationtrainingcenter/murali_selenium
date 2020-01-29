package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindows {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/SSTS/murali/SeleniumConcepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		// locate open windows button and click on it
		driver.findElement(By.id("opentWin")).click();
		
		// the above click will open multiple windows 
		// get all the ids of the windows to switch from one window to another window
		Set<String> windowHandles = driver.getWindowHandles();
		// convert the above set to list so that those windows can have indexing
		List<String> windowIds = new ArrayList<>(windowHandles);
		
		// the above list contains all window ids in index 0 we have main window id,
		// in index 1 we have first child window id, in index 2 we have second child window id ..etc
//		for(int i = 0; i < windowIds.size(); i++) {
//			driver.switchTo().window(windowIds.get(i));
//			System.out.println("in index "+i+" we have "+driver.getCurrentUrl());
//		}
		
		// automate youtube window
		// now driver focus is in main window, switch that focus to youtube window i.e. 2nd child
		driver.switchTo().window(windowIds.get(2));
		// now driver focus switched to youtube window
		driver.findElement(By.id("search")).sendKeys("selenium webdriver"+Keys.ENTER);
		Thread.sleep(4000);
		
		
		// automate google window
		// now driver focus is in youtube window, switch that focus to google window i.e 3rd child
		driver.switchTo().window(windowIds.get(3));
		// now driver focus is in google window
		driver.findElement(By.name("q")).sendKeys("selenium training in lingampally"+Keys.ENTER);
		Thread.sleep(4000);
		
		
		// automate facebook window
		// now driver focus is in google window, switch that focus to facebook window i.e. 1st child
		driver.switchTo().window(windowIds.get(1));
		// now driver focus is in facebook page
		driver.findElement(By.id("email")).sendKeys("akldfh");
		driver.findElement(By.id("pass")).sendKeys("alkjdhfalkfaf");
		driver.findElement(By.id("pass")).submit();
		Thread.sleep(4000);
		
		// automate main window
		// now dirver focus is in facebook window, switch that focus to main window i.e 0th window
		driver.switchTo().window(windowIds.get(0));
		// locate open tabs button and click on it
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(4000);
		
		
		
		driver.quit();
		
		
	}

}
