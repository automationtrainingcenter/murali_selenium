package webtables_and_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class NSEIndiaOne extends BrowserHelper{
	public static void main(String[] args) {
		String expCompanyCode = "TCS";
		launchBrowser("firefox", "https://www1.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		sleep(2000);
		// locate table body
		WebElement tbody = driver.findElement(By.cssSelector("#preOpenNiftyTab>tbody"));
		// locate all the rows with in that table body
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// iterate over every row from 3rd row onwards
		for(int i = 2; i < rows.size(); i++) {
			// locate all the columns with in every row
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			// retrieve company code which is in first column
			String actCompanyCode = columns.get(0).getText();
			// compare that company code with expected company code
			if(actCompanyCode.equalsIgnoreCase(expCompanyCode)) {
				// if matches retrieve share price of the company which is in fourth column
				String sharePrice = columns.get(3).getText();
				System.out.println("share price of "+actCompanyCode+" is Rs "+sharePrice);
				//break the rows loop
				break;
			}
		}
		closeBrowser();
	}
}
