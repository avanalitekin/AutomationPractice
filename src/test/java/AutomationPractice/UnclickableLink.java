package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnclickableLink {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/");
	}

	@Test
	public void testClick() {
		driver.findElement(By.xpath("//*[@id='login-username-form']/p[2]/span[1]/label")).click();

	}

	@Test
	public void testMouseOver() throws InterruptedException {
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.id("persistent"));
		element.click();
//		Actions action = new Actions(driver);
//		action.moveToElement(element).click().build().perform();

	}

	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}
}
