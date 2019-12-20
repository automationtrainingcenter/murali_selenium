package basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowsers {
	public static void main(String[] args) {
		// set the system property for chromedriver.exe file
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// to open a browser we have to create an object of the browser driver class
		ChromeDriver chrome = new ChromeDriver();

		System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
		FirefoxDriver firefox = new FirefoxDriver();
	}

}
