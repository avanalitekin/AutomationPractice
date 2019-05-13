package AutomationPractice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyTitles {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://learn-automation.com");
	}

	@Test
	public void verifyTitle() {

		String titleOnThePage = driver.getTitle();
		System.out.println("Title is " + titleOnThePage);
		String titleExpected = "Selenium WebDriver tutorial - Selenium WebDriver tutorial Step by Step";
//		Assert.assertEquals(titleOnThePage,titleExpected);
//		Assert.assertTrue(titleOnThePage.equals(titleExpected));
		Assert.assertTrue(titleOnThePage.contains(titleExpected));
		System.out.println("Test completed and page title has been verified");
	}

	@Test
	public void verifyTitleWithPageSource() {
		String titleOnThepage = driver.getPageSource();
		System.out.println("Title in the page source" + titleOnThepage);
		String titleExpected="Selenium WebDriver tutorial - Selenium WebDriver tutorial Step by Step";
		Assert.assertTrue(titleOnThepage.contains(titleExpected));
		System.out.println("Test completed and page title has been verified with page source");
	}

	@AfterMethod
	public void closeUp() {
		driver.quit();
	}

}
