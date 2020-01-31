package mouse_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class SliderDemo extends BrowserHelper {
	public static void main(String[] args) {
		launchBrowser("firefox", "https://www.axisbank.com/retail/calculators/recurring-deposit-calculator");
		sleep(5000);
		// locate slider head
		WebElement sliderHead = driver.findElement(By.cssSelector(".irs-single"));

		// create Actions class object
		Actions actions = new Actions(driver);
//		actions.clickAndHold(sliderHead).moveByOffset(50, 0).release().build().perform();

		// to move the slider in forward direction we can give positive number
		actions.dragAndDropBy(sliderHead, 200, 0).build().perform();
		sleep(3000);
		// to move the slider in reverse direction we can give negative number
		actions.dragAndDropBy(sliderHead, -100, 0).build().perform();
		sleep(3000);
		// to automate horizontal slider we have set x offset value to automate vertical
		// slide we have to set y offset value
		closeBrowser();
		
	}

}
