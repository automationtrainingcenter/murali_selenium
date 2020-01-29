package webtables_and_calendars;
/*
 * To handle web tables
 * 1. locate table tbody tag and store in a variable
 * 2. locate all the rows inside the tbody tag using tr tag
 * 3. iterate over every row then locate all the columns in every row using td tag
 * 4. iterate over the columns and automate them
 * 
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class WebTableHandling extends BrowserHelper{
	public static void main(String[] args) {
		// launch browser
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		sleep(3000);
		// locate tbody tag of the web table and store in a variable
		WebElement tbody = driver.findElement(By.cssSelector("#product>tbody"));
		// locate all rows "with in the table body" using tr tag
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// iterate over the rows from second row onwards
		for(int i = 1; i < rows.size(); i++) {
			// locate all the columns in each and every row
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			// iterate over the columsn
			for(WebElement column : columns) {
				// retrieve each column data and print on the console
				System.out.print(column.getText()+"\t");
			}
			System.out.println();
			
		}
		
		closeBrowser();
	}

}
