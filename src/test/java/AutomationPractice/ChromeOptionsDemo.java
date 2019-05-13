package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeOptionsDemo {
	
	WebDriver driver;
	ChromeOptions options;
	
	@BeforeClass
	public void setUp() {
		
		options=new ChromeOptions();
//		options.addExtensions(new File(""));
		options.addArguments("--disable-infobars");
//		driver=new ChromeDriver();
//		options.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(options);
		
	}
	
	@Test
	public void test() {
		driver.get("https://www.google.com");
		
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
