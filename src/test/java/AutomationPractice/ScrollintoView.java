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

public class ScrollintoView {
	WebDriver driver;
	JavascriptExecutor je;

	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		je = (JavascriptExecutor) driver;
	}

	@Test
	public void test1() {
		WebElement element = driver.findElement(By.xpath("//div[@id='mCSB_3_container']/p[3]"));
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println(element.getText());
		WebElement element2 = driver.findElement(By.xpath("//div[@id='mCSB_1_container']/p[3]"));
		je.executeScript("arguments[0].scrollIntoView(true)", element2);
		System.out.println(element2.getText());
		Utility.captureScreenshot(driver, "scrollIntoView");
	}

	@AfterClass
	public void close() throws InterruptedException {
		driver.quit();

	}

}
