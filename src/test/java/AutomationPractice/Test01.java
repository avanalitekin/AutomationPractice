package AutomationPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test01 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
//		Faker faker=new Faker();
//		String DOB=faker.date().birthday().toString();//Sat Oct 17 07:53:42 CDT 1959
//		System.out.println(DOB);
//		String dayDOB=DOB.substring(8, 10);
//		String monthDOB=DOB.substring(4, 7);
//		String yearDOB=DOB.substring(DOB.length()-4, DOB.length());
//		System.out.println(dayDOB);
//		System.out.println(monthDOB);
//		System.out.println(yearDOB);
//		String title=faker.name().title();
//		System.out.println(title);
//		String gender=faker.demographic().maritalStatus();
//		System.out.println(gender);
//		
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\Drivers\\chromedriver.exe");
////		 WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		WebDriver r=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		driver.get("https://www.google.com/");
//		r.get("http://www.kcfse.org");
//		driver.findElement(By.name("q")).sendKeys("Selenium.org");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);
////		driver.close();
////		r.close();
//		
	}
	@Test
	public void test() {
		driver.get("https://www.expedia.com/");
		List<WebElement> list=driver.findElements(By.xpath("//*[@class='clear-btn-input gcw-storeable text gcw-origin gcw-required gcw-distinct-locations ']"));
		for(WebElement e:list) {
			System.out.println(e.getText());
		}
	}

}
