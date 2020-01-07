package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * how to automate links, buttons, radio buttons and checkboxes
 */
public class ClickDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate male radio button and click on it
		driver.findElement(By.cssSelector("input[value='2']")).click();
		Thread.sleep(2000);
		
		// locate login button and click on it
		driver.findElement(By.cssSelector("input[aria-label='Log In']")).click();
		Thread.sleep(2000);
		
		// locate login button and click on it
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
		
		// locate Recover your Account link and click on it
		driver.findElement(By.linkText("Recover Your Account")).click();
		Thread.sleep(2000);
		
		driver.close();
		
		
		
	}

}
