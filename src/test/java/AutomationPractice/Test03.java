package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test03 {
	

	@Test
	public void selectDDValues() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement monthDropdown = driver.findElement(By.id("month"));
		Select month = new Select(monthDropdown);
		month.selectByIndex(3);
		Thread.sleep(5000);
		month.selectByValue("10");
		Thread.sleep(5000);
		month.selectByVisibleText("Jul");

	}

}
