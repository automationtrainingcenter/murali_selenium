package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class GetTextBoxContent extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.facebook.com");
		String email = "murali";
		WebElement emailField = driver.findElement(By.id("email"));
//		emailField.sendKeys(email);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		js.executeScript("document.getElementById('email').value = 'prince'");
		js.executeScript("arguments[0].value = arguments[1]", emailField, email);
		sleep(3000);
//		String emailFieldValue = js.executeScript("return document.getElementById('email').value").toString();
		
		String emailFieldValue = js.executeScript("return arguments[0].value", emailField).toString();
		
		System.out.println(emailFieldValue);
		
		
		
		closeBrowser();
	}

}
