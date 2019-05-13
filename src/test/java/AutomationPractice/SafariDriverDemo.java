package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SafariDriverDemo {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	driver=new SafariDriver();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Google");
	}

}
