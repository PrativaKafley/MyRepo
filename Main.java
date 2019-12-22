package newpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		//String expected="";
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
												//Add path of IEDriver from the local machine where builds is running
												.usingDriverExecutable(new File("C:\\Users\\itspr\\Desktop\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe"))
												.usingAnyFreePort()
												.build();
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.merge(capabilities);
		InternetExplorerDriver driver = new InternetExplorerDriver(service, options);
		
		
		
		OrpacLoginTest login = new OrpacLoginTest();
		login.loginpage(driver);
		
		/*CreateQuoteTest CQT = new CreateQuoteTest();
		CQT.CreateQuoteMethod(driver);*/
		
		/*CompareUserName comp = new CompareUserName();
		comp.CompareMethod(driver);
		*/
		
  
        // Store current System.out before assigning a new value 
       // PrintStream console = System.out; 
  
       
        //System.out.println("This will be written to the text file"); 
		
		// Creating a File object that represents the disk file. 
        PrintStream o = new PrintStream(new File("A.txt")); 
        
        // Assign o to output stream 
        System.setOut(o); 
		
		
		
		LogOutTesting logout = new LogOutTesting();
		logout.LogoutMethod(driver);
		
		
		
       
    }
	

}
