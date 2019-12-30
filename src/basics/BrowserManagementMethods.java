package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManagementMethods {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		
		/*
		 * In Selenium We have a Window interface which provides several methods to
		 * automate window events
		 * 
		 * getPosition() : Point object x and y coordinate axis values of the browser window from the
		 * top left corner of the screen
		 * 
		 * getSize() : Dimension object which is width and height of the browser window
		 * 
		 * maximize() : it will maximizes the browser window
		 * 
		 * fullScreen() : it will display browser window in full screen (f11) mode
		 * 
		 * setSize(Dimension arg) : set the browser size to the specified width and height
		 * 
		 * setPosition(Point arg) : set the browser position to the specified x and y coordinate values
		 * 
		 * In WebDriver interface we have manage() which return Options interface reference
		 * In Options interface we have window() which returns Window interface reference
		 * 
		 */
		
		//create Window interface reference
		Options manage = driver.manage();
		Window window = manage.window();
		
		Point position = window.getPosition();
		System.out.println("browser is at x = "+position.getX()+" and y = "+position.getY());
		
		Dimension size = window.getSize();
		System.out.println("browser width is "+size.getWidth()+" and height is "+size.getHeight());
		
		
		window.maximize();
//		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		window.fullscreen();
		Thread.sleep(3000);
		
//		Dimension d = new Dimension(700, 500);
//		window.setSize(d);
		window.setSize(new Dimension(700, 500));
		Thread.sleep(2000);
		
		window.setPosition(new Point(550, 350));
		Thread.sleep(3000);
		
		
		driver.close();
		
		
		
		
		
	}

}
