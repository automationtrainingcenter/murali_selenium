package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBoxDemo {
	// submit assignment to suryaprathipati@hotmail.com

	/*
	 * list box allows multiple option selection and also deselection of options.
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate the list box
		WebElement fruitsLBEle = driver.findElement(By.id("multiple-select-example"));
		// Create a Select class object
		Select fruitsSelect = new Select(fruitsLBEle);

		// get all the options of the list box
		List<WebElement> options = fruitsSelect.getOptions();
		System.out.println("number options available in fruits list box is " + options.size());

		// verify select tag supports multiple options selection
		System.out.println("fruist select supports multiple option selection " + fruitsSelect.isMultiple());

		// select an option based on the index number
		fruitsSelect.selectByIndex(1); // Orange
		Thread.sleep(2000);

		// select an option based on the value of the value attribute
		fruitsSelect.selectByValue("apple");
		Thread.sleep(2000);

		// get all selected options
		List<WebElement> allSelectedOptions = fruitsSelect.getAllSelectedOptions();
		System.out.println("number of options selected are "+allSelectedOptions.size());

		// select an option based on the inner text of the option tag
		fruitsSelect.selectByVisibleText("Peach");
		Thread.sleep(2000);

		// deselect all the selected options
//		fruitsSelect.deselectAll();
//		Thread.sleep(2000);
		
		// deselect an option based on index number
		fruitsSelect.deselectByIndex(2);
		Thread.sleep(2000);
		
		// deselect an option based on value of the value attribute
		fruitsSelect.deselectByValue("apple");
		Thread.sleep(2000);
		
		// deselect an option based on the inner text of the option tag
		fruitsSelect.deselectByVisibleText("Orange");
		Thread.sleep(2000);
		
		
		
		
		driver.close();
	}
}
