package newpackage;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.ie.InternetExplorerDriver; 
//import org.openqa.selenium.support.ui.WebDriverWait;

public class OrpacLoginTest{
	
	
	public void loginpage(WebDriver driver){
        String baseUrl = "https://typeyoururl.com";
        driver.manage().window().maximize(); 
        driver.get(baseUrl);
        
        
        String IdUser = "UserName";
        String Idpasswo = "Password";
        Boolean isPresent = driver.findElements(By.id(IdUser)).size() > 0;
        Boolean isPresentPass = driver.findElements(By.id(Idpasswo)).size() > 0;
        //driver.findElement(By.id(IdUser));
        if(isPresent) {
        WebElement username=driver.findElement(By.id(IdUser));
        
        Utilities.UtilitiesMethod(driver, IdUser);
        username.sendKeys("youruserid");
        }
        else {
        	System.out.println("Text box to enter User Name not found!");
        }
        
        if(isPresentPass) {
        	WebElement password=driver.findElement(By.id(Idpasswo));
        	password.sendKeys("yourpassword");
        }
        else {
        	System.out.println("Text box to enter password not found!");
        }
        
        
        String classNamelogin = "btn-primary";
        Boolean isPresentlogin = driver.findElements(By.className(classNamelogin)).size() > 0;
        
        System.out.println("Log In Button Status:" + isPresentlogin);
        
        if(isPresentlogin) {
        	
        WebElement login = driver.findElement(By.className(classNamelogin));
        login.click();
        
        }
        else {
        	System.out.println("Clicking login button failed!");
        }
        String expectedUrl = driver.getCurrentUrl();
        
        String actualUrl="https://mktint.orepac.com/";
        if(expectedUrl.equalsIgnoreCase(actualUrl)) {
        System.out.println("Log in success!");
        
        }else{
        	System.out.println("Log in failed!");
        }
	}
}

       
       
  
	
	
	


