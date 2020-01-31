package webtables_and_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class AutoSuggestionsDemo extends BrowserHelper {

	public static void main(String[] args) {
		String expSugText = "selenium webdriver architecture";
		launchBrowser("chrome", "http://www.google.com");
		sleep(3000);
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		sleep(2000);
		// locate a list which contains all the suggestions
		WebElement suggestionsList = driver.findElement(By.cssSelector(".erkvQe"));
		// locate all the suggestions i.e. li tags with in suggestionsList element
		List<WebElement> suggestions = suggestionsList.findElements(By.tagName("li"));
		// iterate over every suggestion
		for (WebElement suggestion : suggestions) {
			// retrieve the inner text of every suggestion
			String actSugText = suggestion.getText();
			// compare that suggestion text with the desired suggestion 
			if(actSugText.equals(expSugText)) {
				// if matches then click on that suggestion
				suggestion.click();
				break;
			}
		}		
		sleep(3000);
		closeBrowser();
	}

}
