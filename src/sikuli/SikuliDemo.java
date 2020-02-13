package sikuli;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/*
 * Sikuli works with visual image match technology
 * Sikuli mainly contains two classes
 * 
 * Pattern : is used to store element images. Every Pattern class object will store one element image
 * Screen : is used to perform actions on the elements
 */
public class SikuliDemo {
	private static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName +File.separator + fileName;
	}

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement chooseFilesEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Choose Files']")));
		chooseFilesEle.click();
		Thread.sleep(3000);
		
		// create Pattern class objects for filename and open button elements
		Pattern fileNameEle = new Pattern(getFilePath("images", "fileName.PNG"));
		Pattern openButtonEle = new Pattern(getFilePath("images", "openButton.PNG"));
		
		// Create a Screen class object
		Screen screen = new Screen();
		try {
			screen.find(fileNameEle);
			screen.type(fileNameEle, "E:\\selenium\\web services testing.docx");
			Thread.sleep(2000);
			screen.find(openButtonEle);
			screen.click(openButtonEle);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
	
	}

}
