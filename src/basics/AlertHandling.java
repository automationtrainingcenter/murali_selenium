package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * to handle javascript alerts Selenium provides an Alert interface
 * this interface contains following methods
 * 
 * accept() - click ok button of the alert
 * dismiss() - if your alert contains cancle then it will click on cancel button else it will click ok button
 * getText() - return the text of alert as a String
 * sendKeys() - type some data inside text box of an alert
 * 
How to create Alert interface Object reference
In webdriver interface we have switchTo() which return TargetLocator interface reference
In TartgetLocator interface we have several methods to switch driver focus
alert() is the method which will switch driver focus from main page to alert in the page.

TargetLocator tl = driver.switchTo();
Alert alert = tl.alert();

Alert alert = driver.switchTo().alert()
using the above reference we can call alert interface methods*/

public class AlertHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// locate enter your name text field
		WebElement enterYourNameFiled = driver.findElement(By.id("name"));
		
		// type some data in the enter your name text field
		enterYourNameFiled.sendKeys("sunshine");
		Thread.sleep(2000);
		
		// locate alert button and click on it, and it will open an alert with ok button
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		
		// First switch the driver focus from web page to alert
//		driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText(); // retrieving alert text and storing in a String variable
		alert.accept(); // it will click on ok button of alert
		System.out.println("alert text is "+text);
		
		// type some data in the enter your name text field
		enterYourNameFiled.sendKeys("surya");
		Thread.sleep(2000);
		
		// locate confirm button and click on it, and it will open an alert with ok and cancel buttons
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		
		// switch driver focus from web page to alert
		Alert confirmAlert = driver.switchTo().alert();
		// retrieve the text of alert
		System.out.println("confirm alert text is "+confirmAlert.getText());
		// click on cancel button of the alert by using dismiss()
		confirmAlert.dismiss();

		
		Thread.sleep(2000);
		driver.close();
	}

}
