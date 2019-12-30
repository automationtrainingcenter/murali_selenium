package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingTechniques {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		// locating an element using id attribute
//		By emailId = By.id("email123");
//		WebElement emailTextBox = driver.findElement(emailId);
		WebElement emailTextBox = driver.findElement(By.id("email"));
		
		// locating an element using name attribute
		By firstNameLoc = By.name("firstname");
		WebElement firstNameEle = driver.findElement(firstNameLoc);
		
		// linktext: locating a link using link text i.e. the text in between <a> and </a> tags
		By forgottenLoc = By.linkText("Forgotten account?");
		WebElement forgottenLink = driver.findElement(forgottenLoc);
		
		// partialLinkText: locating a link using part of the link text
		By createaPageLoc = By.partialLinkText("Create a");
		WebElement createaPageLink = driver.findElement(createaPageLoc);
		
		
		// cssSelector: is used to locate an element using any attribute value of that element
		// syntax: tagname[att.name = 'att.value']
		By femaleLoc = By.cssSelector("input[value='1']");
		WebElement femaleRadio = driver.findElement(femaleLoc);
		
		
		// xpath: is used to locate an element using any attribute value of that element
		// syntax: //tagname[@att.name = 'att.value']
		By maleLoc = By.xpath("//input[@value='2']");
		WebElement maleRadio = driver.findElement(maleLoc);
		
		// tagName: is used to locate element or elements using name of the tag
		By atagloc = By.tagName("a");
		List<WebElement> links = driver.findElements(atagloc);
		System.out.println("number of links in page is "+links.size());
		
		// className: is used to locate element or elements using class name of element
		By textfieldsLoc = By.className("inputtext");
		List<WebElement> textfields = driver.findElements(textfieldsLoc);
		System.out.println("number of text fields = "+textfields.size());
		
		driver.close();
		
	}

}
