package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFiledsDemo {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate first name filed and type some data
		driver.findElement(By.name("firstname")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		
		// locate surname field and type some data
//		WebElement surname = driver.findElement(By.name("lastname"));
//		surname.sendKeys("surya");
		
		driver.findElement(By.name("lastname")).sendKeys("surya");
		Thread.sleep(2000);
		
		
		// locate email text filed and type some data
		driver.findElement(By.name("reg_email__")).sendKeys("abc@xyz.com");
		Thread.sleep(2000);
		
		// locate reenter email address and type some data
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("abc@xyz.com");
		Thread.sleep(2000);
		
		// locate password field and type some data
		driver.findElement(By.name("reg_passwd__")).sendKeys("password");
		Thread.sleep(2000);
		
		
		driver.close();
		
		
		
		
		
	}
}
