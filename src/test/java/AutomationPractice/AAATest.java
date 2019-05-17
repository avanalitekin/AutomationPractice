package AutomationPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

//import com.prestashop.utilities.Driver;



public class AAATest {

	


	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://kcfse.org/");
		String parentWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//*[contains(text(),'ACT')]")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		for(String window:windowHandles) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				
			}
		}
		
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
		

		
			}
	
}