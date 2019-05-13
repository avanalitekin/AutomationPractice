package AutomationPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Olympics {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
		Thread.sleep(5000);
	}

	@Test (priority=1)
	public void sortTest() throws InterruptedException {
		Assert.assertTrue(rankInAscendingOrder());
		System.out.println();
		Assert.assertTrue(countriesInAscendingOrder());
		System.out.println();
		Assert.assertFalse(rankInAscendingOrder());
		System.out.println();
//		Assert.assertTrue(rankInAscendingOrder()); //This will fail if called after table is sorted  by countries.
	}

//	@Test (priority=2)
	public void theMost() {
		System.out.println();
		String theMostGoldIndex="2";
		String theMostSilverIndex="3";
		String theMostBronzeIndex="4";
		String theMostTotalMedalIndex="5";
		System.out.println("Country with the most GOLD medals: " + theMostMedal(theMostGoldIndex));
		System.out.println();
		System.out.println("Country with the most SILVER medals: " + theMostMedal(theMostSilverIndex));
		System.out.println();
		System.out.println("Country with the most BRONZE medals: " + theMostMedal(theMostBronzeIndex));
		System.out.println();
		System.out.println("Country with the most TOTAL medals: " + theMostMedal(theMostTotalMedalIndex));
		System.out.println();
	}

//	@Test (priority=3)
	public void countryByMedal() {
		System.out.println();
		countriesAndSilverMedals();
		System.out.println();

	}

//	@Test (priority=4)
	public void getIndex() {
		System.out.println();
		String countryName="South Korea";
		System.out.println("Index of  "+countryName+" is =========");
		findIdex(countryName);
		System.out.println();

	}

//	@Test (priority=5)
	public void getSum() {
		System.out.println();
		int totalBronzeMedals=48;
		System.out.println("Two countries that have a  totoal of ======== "+totalBronzeMedals+"======== Bronze Medals are");
		System.out.println(bronzeSum(totalBronzeMedals));
		System.out.println();

	}

	public boolean rankInAscendingOrder() {
		boolean rankingTest = true;
		List<WebElement> rankings = driver.findElements(
				By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody//tr/th/a/parent::*/preceding-sibling::*"));
		System.out.println("====== Ranking order====== ");
		for (int i = 0; i < rankings.size(); i++) {
			System.out.print(rankings.get(i).getText() + " ");
			if (i < rankings.size() - 1
					&& Integer.parseInt(rankings.get(i).getText()) >= Integer.parseInt(rankings.get(i + 1).getText()))
				rankingTest = false;
		}
		return rankingTest;
	}

	public boolean countriesInAscendingOrder() throws InterruptedException {
		Thread.sleep(5000);
		List<String> countriesList = new ArrayList<String>();
		driver.findElement(By.xpath("//*[@id='mw-content-text']/div/table[8]//tr/th[2]")).click();
		List<WebElement> countriesWebelement = driver
				.findElements(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody//tr/th/a"));
		for (WebElement country : countriesWebelement) {
//			System.out.println(country.getText());
			countriesList.add(country.getText());
		}
		boolean countiesInAscendingOrder = true;
		for (int i = 0; i < countriesList.size() - 1; i++) {
			if (countriesList.get(i).compareToIgnoreCase(countriesList.get(i + 1)) >= 0)
				countiesInAscendingOrder = false;
//	System.out.println("compare country order: "+countriesList.get(i).compareToIgnoreCase(countriesList.get(i+1)));
		}
//	System.out.println(countiesInAscendingOrder);
		return countiesInAscendingOrder;
	}

	public String theMostMedal(String index) {
		List<Integer> goldMedalNumbers=new ArrayList<Integer>();
		List<WebElement> goldMedalsWebelement1 = driver.findElements(By.xpath(
				"//div[@id='mw-content-text']/div/table[8]//tr//td/a/parent::*/parent::*/preceding-sibling::*/td["+index+"]"));
		List<WebElement> goldMedalsWebelement2 = driver.findElements(By.xpath(
				"//div[@id='mw-content-text']/div/table[8]//tr//td/a/parent::*/parent::*/following-sibling::*/td["+index+"]"));
		for(int i=0; i<goldMedalsWebelement1.size()+goldMedalsWebelement2.size();i++) {
			if(goldMedalsWebelement1.size()!=0 && i<goldMedalsWebelement1.size()) {
				goldMedalNumbers.add(Integer.parseInt(goldMedalsWebelement1.get(i).getText()));
			}else{
				if(goldMedalsWebelement2.size()!=0) {
				goldMedalNumbers.add(Integer.parseInt(goldMedalsWebelement2.get(i-goldMedalsWebelement1.size()).getText()));
				}
				}
			
		}
		int maximumGold = 0;
		int webelementIndex = 0;
		for (int i = 0; i < goldMedalNumbers.size(); i++) {
			
				System.out.print(goldMedalNumbers.get(i) + " ");
			
				if (goldMedalNumbers.get(i)> maximumGold) {
				
					maximumGold = goldMedalNumbers.get(i);
				
				webelementIndex = i+2;
				}
			}
		System.out.println("\nindex: " + webelementIndex);
		return driver
				.findElement(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody/tr[" + webelementIndex + "]/th/a"))
				.getText();
	}

	public void countriesAndSilverMedals() {
		String format = "%-15s%s%n";
		List<WebElement> countriesWebelement = driver
				.findElements(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody//tr/th/a"));
		List<WebElement> silverMedalsWebelement1 = driver.findElements(By.xpath(
				"//*[@id='mw-content-text']/div/table[8]/tbody//tr/td[2]/a/parent::*/parent::*/preceding-sibling::*/td[3]"));
		List<WebElement> silverMedalsWebelement2 = driver.findElements(By.xpath(
				"//*[@id='mw-content-text']/div/table[8]/tbody//tr/td[2]/a/parent::*/parent::*/following-sibling::*/td[3]"));
		System.out.println("========== COUNTRY LIST WITH SILVER MEDALS IS AS BELOW ==========");
		System.out.printf(format, "Country Name", "Number of Silver Medals");
		int i;
		for (i = 0; i < silverMedalsWebelement1.size() && silverMedalsWebelement1.size()!=0; i++) {
			System.out.printf(format, countriesWebelement.get(i).getText(), silverMedalsWebelement1.get(i).getText());
		}
		
		for (; i < silverMedalsWebelement1.size()+silverMedalsWebelement2.size() && silverMedalsWebelement2.size()!=0; i++) {
			System.out.printf(format, countriesWebelement.get(i).getText(), silverMedalsWebelement2.get(i-silverMedalsWebelement1.size()).getText());
		}

	}

	public void findIdex(String s) {//column index is not fixed yet.
		int rowIndex = -1;
		List<WebElement> countriesWebelement = driver
				.findElements(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody//tr/th/a"));
		for (int i = 1; i <= countriesWebelement.size(); i++) {
			try{
				WebElement countryWebelement = driver
			
					.findElement(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody/tr[" + i + "]/th/a"));
			if (countryWebelement.getText().equals(s)) {
				rowIndex = i;
			}
			}catch (NoSuchElementException nse) {
				continue;
			}
			
		}
		List<WebElement> rows = driver
				.findElements(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody//tr"));
		List<String> rowsString=new ArrayList<String>();
		for(WebElement element:rows) {
			rowsString.add(element.getText());
			System.out.println(element.getText());
		}
		System.out.println("Row index for " + s + " :" + rowIndex + "\nColumn index for " + s + " :" );
	}

	public List<String> bronzeSum(int total) {
		List<WebElement> bronzeMedalsWebelement1 = driver.findElements(By.xpath(
				"//*[@id='mw-content-text']/div/table[8]/tbody//tr/td[2]/a/parent::*/parent::*/preceding-sibling::*/td[4]"));
		List<WebElement> bronzeMedalsWebelement2 = driver.findElements(By.xpath(
				"//*[@id='mw-content-text']/div/table[8]/tbody//tr/td[2]/a/parent::*/parent::*/following-sibling::*/td[4]"));
		List<Integer> bronzeMedalCounts = new ArrayList<Integer>();
		for(int i=0; i<bronzeMedalsWebelement1.size()+bronzeMedalsWebelement2.size();i++) {
			if(bronzeMedalsWebelement1.size()!=0 && i<bronzeMedalsWebelement1.size()) {
				bronzeMedalCounts.add(Integer.parseInt(bronzeMedalsWebelement1.get(i).getText()));
			}else{
				if(bronzeMedalsWebelement2.size()!=0) {
					bronzeMedalCounts.add(Integer.parseInt(bronzeMedalsWebelement2.get(i-bronzeMedalsWebelement1.size()).getText()));
				}
				}
		}

		List<WebElement> countriesWebelement = driver
				.findElements(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody//tr/th/a"));
		List<String> countriesList = new ArrayList<String>();
		for (WebElement element : countriesWebelement) {
			countriesList.add(element.getText());
		}
//		System.out.println(countriesList);
		List<String> countriesSumList = new ArrayList<String>();
		for (int i = 0; i < bronzeMedalCounts.size() - 1; i++) {
			for (int j = i + 1; j < bronzeMedalCounts.size(); j++) {
				if ((bronzeMedalCounts.get(i) + bronzeMedalCounts.get(j)) == total) {
					countriesSumList.add(countriesList.get(i));
					countriesSumList.add(countriesList.get(j));
				}
			}
		}
		return countriesSumList;
	}

	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
