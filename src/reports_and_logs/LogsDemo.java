package reports_and_logs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.ScreenshotHelper;


/*
 * 1. create a listener class which will implement WebDriverEventListener interface
 * 2. Create an object of above class
 * 3. create an object of EventFiringWebDriver class
 * 4. register listener class object (created in step 2) to EventFiringWebDriver object (created in step 3)
 */
public class LogsDemo extends BaseClass{
	
	WebDriver driver;
	ExtentReports report;
	EventFiringWebDriver edriver;
	
	// launch application
	public void launchApp() {
		test = report.createTest("Launch Application");
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		// create an object of Listener class
		Listener listener = new Listener();
		// create object of EventFiringWebDriver
		edriver = new EventFiringWebDriver(driver);
		// register listener class object to EventFiringWebDriver object
		edriver.register(listener);
		
		driver = edriver;
		
		test.log(Status.INFO, "Browser launched successfully");
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(Status.PASS, "launch app passed");
	}
	
	// login
	public void login() {
		test = report.createTest("Login");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		test.log(Status.PASS, "login app passed");
	}
	
	
	// role creation test
	public void roleCreation() {
		test = report.createTest("Role Creation");
		driver.findElement(By.cssSelector("a[href *= 'Roles']")).click();
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys("asstCashier");
		Select roleTypeSelect = new Select(driver.findElement(By.id("lstRtypeN")));
		roleTypeSelect.selectByVisibleText("E");
		driver.findElement(By.id("btninsert")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		test.log(Status.INFO, alertText);
		alert.accept();
		if(alertText.toLowerCase().contains("successfully")) {
			test.log(Status.PASS, "role creation passed");
		}else {
			test.log(Status.FAIL, "role creation Failed");
			String imgPath = ScreenshotHelper.captureScreenshot(driver, "screenshots", "rolecreation");
			try {
				test.addScreenCaptureFromPath(imgPath, "role creation failed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// logout
	public void logout() {
		test = report.createTest("Logout");
		driver.findElement(By.cssSelector("a[href *= 'primus']")).click();
		test.log(Status.PASS, "logout passed");
	}
	
	
	// close application
	public void closeApp() {
		test = report.createTest("Close Application");
		driver.close();
		test.log(Status.PASS, "close application passed");
	}
	
	
	public static void main(String[] args) {
		LogsDemo obj = new LogsDemo();
		// create an ExtentReports class object
		obj.report= new ExtentReports();
		
		// create an object of ExtentHtmlReport
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(".//reports//logreport.html");
		obj.report.attachReporter(reporter);
		obj.launchApp();
		obj.login();
		obj.roleCreation();
		obj.logout();
		obj.closeApp();
		
		// save the report using flush()
		obj.report.flush();
	}


}
