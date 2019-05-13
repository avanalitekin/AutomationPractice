package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test04 {
	

	@Test
	public void selectDDValues() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebElement monthDropdown = driver.findElement(By.id("month"));
		Select month = new Select(monthDropdown);
		WebElement selectedMonth=month.getFirstSelectedOption();
		System.out.println("First Selected Option before selection : "+selectedMonth.getText());
		
		month.selectByIndex(3);
		
		WebElement selectedMonth2=month.getFirstSelectedOption();
		System.out.println("First Selected Option after selection: "+selectedMonth2.getText());
		
		Assert.assertTrue(selectedMonth2.getText().equals("Mar"));

	}

}
