package AutomationPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectDropdownOptions {
	WebDriver driver;
	Select list;
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercuryreservation.php?osCsid=079b94fc69871a6d1977bee85b89a8b5");
	}
	@Test
	public void test() {
	WebElement dropDown=driver.findElement(By.xpath("//select[@name='fromPort']"));
	list=new Select(dropDown);
	List<String> dropdownMenuList=new ArrayList<String>();
	List<WebElement> listOfOptions=list.getOptions();
	String firstOption=list.getFirstSelectedOption().getText();
	for(WebElement option:listOfOptions) {
		System.out.println(option.getText());
		dropdownMenuList.add(option.getText());
		
	}
	System.out.println(dropdownMenuList);
	System.out.println("\n====================================");
	System.out.println("First selected option: "+firstOption);
	System.out.println("\n====================================");
	}
	
	@Test
	public void test2() {
		List<WebElement> allOptionsElement=driver.findElements(By.xpath("//select[@name='fromPort']/child::*"));
		for(WebElement option:allOptionsElement)
			System.out.println(option.getText());
	}

}
