package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {
	
	public static WebDriver driver;

	public  static void launchBrowser(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			throw new RuntimeException("browser name must be either chrome or firefox");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	public static void closeBrowser() {
		if(driver.getWindowHandles().size() > 1) {
			driver.quit();
		}else {
			driver.close();
		}
	}
	
	
	public static void sleep(long timeInMilliSecs) {
		try {
			Thread.sleep(timeInMilliSecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
