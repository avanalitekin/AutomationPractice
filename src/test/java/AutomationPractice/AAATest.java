package AutomationPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

//import com.prestashop.utilities.Driver;



public class AAATest {

	@FindBy(xpath = "//*[@id='quantity_wanted']")
	public static WebElement quantityDefault;
	
	public static int enterQuantity() {
		int  quantity=new Random().nextInt(3)+3;
		quantityDefault.clear();
		quantityDefault.sendKeys(String.valueOf(quantity));
		return quantity;
	}


	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		quantityDefault.clear();
		enterQuantity();
		
		
			}
	
}