package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Utility;

public class MoveMouseOver {
	WebDriver driver;
	Actions action;
	
	@BeforeClass
	public void  setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
	}
	@Test
	public void test() throws InterruptedException {
	action=new Actions(driver);
	WebElement element=driver.findElement(By.xpath("//button[text()='Automation Tools']"));
	action.moveToElement(element).perform();
	driver.findElement(By.xpath("//a[text()='Selenium']")).click();
	Thread.sleep(5000);
	Utility.captureScreenshot(driver, "firstTabScreenshot");
	action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
	action.moveToElement(element).perform();
	driver.findElement(By.xpath("//a[text()='TestNG']")).click();
	Utility.captureScreenshot(driver, "secondTabScreenshot");
	}
	
	@AfterClass
	public void close() throws InterruptedException {
	Thread.sleep(5000);
	driver.quit();
	}

}
