package newpackage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareUserName extends Utilities{
	
	//private WebElement actualvalue;
	
	
	public void CompareMethod(WebDriver driver) {
	
	String xpath1 = "//*[@id='navbar']/ul[2]/li[2]/a";	
	String xpath2 = "//*[@id='navbar']/ul[2]/li[2]/ul/li[2]/li[3]/li[6]/a";
		
		
		
		
	WebElement head=driver.findElement(By.xpath(xpath1));
	Utilities.UtilitiesMethod(driver, xpath1);
	head.click();
	
	String exp = "testbranchadmin01@orepac.com";
	
	Boolean isPresent = driver.findElements(By.xpath(xpath2)).size() > 0;
	if(isPresent) {
	try {
		WebElement actualvalue = driver.findElement(By.xpath(xpath2));
		
		Utilities.UtilitiesMethod(driver, xpath2);
		
		String b = actualvalue.getText();
		//Assert.assertEquals(String actual, String expected);
		if(exp.equalsIgnoreCase(b))
		{
			System.out.println("Success");
		}
		else {
			System.out.println(b);
		}
	}catch(NoSuchElementException e) {
		System.out.println(e.getMessage());
	}
	}else {
		System.out.println("Actual Value not found!");
	}
	
	}
}
