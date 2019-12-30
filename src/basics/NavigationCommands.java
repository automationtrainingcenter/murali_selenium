package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*
		 * In webdriver interface we have Navigation interface which is used to automate
		 * browser navigations like refresh, forward, backward and to 
		 * to(String url) : navigates to url which we provided as String argument
		 * refresh(): it refresh current web page
		 * forward() : it will navigate to the forward page in driver browser history
		 * backward(): it will navigate to the backward page in driver browser history
		 */
		Navigation nav = driver.navigate();
		nav.to("http://www.google.com");
		Thread.sleep(2000);
		
		
		nav.to("http://www.gmail.com");
		Thread.sleep(2000);
		
		
		nav.back();
		Thread.sleep(2000);
		
		nav.forward();
		Thread.sleep(2000);
		
		nav.refresh();
		Thread.sleep(2000);
		
//		driver.navigate().to("http://www.google.com");
		
		
		driver.close();

	}
}
