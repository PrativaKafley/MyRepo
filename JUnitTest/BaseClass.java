package TestPkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
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
	public static final String IE_DRIVER = "Resource//IEDriverServer.exe";
	public static final String LogFile = "Resource//A.txt";
	public static WebDriver getDriver() {
		return driver;		
	}
	
	@BeforeClass
	public static void beforeSuite() {
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		ClassLoader classloader = BaseClass.class.getClassLoader();
		
		InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
												//Add path of IEDriver from the local machine where builds is running
												.usingDriverExecutable(new File(classloader.getResource(IE_DRIVER).getFile()))
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
	
		ClassLoader logFileLoad = BaseClass.class.getClassLoader();
		File file = new File(logFileLoad.getResource(LogFile).getFile());
		String absolutePath = file.getAbsolutePath(); 
	        PrintStream o = System.out;
			try {
				o = new PrintStream(absolutePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	  
	        // Assign o to output stream 
	        System.setOut(o); 
		
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
	
