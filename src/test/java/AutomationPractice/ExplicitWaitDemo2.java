package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ExplicitWaitDemo2 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void explicitWaitTest() {
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		WebElement clickOnTry = driver.findElement(By.xpath("//*[contains(text(),'Click on')]"));
		Assert.assertTrue(clickOnTry.isDisplayed());
		WebElement clickMeToStart = driver.findElement(By.xpath("//*[contains(text(),'Click me to start')]"));
		clickMeToStart.click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='WebDriver']")));
		WebElement waitWebDriver = driver.findElement(By.xpath("//*[text()='WebDriver']"));
		Assert.assertTrue(waitWebDriver.isDisplayed());
	}

}
