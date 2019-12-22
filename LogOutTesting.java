package newpackage;

//import java.util.concurrent.TimeUnit;

//import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutTesting extends Utilities {
	public void LogoutMethod(WebDriver driver) {
		
		String xpath1 = "//*[@id=\"navbar\"]/ul[2]/li[2]/ul/a";
		
		Boolean isPresent = driver.findElements(By.xpath(xpath1)).size() > 0;
		String expectedURL = "https://mktint.orepac.com/Account/LogOn";
		
		if(isPresent) {
		WebElement LogoutVar = driver.findElement(By.xpath(xpath1));
		Utilities.UtilitiesMethod(driver, xpath1);
		LogoutVar.click();
		
		String actualURL = driver.getCurrentUrl();
		String usedURL = actualURL.replaceAll("\\s","%20");
		//String resultURL = java.net.URLDecoder.decode(actualURL, StandardCharsets.UTF_8.name());
		if(usedURL.equals(expectedURL)) {
			System.out.println("Logout passed!");
			System.out.println(usedURL);
		}else {
			System.out.println("Logout failed!");
		}
		}else {
			System.out.println("Log out button not found!");
		}
	
		}
	}


