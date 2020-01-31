package mouse_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class DragElementDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/draggable/");
		// driver focus is in main page
		// switch to frame which contains drag me around element which we want to automate
		driver.switchTo().frame(0);
		
		// now driver focus is inside the frame
		// locate drag me around element 
		WebElement dragEle = driver.findElement(By.id("draggable"));
		
		// create Actions class object
		Actions actions  = new Actions(driver);
//		actions.clickAndHold(dragEle).moveByOffset(100, 100).release().build().perform();
		
		actions.dragAndDropBy(dragEle, 100, 100).build().perform();
		
		sleep(3000);
		
		closeBrowser();
		
		
	}

}
