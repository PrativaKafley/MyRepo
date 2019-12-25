package TestPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LogOutTesting {

	public void LogoutMethod() {
		
		String xpath1 = "//*[@id=\"navbar\"]/ul[2]/li[2]/ul/li[6]/a";
		
		Boolean isPresent = BaseClass.getdriver().findElements(By.xpath(xpath1)).size() > 0;
		String expectedURL = "https://mktint.orepac.com/Account/LogOn";
		
		if(isPresent) {
		WebElement LogoutVar = BaseClass.getdriver().findElement(By.xpath(xpath1));
		Utilities.UtilitiesMethod(BaseClass.getdriver(), xpath1);
		LogoutVar.click();
		
		String actualURL = BaseClass.getdriver().getCurrentUrl();
		String usedURL = actualURL.replaceAll("\\s","%20");

		if(usedURL.equals(expectedURL)) {
			System.out.println("Test 2: Logout Successful!");
			System.out.println(usedURL);
		}else {
			System.out.println("Test 3: Logout Failed!");
		}
		}else {
			System.out.println("Test 3: Log out Button not Found!");
		}
	
		}
	}


