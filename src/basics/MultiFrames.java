package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiFrames {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/SSTS/murali/SeleniumConcepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		
		// first automate frame4 which is an inner frame of frame 3
		// now driver focus is in main page
		// so switch the driver focus from main page to frame 3
		driver.switchTo().frame("fthree");
		// now driver focus is in frame3
		// switch that driver focus from frame 3 to frame 4
		driver.switchTo().frame(0);
		// now driver focus is in frame 4
		driver.findElement(By.xpath("(//input[@name='search'])[2]")).sendKeys("selenium");
		Thread.sleep(3000);
		
		
		
		// automate frame3
		// now driver focus is in frame 4
		// switch the driver focus from frame 4 to frame3, which is a parent frame of frame 4
		driver.switchTo().parentFrame();
		// now driver focus is in frame 3
		driver.findElement(By.id("click")).click();
		Thread.sleep(3000);
		
		
		// automate frame2
		// now driver focus is in frame 3
		// so switch that driver focus from frame 3 to frame 2, first switch to main page
		// then switch to frame 2
		// switching driver focus from frame 3 to main page
		driver.switchTo().defaultContent();
		// now driver focus is in mainpage so switch that focus to frame2
		driver.switchTo().frame("ftwo");
		// now driver focus is in frame2
		driver.findElement(By.linkText("selenium official site")).click();
		Thread.sleep(3000);
		
		
		// automate frame1
		// driver focus is in frame 2
		// so switch that driver focus from frame 2 to frame 1
		// first switch driver focus from frame 2 to main page
		driver.switchTo().defaultContent();
		// now driver focus is in main page
		// switch the driver focus from main page to frame 1
		driver.switchTo().frame("fone");
		// now driver focus is in frame 1
		driver.findElement(By.cssSelector("input[placeholder='Enter name']")).sendKeys("sunshine");
		Thread.sleep(3000);
		
		// automate main page
		// now driver focus is in frame1
		// switch that driver frame 1 to main page
		driver.switchTo().defaultContent();
		// now driver foucs is in main page
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

}
