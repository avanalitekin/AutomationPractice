package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Utility;

public class ScrollTest {
	WebDriver driver;
	JavascriptExecutor je;
	
	@BeforeClass
	public void setup() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://learn-automation.com/");
	je=(JavascriptExecutor)driver;
	}
	
	@Test
	public void test() {
	WebElement element=driver.findElement(By.xpath("//a[text()='How To Create Selenium Test using NUnit Framework']"));
	je.executeScript("arguments[0].scrollIntoView(true)", element);
	System.out.println(element.getText());
	Utility.captureScreenshot(driver, "scrollDownToCapture");
	}
	@AfterClass
	public void close() {
	driver.quit();
	}

}
