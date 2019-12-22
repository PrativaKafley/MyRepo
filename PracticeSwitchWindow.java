package newpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
 
public class PracticeSwitchWindow {
 
public static WebDriver driver;
 
public static void main(String[] args) {  //https://www.toolsqa.com/automation-practice-switch-windows/
 
// Create a new instance of the Firefox driver
 
		System.setProperty("webdriver.ie.driver","C:\\Users\\itspr\\Desktop\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
 
        // Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        // Launch the URL
 
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");
 
        // Store and Print the name of the First window on the console
 
        String handle= driver.getWindowHandle();
 
        System.out.println(handle);
 
        // Click on the Button "New Message Window"
 
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div[1]/div[2]/div/div/div/div/p[3]/button")).click();
 
        // Store and Print the name of all the windows open
        String expectedURL = "https://www.toolsqa.com/";   //https://www.toolsqa.com/automation-practice-switch-windows/
 
        String handleBefore = driver.getWindowHandle();
 
        System.out.println(handleBefore);
 
        // Pass a window handle to the other window
 
       
         driver.switchTo().window(handleBefore);
         
         List<String> urlList = new ArrayList<String>();
         //valueList.add("Joe");
         //valueList.add("John");
         //valueList.add("Sean");
         
         for(String winHandle : driver.getWindowHandles()){
        	    driver.switchTo().window(winHandle);
        	    String actualURL = driver.getCurrentUrl();
        	    urlList.add(actualURL);
         }
         
         //long count = urlList.stream().count();
         Stream<String> stream = urlList.stream();
         String last = stream.reduce((a, b) -> b).orElse(null);
         
         System.out.println(last);
         
         urlList.stream().reduce((a, b) -> b).ifPresent(s -> System.out.println(s));
         
         if(last.equalsIgnoreCase(expectedURL)) {
           	 System.out.println("passed!");
           	 System.out.println(last);
           	 System.out.println(expectedURL);
            }else {
           	 System.out.println("failed!");
           	 System.out.println(last);
           	 System.out.println(expectedURL);
            }
             
         //stream.skip(count - 1).findFirst().get();  
        
        // Closing Pop Up window
 
        //driver.close();
 
        // Close Original window
 
       // driver.quit();
 
}
 
}