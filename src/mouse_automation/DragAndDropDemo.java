package mouse_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class DragAndDropDemo extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/droppable/");
		sleep(3000);
		// driver focus is in main page
		// switch to frame which contains drag and drop elements which we want to automate
		driver.switchTo().frame(0);
		
		// now driver focus is in frame
		WebElement dragEle = driver.findElement(By.id("draggable"));
		WebElement dropEle = driver.findElement(By.id("droppable"));
		
		// create Actions class object
		Actions actions = new Actions(driver);
//		actions.clickAndHold(dragEle).moveToElement(dropEle).release().build().perform();
		
		actions.dragAndDrop(dragEle, dropEle).build().perform();
		sleep(2000);
		
		closeBrowser();
		
	}
}
