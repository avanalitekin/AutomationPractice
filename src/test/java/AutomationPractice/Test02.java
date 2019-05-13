package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Abc");
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("Xyz");
		WebElement mobilePhone = driver.findElement(By.id("u_0_h"));
		mobilePhone.sendKeys("123456790");
		WebElement passWord = driver.findElement(By.id("u_0_o"));
		passWord.sendKeys("abc123Xyz");
		WebElement maleBox = driver.findElement(By.id("u_0_a"));
		maleBox.click();
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("4");
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue("15");
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1972");
		WebElement createAPage=driver.findElement(By.linkText("Create a Page"));
		Thread.sleep(5000);
		createAPage.click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.close();

	}

}
