package reports_and_logs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.aventstack.extentreports.Status;

public class Listener extends BaseClass implements WebDriverEventListener{

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		System.out.println("alert accepted successfully");
		test.log(Status.INFO, "alert accepted successfully");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		JavascriptExecutor js = (JavascriptExecutor) arg1;
		String text = js.executeScript("return arguments[0].value", arg0).toString();
		System.out.println("element value changed successfully to "+text);
		test.log(Status.INFO, "element value changed successfully to "+text);
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("clicked on that element");
		test.log(Status.INFO, "clicked on that element");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("element located successfully with "+arg0);
		test.log(Status.INFO, "element located successfully with "+arg0);
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("driver successfully navigated to "+arg0);
		test.log(Status.INFO, "driver successfully navigated to "+arg0);
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println("alert came with text as "+arg0.switchTo().alert().getText());
		test.log(Status.INFO, "alert came with text as "+arg0.switchTo().alert().getText());
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("changing element value");
		test.log(Status.INFO, "changing element value");
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("clicking on that element");
		test.log(Status.INFO, "clicking on that element");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("locating an element using "+arg0);
		test.log(Status.INFO, "locating an element using "+arg0);
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("navigating to "+arg0);
		test.log(Status.INFO, "navigating to "+arg0);
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
