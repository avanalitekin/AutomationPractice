package AutomationPractice;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Utility;

public class Waits {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		

	}

	@Test
	public void test1() throws InterruptedException {
		String timer = driver.findElement(By.xpath("//*[@id='clock']")).getText();
		System.out.println(timer);
		String changingColor = driver.findElement(By.cssSelector("#colorVar")).getAttribute("style");
		System.out.println(changingColor);
		Thread.sleep(10000);
		String changingColor2 = driver.findElement(By.cssSelector("#colorVar")).getAttribute("style");
		System.out.println(changingColor2);
		String colorDoubleClick = driver.findElement(By.cssSelector("#doubleClick")).getAttribute("style");
		System.out.println(colorDoubleClick);
		driver.findElement(By.cssSelector("#doubleClick"));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.doubleClick(driver.findElement(By.cssSelector("#doubleClick"))).build().perform();
		Utility.captureScreenshot(driver, "doubleClickCheck");
		Thread.sleep(2000);
		String colorAfterDoubleClick = driver.findElement(By.cssSelector("#doubleClick")).getAttribute("style");
		System.out.println(colorAfterDoubleClick);

	}

	@AfterMethod
	public void closeUp() {
		driver.quit();

	}

}
