package AutomationPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Utility;

public class VerifyErrorMessage {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/gmail/about/#");
		driver.findElement(By.cssSelector("a.gmail-nav__nav-link.gmail-nav__nav-link__sign-in")).click();
	}
	@Test
	public void errorMessage1() {
		driver.findElement(By.cssSelector("#identifierNext > content > span")).click();
		Utility.captureScreenshot(driver, "gmailErrorMessage");
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]/div")).getText();
		String expectedErrorMessage="Please enter your email.";
		System.out.println("Actual Error on the page: "+actualErrorMessage);
		System.out.println("Expected Error on the page: "+expectedErrorMessage);
		Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));
		System.out.println("Test completed. Error message verified");
		
	}
	@AfterMethod
	public void closeUp() {
		driver.quit();
	}
}
