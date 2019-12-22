package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static void UtilitiesMethod(WebDriver driver,String a) {
		
		if(a.contains("xpath")) {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(a)));
	     el.getText();
	     //System.out.println("Element not found!");
	
	}else if(a.contains("Id")) {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(a)));
	     el.getText();
	     //System.out.println("Id not found!");
	}else if(a.contains("className")) {
			 WebDriverWait wait = new WebDriverWait(driver, 10);
		     WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(a)));
		     el.getText();
			
	}else if(a.contains("cssSelector")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		     WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(a)));
		     el.getText();
	}else if(a.contains("linkText")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		     WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(a)));
		     el.getText();
			
		}
	}

}
