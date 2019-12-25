package TestPkg;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	public class OrpacLoginTest {
		public void WebMethod() {		
			 String baseUrl = "https://mktint.orepac.com/Account/LogOn?ReturnUrl=%2f";
		     BaseClass.getdriver().manage().window().maximize(); 
		     BaseClass.getdriver().get(baseUrl);
		      
	      String IdUser = "UserName";
	      String Idpasswo = "Password";
	      Boolean isPresent = BaseClass.getdriver().findElements(By.id(IdUser)).size() > 0;
	      Boolean isPresentPass = BaseClass.getdriver().findElements(By.id(Idpasswo)).size() > 0;

	      if(isPresent) {
	      WebElement username=BaseClass.getdriver().findElement(By.id(IdUser));
	      
	      Utilities.UtilitiesMethod(BaseClass.getdriver(), IdUser);
	      username.sendKeys("testbranchadmin01@orepac.com");
	      }
	      else {
	      	System.out.println("Text box to enter User Name not found!");
	      }
	      
	      if(isPresentPass) {
	      	WebElement password=BaseClass.getdriver().findElement(By.id(Idpasswo));
	      	password.sendKeys("Admin!234");
	      }
	      else {
	      	System.out.println("Text box to enter password not found!");
	      }
	      
	      
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
	      
	      String actualUrl="https://mktint.orepac.com/";
	      if(expectedUrl.equalsIgnoreCase(actualUrl)) {
	      System.out.println("Test 1: Log in Successful!");
	      
	      }else{
	      	System.out.println("Test 1: Log in Failed!");
	      }
		}
	}
