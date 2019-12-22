package newpackage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import newpackage.OrpacLoginTest;

public class CreateQuoteTest {
	public void CreateQuoteMethod(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriver driver = new InternetExplorerDriver();
		driver.findElement(By.linkText("Create Quote")).click();
		
		
	}

}
