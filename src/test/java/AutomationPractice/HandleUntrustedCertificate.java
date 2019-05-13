package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleUntrustedCertificate {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
		
		 // Create object of DesiredCapabilities class
		DesiredCapabilities desiredCap=DesiredCapabilities.chrome();
		 
		// Set ACCEPT_SSL_CERTS  variable to true
		desiredCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 		 
		// Open browser with capability
		driver=new ChromeDriver(desiredCap);
		
		
	}
	@Test
	public void handleCertificate() {
	
	driver.get("https://www.cacert.org/");
	//attempt to open insecure sites without implementing this method is expected to fail.
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
