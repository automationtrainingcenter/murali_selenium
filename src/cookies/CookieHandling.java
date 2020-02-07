package cookies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CookieHandling{
	static WebDriver driver;
	// open browser
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=my-account");
	}
	
	
	// login
	public void login() {
		driver.findElement(By.id("email")).sendKeys("test@sunshine.com");
		driver.findElement(By.id("passwd")).sendKeys("selenium");
		driver.findElement(By.id("SubmitLogin")).click();
		storeCookieData();
	}
	
	// close browser
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	
	public void storeCookieData() {
		Set<Cookie> cookies = driver.manage().getCookies();
		try {
			File file = new File(".//cookiedata.txt");
			FileWriter fw = new FileWriter(file);
			String cookieData = "";
			for(Cookie cookie : cookies) {	
				String name = cookie.getName();
				String path = cookie.getPath();
				String value = cookie.getValue();
				String domain = cookie.getDomain();
				Date expiry = cookie.getExpiry();
				cookieData = name+";"+path+";"+value+";"+domain+";"+expiry+"\n";
			}
			fw.write(cookieData);
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void loadCookieData(String fileName) {
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			while(line != null) {
				String[] values = line.split(";");
				String name = values[0];
				String path = values[1];
				String value = values[2];
				String domain = values[3];
				// Thu Feb 27 11:15:44 IST 2020 -- E MMM dd hh:mm:ss z yyyy
				DateFormat df = new SimpleDateFormat("E MMM dd hh:mm:ss z yyyy");
				Date expiry = df.parse(values[4]);
				Cookie cookie = new Cookie(name, value, domain, path, expiry);
				driver.manage().addCookie(cookie);
				line = br.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("http://automationpractice.com/index.php?controller=my-account");
	}
	
	
	// add a product to cart
	public void addToCart() throws InterruptedException {
		WebElement womenMenu = driver.findElement(By.cssSelector("#block_top_menu a[title='Women']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(womenMenu).build().perform();
		Thread.sleep(1000);
		WebElement tshirts = driver.findElement(By.xpath("(//a[text()='T-shirts'])[1]"));
		actions.moveToElement(tshirts).click().build().perform();
		Thread.sleep(1000);
		WebElement tshirt = driver.findElement(By.xpath("(//ul[contains(@class,'product_list')]/li)[1]"));
		actions.moveToElement(tshirt).build().perform();
		tshirt.findElement(By.xpath(".//a[@title='Add to cart']")).click();
		Thread.sleep(3000);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		CookieHandling obj = new CookieHandling();
		obj.openBrowser();
//		obj.login();
		obj.loadCookieData(".//cookiedata.txt");

//		obj.addToCart();
		
		
		obj.tearDown();
	}

}
