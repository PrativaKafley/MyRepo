package TestPkg;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompareUserName{
	
	public void CompareMethod() {
	
	String xpath1 = "//*[@id=\"navbar\"]/ul[2]/li[2]/a/i";
	WebElement head=BaseClass.getdriver().findElement(By.xpath(xpath1));
	head.click();
	String xpath2 = "//*[@id=\"navbar\"]/ul[2]/li[2]/ul/li[2]/a";
	
	String exp = "testbranchadmin01@orepac.com";
	
	Boolean isPresent = BaseClass.getdriver().findElements(By.xpath(xpath2)).size() > 0;
	if(isPresent) {
	try {
		WebElement actualvalue = BaseClass.getdriver().findElement(By.xpath(xpath2));
		
		Utilities.UtilitiesMethod(BaseClass.getdriver(), xpath2);
		
		String b = actualvalue.getText();
		if(exp.equalsIgnoreCase(b))
		{
			System.out.println("Test 2: Successfully Copared Name");
		}
		else {
			System.out.println(b);
		}
	}catch(NoSuchElementException e) {
		System.out.println(e.getMessage());
	}
	}else {
		System.out.println("Test 2: Actual Value not found!");
	}
	
	}
}
