package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		
		// sendKeys() - is used to type some data in any text box field or text area field 
		//locate email or phone text field
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("sunshine");
//		driver.findElement(By.id("email")).sendKeys("sunshine");
		
		Thread.sleep(2000);
		
		// clear() - is used to remove any existing data in any text filed or text area field
//		driver.findElement(By.id("email")).clear();
		emailField.clear();
		Thread.sleep(2000);
		
		// click() - is used to click on any elemenet in the web page
		// locate login button
		WebElement signupButton = driver.findElement(By.name("websubmit"));
//		signupButton.click();
		Thread.sleep(2000);
		
		// submit() - is used to submit a form to the server
//		emailField.submit();
		
		// getText() - is used to retrieve inner text of an element if contains any
		String signBtnText = signupButton.getText();
		System.out.println("sign up button text is "+signBtnText);
		
		// getTagName() - is used to retrieve tag name of the element
		String signUpTagName = signupButton.getTagName();
		System.out.println("sign up tag name is "+signUpTagName);
		System.out.println("email filed tag name is "+emailField.getTagName());
		
		// getAttribute() - is used to retrieve value of a given attribute name
		String type = emailField.getAttribute("type");
		System.out.println("type attribute value of email text filed is "+type);

		// getCssValue() - is used to retrieve value of a given css property name
		System.out.println("border color of email filed is "+emailField.getCssValue("border-color"));
		System.out.println("bordr radius of sign up field is "+signupButton.getCssValue("border-radius"));
		
		
		Thread.sleep(2000);
		driver.close();
		
	}

}
