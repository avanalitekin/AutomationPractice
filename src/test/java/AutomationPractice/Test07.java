package AutomationPractice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test07 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
	}

	@Test
	public void test1() {

		List<WebElement> radio = driver.findElements(By.xpath("//input[@name='lang'  and @type='radio']"));
		for (int i = 0; i < radio.size(); i++) {
			WebElement localRadio = radio.get(i);
			String value = localRadio.getAttribute("value");
			System.out.println("Values from radio buttons are: " + value);
			if (value.equalsIgnoreCase("RUBY")) {
				localRadio.click();
				break;
			}
		}
	}

	@Test
	public void test2() {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < checkBoxes.size(); i++) {
			WebElement checkBox = checkBoxes.get(i);
			String id = checkBox.getAttribute("id");
			System.out.println("checkboxes: " + id);
			if (id.equalsIgnoreCase("sing")) {
				checkBox.click();
				break;
			}
		}
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}