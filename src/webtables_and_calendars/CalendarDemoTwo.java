package webtables_and_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class CalendarDemoTwo extends BrowserHelper {
	public static void selectDate(WebElement tbody, String expDate) {
		boolean status = false;
		// locate all rows using tr tag
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// iterate over the rows
		for (WebElement row : rows) {
			// locate all the columns which contains dates in every row
			List<WebElement> columns = row.findElements(By.tagName("td"));
			// iterate over the columns
			for (WebElement column : columns) {
				// retrieve the column inner text
				String actDate = column.getText();
				// comapre act date with expected data
				if (actDate.equals(expDate)) {
					// click on that date
					column.click();
					status = true;
					break; // it will break columns loop
				}
			}
			if (status) {
				break; // breaks rows loop
			}
		}
	}

	public static void main(String[] args) {
//		String expDate = "31";
		launchBrowser("chrome", "https://www.redbus.in/");
		sleep(3000);
		// locate date of journey element and click on it, it will open date calendars
		driver.findElement(By.cssSelector("label[for='onward_cal']")).click();
		sleep(2000);
		// locate next button to go to feb month
		driver.findElement(By.cssSelector("#rb-calendar_onward_cal .next")).click();
		sleep(2000);
		// locate month calendar
		WebElement dojCal = driver.findElement(By.cssSelector("#rb-calendar_onward_cal tbody"));
		selectDate(dojCal, "13");
		sleep(3000);
		// locare return journy element and click on it
		driver.findElement(By.cssSelector("label[for='return_cal']")).click();
		sleep(2000);
		// locate month calendar
		WebElement dorCal = driver.findElement(By.cssSelector("#rb-calendar_return_cal tbody"));
		selectDate(dorCal, "18");
		sleep(3000);
		closeBrowser();

	}
}
