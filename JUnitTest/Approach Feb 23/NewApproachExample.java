package TestPkg;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

import java.net.URL;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	public class OrpacLoginTest {
		public static String urlMethod() {
			List<String> UrlList = new ArrayList<>();
			
			//UrlList.add("https://mktint.orepac.com/Account/LogOn?ReturnUrl=%2f");
			UrlList.add("http://localhost:8080/RadioButtonJSFRad/");
			//UrlList.add("https://mpstage.int.orepac.com/Account/LogOn?ReturnUrl=%2f");
			
			URL urlUsed = null;
			URL urlValid = null;
			HttpsURLConnection huc;
			for(int i =0; i < UrlList.size(); i++) {
				try {
				
			    urlUsed = new URL(UrlList.get(i));
				System.out.println("Item : "+ i + urlUsed);
				
					huc = (HttpsURLConnection) urlUsed.openConnection();
					huc.setRequestMethod("HEAD");
					huc.setConnectTimeout(30000);
					huc.setReadTimeout(30000);
					if(huc.getResponseCode() == HttpsURLConnection.HTTP_OK)
					{
						urlValid = urlUsed;
						System.out.println("Your Current URL is : " + urlValid);
						break;
						
					}
				}
				catch (Exception e){
					System.out.println("Error: " + e.getMessage());
				}	
			}	
			return urlUsed.toString();
		}
	
		public void WebMethod() {	
			 String baseUrl = urlMethod();
			 System.out.println("Passed URL is : " + baseUrl);
		     BaseClass.getdriver().manage().window().maximize(); 
		     BaseClass.getdriver().get(baseUrl);
		     
		     List<String> button = new ArrayList<String>();
		     button.add("input[type='radio'][value='335']");
		     button.add("input[type='radio'][value='316']");
		     button.add("input[type='radio'][value='M3 SMG']");
		     button.add("input[type='submit'][value='Submit']");
		     
		     for(String ele: button) {
		    	 WebElement webele = BaseClass.getdriver().findElement(By.cssSelector(ele));
		    	 webele.click();
		     }
		     //driver.FindElement(By.cssSelector(input[type='radio'][value='3.2']));
		 /*     
	      //String IdUser = "UserName";
	      String Idpasswo = "Password";
	      List<String> list = new ArrayList<String>();
	      list.add("UserName");
	      list.add("Password");
	      for(String element: list) {
	    	  if(element.equalsIgnoreCase("UserName")) {
	    		  WebElement elmn = BaseClass.getdriver().findElement(By.id(element));
	    		  elmn.sendKeys("yourusername");
	    	  }else if(element.equalsIgnoreCase("Password")) {
	    		  WebElement elmn1 = BaseClass.getdriver().findElement(By.id(element));
	    	  	  elmn1.sendKeys("userpassword");
	    	 
	      }
	      //Boolean isPresent = BaseClass.getdriver().findElements(By.id(IdUser)).size() > 0;
	      //Boolean isPresentPass = BaseClass.getdriver().findElements(By.id(Idpasswo)).size() > 0;

	     /* if(isPresent) {
	      WebElement username=BaseClass.getdriver().findElement(By.id(IdUser));
	      
	      Utilities.UtilitiesMethod(BaseClass.getdriver(), IdUser);
	      username.sendKeys("yourusername");
	      }
	      else {
	      	System.out.println("Text box to enter User Name not found!");
	      }
	      
	      if(isPresentPass) {
	      	WebElement password=BaseClass.getdriver().findElement(By.id(Idpasswo));
	      	password.sendKeys("PasswordHere");
	      }
	      else {
	      	System.out.println("Text box to enter password not found!");
	      }*/
	      
	     /* 
	      String classNamelogin = "btn-primary";
	      Boolean isPresentlogin = BaseClass.getdriver().findElements(By.className(classNamelogin)).size() > 0;
	      
	      System.out.println("Log In Button Status:" + isPresentlogin);
	      
	      if(isPresentlogin) {
	      	
	      WebElement login = BaseClass.getdriver().findElement(By.className(classNamelogin));
	      login.click();
	      
	      }
	      else {
	      	System.out.println("Clicking login button failed!");
	      }
	      String expectedUrl = BaseClass.getdriver().getCurrentUrl();
	      
	      String actualUrl="https://yourwebsite.com/";
	      if(expectedUrl.equalsIgnoreCase(actualUrl)) {
	      System.out.println("Test 1: Log in Successful!");
	      
	      }else{
	      	System.out.println("Test 1: Log in Failed!");
	      }
		}*/
	}}
