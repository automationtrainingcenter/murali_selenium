package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class ScrollPageDemo extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.amazon.in");
		sleep(3000);
		// locate back to top link
		WebElement backToTopLink = driver.findElement(By.id("navBackToTop"));
		// Create JavaScriptExecutor object reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", backToTopLink);
		sleep(3000);
		
		// scroll the page up
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", 0, -100);
		sleep(3000);
		
		
		backToTopLink.click();
		sleep(3000);
		closeBrowser();
	}

}
