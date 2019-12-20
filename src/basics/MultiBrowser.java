package basics;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter browser name");
		String browserName = sc.next();
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
//			ChromeDriver cdriver = new ChromeDriver();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
//			FirefoxDriver fdriver = new FirefoxDriver();
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser name must be either chrome or firefox");
		}
		if (driver != null) {
			driver.get("http://www.facebook.com");
			String title = driver.getTitle();
			System.out.println("title is " + title);
			driver.close();
		}else {
			System.out.println("browser not launched");
		}

	}

}
