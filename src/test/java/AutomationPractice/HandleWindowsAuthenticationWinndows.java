package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class HandleWindowsAuthenticationWinndows {
	//https://the-internet.herokuapp.com/basic_auth
	
	WebDriver driver;
		
		@Test
		public void setUp() throws InterruptedException {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			driver.get("https://the-internet.herokuapp.com/basic_auth");
			driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
			Thread.sleep(5000);
			driver.quit();
		}
}
