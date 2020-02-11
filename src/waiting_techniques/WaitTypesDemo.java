package waiting_techniques;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypesDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
//		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//h4[text()='Cauliflower - 1 Kg']/ancestor::div[@class='product']//button")).click();
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("123promo");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		WebElement promoInfoEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.promoInfo")));
		String promoInfo = promoInfoEle.getText();
		System.out.println("promo info is "+promoInfo);
		
	
		
		driver.close();
	}
	
}

