package mouse_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

/*
 * To automate mouse events selenium provides Actions class
 * this Actions class contains several methods to automate all the mouse events
 * like mouse hover, drag, drop, drag and drop, context click ..etc
 * we can combine multiple actions as single action using build() and we can perform
 * that combined action using perfrom()
 * 
 * All these methods are instance methods so we have to create an object of Actions class
 * 
 */
public class MouseHoverDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.firstcry.com/");
		sleep(3000);
		
		// create Actions class object
		Actions actions = new Actions(driver);
		
		WebElement babyClothes = driver.findElement(By.id("menu1"));
		// move mouse to the baby clothes element
		actions.moveToElement(babyClothes).build().perform();
		sleep(2000);
		// locate baby girl link
		WebElement babyGirl = driver.findElement(By.id("submenu2-1"));
		actions.moveToElement(babyGirl).build().perform();
		sleep(2000);
		// locate party wear link
		WebElement partyWear = driver.findElement(By.cssSelector("a[href *= 'babygirl_party']"));
		actions.moveToElement(partyWear).click().build().perform();
		
		sleep(3000);
		closeBrowser();
		
		
	}

}
