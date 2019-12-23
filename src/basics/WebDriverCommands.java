package basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * WebDriver interface provides lot of methods to work with any browser
 */
public class WebDriverCommands {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		// get(String url) : is used to navigate to the url provided as string argument
		driver.get("http://facebook.com");
		Thread.sleep(2000);
		
		// getTitle() -- String: it returns title of the current web page as a string value
		String title = driver.getTitle();
		System.out.println("tirle of the web page is "+title);
		
		// getCurrentUrl() -- String: it returns url of the current web page as a String value
		String url = driver.getCurrentUrl();
		System.out.println("url of the current web page is "+url);
		
		
		// getPageSource() -- String: it returns entire html source code of the current web page as a string value
		String pageSource = driver.getPageSource();
		System.out.println(pageSource.contains("Facebook helps you connect and share with the people in your life"));
		
		
		// getWindowHandle() -- String: it returns unique id of the current browser window which is opened by driver instance
		String windowId = driver.getWindowHandle();
		System.out.println("window id is "+windowId);

		// getWindowHandles() -- Set<String>: it returns ids of all the browser windows which are opened by driver instance
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("the number of opened widnows are "+windowHandles.size());
		

		// findElement(By arg) -- WebElement: is used to locate an element with in the current web page using
		// By class argument
//		By byVar = By.id("u_0_m");
//		WebElement firstNameEle = driver.findElement(byVar);
		try {
			WebElement firstNameEle = driver.findElement(By.id("u_0_mxyz"));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		// findElements(By arg)
		List<WebElement> inputTags = driver.findElements(By.tagName("input"));
		System.out.println("number of input tags = "+inputTags.size());
		
		// close() : it will close current browser window
		driver.close();
		
		
		// quit() : it will close all the browser windows opened by driver instance
//		driver.quit();
	}

}
