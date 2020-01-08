package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * to automate dropdown list or list box we have to use Select class
 * 
 * Select class contains several methods to select an option from a drop down list or list box
 * Drop down list does not allow deselecting an option but list box allows deselection
 * Drop down list allows only one option selection but list box allows multiple option selection
 * 
 */
public class DropDownListDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		
		// locate drop down list
		WebElement carDropDownEle = driver.findElement(By.id("carselect"));
		
		// create an object of Select class
		Select carSelect = new Select(carDropDownEle);
		
		// retrieve default selected option of the car drop down list
		WebElement firstSelectedOption = carSelect.getFirstSelectedOption();
		System.out.println("first selected option is "+firstSelectedOption.getText());
		
		// select an option based on index number of the option tag
		carSelect.selectByIndex(1); // 2nd option i.e. benz
		Thread.sleep(2000);
		
		// select an option based value of the value attribute of the option tag
		carSelect.selectByValue("honda"); // 3rd option i.e honda
		Thread.sleep(2000);
	
		// select an option based on the inner text of the option tag
		carSelect.selectByVisibleText("BMW");
		Thread.sleep(2000);
		
		// retrieve all the options of the drop down list
		List<WebElement> options = carSelect.getOptions();
		System.out.println("number of options are "+options.size());
		for(WebElement option : options) {
			System.out.println(option.getText());
		}
		
		
		driver.close();
	}

}
