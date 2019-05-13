package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class ExplicitWaitDemo1 {
	WebDriver  driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
	}
	
	@Test
	public void test() {
	WebElement clickOnText=driver.findElement(By.xpath("//*[contains(text(),'Click on')]"));
	Assert.assertTrue(clickOnText.isDisplayed());
	driver.findElement(By.xpath("//*[text()='Click me to start timer']")).click();
	wait=new WebDriverWait(driver, 10);
	WebElement webdriver1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'WebDriver')]")));
	Assert.assertTrue(webdriver1.isDisplayed());
	driver.findElement(By.xpath("//*[text()='Click me to start timer']")).click();
	wait=new WebDriverWait(driver, 10);
	WebElement webdriver2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'WebDriver')]")));
	Assert.assertTrue(webdriver2.isDisplayed());
	driver.findElement(By.xpath("//*[text()='Click me to start timer']")).click();
	wait=new WebDriverWait(driver, 10);
	WebElement webdriver3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'WebDriver')]")));
	Assert.assertTrue(webdriver3.isDisplayed());
	
	WebElement webDriverElement=driver.findElement(By.xpath("//p[text()='WebDriver']"));
	boolean status=webDriverElement.isDisplayed();
	if(status)
	System.out.println("=========== Webelement is displayed ===========");
	else
	System.out.println("=========== Webelement is NOT displayed ===========");

	}
	
	@AfterMethod
	public void closeUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
}