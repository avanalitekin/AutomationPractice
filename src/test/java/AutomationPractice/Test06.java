package AutomationPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test06 {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("menu1")).click();
		List<WebElement> dropDownList = driver.findElements(By.xpath("//ul[class='dropdown-menu']//li/a "));
		for (int i = 0; i < dropDownList.size(); i++) {
			WebElement element = dropDownList.get(i);
			String innerHtml = element.getAttribute("innerHTML");
			if (innerHtml.contentEquals("JavaScript")) {
				element.click();
				break;
			}
			System.out.println("values from drowdown is== " + innerHtml);
		}
		driver.quit();
	}

}
