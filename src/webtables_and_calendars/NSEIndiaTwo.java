package webtables_and_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class NSEIndiaTwo extends BrowserHelper {
	public static void main(String[] args) {
		String expCompanyCode = "TITAN";
		launchBrowser("chrome",
				"https://www1.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		sleep(3000);
		// locate web table
		WebElement tbody = driver.findElement(By.cssSelector("#preOpenNiftyTab>tbody"));
		// locate all the rows with in the table using tr tag
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// iterate over the rows
		for (int i = 2; i < rows.size(); i++) {
			// locate all the columns in every row using td tag
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			// retrieve inner text i.e company code of the first column
			String actComanyCode = columns.get(0).getText();
//			System.out.println(actComanyCode);
			// compare actual company code with expected company code
			if(actComanyCode.equals(expCompanyCode)) {
				// if they match then click on link which is inside that column
				WebElement link = columns.get(0).findElement(By.tagName("a"));
				
				// bring that link to the view before click
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView()", link);
				sleep(3000);
				link.click();
				break;
			}
		}
		sleep(5000);
		closeBrowser();
	}

	private static void click() {
		// TODO Auto-generated method stub
		
	}

}
