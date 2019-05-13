package AutomationPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollUpDown {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://jqueryui.com");
	Thread.sleep(3000);
	}
	@Test
	public void test() throws InterruptedException {
	((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
	Thread.sleep(3000);
	((JavascriptExecutor)driver).executeScript("scroll(0,500)");
	Thread.sleep(3000);
	((JavascriptExecutor)driver).executeScript("scroll(0,0)");
	
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();		
	}
	}

