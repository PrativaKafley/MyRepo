package TestPkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;		
	}
	
	@BeforeClass
	public static void beforeSuite() {
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
		driver = new InternetExplorerDriver(service, options);
		
	}
	
	public static WebDriver getdriver() {
		if(driver == null) {
			driver = new InternetExplorerDriver();
			return driver;
		}else {
			return driver;
		}
	}
	
	@BeforeClass
     public static void OutComeTest() {
		 // Creating a File object that represents the disk file. 
	        PrintStream o = System.out;
			try {
				o = new PrintStream(new File("A.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	  
	        // Store current System.out before assigning a new value 
	       // PrintStream console = System.out; 
	  
	        // Assign o to output stream 
	        System.setOut(o); 
	        //System.out.println("This will be written to the text file"); 
	  
	        // Use stored value for output stream 
	       // System.setOut(console); 
	       // System.out.println("This will be written on the console!"); 
	}
	
	@Test
	public  void signIn() {
		OrpacLoginTest login = new OrpacLoginTest();
		login.WebMethod();
	}
	

	@Test
	public void compName() {
		CompareUserName compUserNam = new CompareUserName();
		compUserNam.CompareMethod();
	}

	@Test
	public void signOut() {
		LogOutTesting logout = new LogOutTesting();
		logout.LogoutMethod();
	}
	
	
}
	
