package AutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IndexOlympics {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
	}
	@Test
	public void getIndex() {
		System.out.println(getIndexOfCountry("Italy"));
	}
	
	public String getIndexOfCountry(String countryName) {
        //Test Case 4: GET INDEX
        //1. Write a method that takes country name and returns the row and column
        //number. You decide the datatype of the return.
        driver.findElement(By.xpath("//th[.='NOC']")).click();
        //4. Now verify that the table is now sorted by the country names.
        List<WebElement> allNOC = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
        for (int i = 0; i < allNOC.size(); i++) {          
            if (allNOC.get(i).getText().contains(countryName)) {
                return 2 + "," + i;
            }
        }
        return "";
    }

}
