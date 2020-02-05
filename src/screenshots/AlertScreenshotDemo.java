package screenshots;

import org.openqa.selenium.By;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class AlertScreenshotDemo extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		driver.findElement(By.id("alertbtn")).click();
		sleep(2000);
		ScreenshotHelper.captureAlertScreenshot("screenshots", "alert");
		driver.switchTo().alert().accept();
		closeBrowser();
	}

}
