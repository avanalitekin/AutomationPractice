package AutomationPractice;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test05{
	@Test
	public void testDropdown() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebElement monthDropdown=driver.findElement(By.id("month"));
		Select month=new  Select(monthDropdown);
		List<WebElement> monthList=month.getOptions();
		int totalNumberOfMonths=monthList.size();
		Assert.assertEquals(totalNumberOfMonths,13);
		System.out.println("total number of month in the dropdown: "+totalNumberOfMonths);
		for(WebElement mnth:monthList) {
			String monthName=mnth.getText();
			System.out.println("Months are ==="+monthName);
		}
	}
}