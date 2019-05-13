package AutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Porsche {
	WebDriver driver;
	JavascriptExecutor je;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.porsche.com/usa/modelstart/");
		Thread.sleep(5000);
	}
	@Test
	public  void test() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='b-page-wrapper page nonavi']/div[4]/div/div[2]/a[1]/div/div[1]/img")).click();
		Thread.sleep(3000);
		String fromPriceCaymanS=driver.findElement(By.xpath("//div[@id='model-result-row']/div[3]/div[2]/div/div[2]/div[2]")).getText();
		String priceCaymanS=fromPriceCaymanS.substring(fromPriceCaymanS.indexOf('$'),fromPriceCaymanS.indexOf('.')).replace(" ","");
		System.out.println(priceCaymanS);
		driver.findElement(By.xpath("//div[@id='model-result-row']/div[3]/div[2]/div/div[1]/img")).click();
		Thread.sleep(5000);
		for(String windowHandle:driver.getWindowHandles()) {
			System.out.println(windowHandle);
			driver.switchTo().window(windowHandle);
			driver.manage().window().maximize();
		}
		List<WebElement> webElementPrices=driver.findElements(By.xpath("//section[@id='s_price']/div//div/div[2]"));
		for(WebElement element:webElementPrices) {
			System.out.println(element.getText());
		}
		System.out.println();
		String basePriceCaymanS=webElementPrices.get(0).getText();
//		System.out.println(basePriceCaymanS);
		Assert.assertTrue(priceCaymanS.equals(basePriceCaymanS));
		String priceForEquipment=webElementPrices.get(1).getText();
		Assert.assertTrue(priceForEquipment.equals("$0"));
		String deliveryProcessingHanglingFee=webElementPrices.get(2).getText();
		String totalPrice=webElementPrices.get(3).getText();
		int basePriceCaymanSInt, priceForEquipmentInt, deliveryProcessingHanglingFeeInt, totalPriceInt;
//		String basePriceCaymanSRefined=basePriceCaymanS.replace("$","").replace(",","");
//		System.out.println("basePriceCaymanSRefined: "+basePriceCaymanSRefined);
		basePriceCaymanSInt=priceToInteger(basePriceCaymanS);
		priceForEquipmentInt=priceToInteger(priceForEquipment);
		deliveryProcessingHanglingFeeInt=priceToInteger(deliveryProcessingHanglingFee);
		totalPriceInt=priceToInteger(totalPrice);
		Assert.assertTrue(totalPriceInt==(basePriceCaymanSInt+priceForEquipmentInt+deliveryProcessingHanglingFeeInt));
		
		driver.findElement(By.xpath("//*[@id='s_exterieur_x_FJ5']/span")).click();
		List<WebElement> webElementMiamiBluePrices=driver.findElements(By.xpath("//section[@id='s_price']/div//div/div[2]"));
		for(WebElement element:webElementMiamiBluePrices) {
			System.out.println(element.getText());
		}
		String basePriceCaymanSMiamiBlue, priceForEquipmentMiamiBlue, deliveryProcessingHanglingFeeMiamiBlue, totalPriceMiamiBlue;
		basePriceCaymanSMiamiBlue=webElementMiamiBluePrices.get(0).getText();
		priceForEquipmentMiamiBlue=webElementMiamiBluePrices.get(1).getText();
		deliveryProcessingHanglingFeeMiamiBlue=webElementMiamiBluePrices.get(2).getText();
		totalPriceMiamiBlue=webElementMiamiBluePrices.get(3).getText();
		int basePriceCaymanSMiamiBlueInt, priceForEquipmentMiamiBlueInt, deliveryProcessingHanglingFeeMiamiBlueInt, totalPriceMiamiBlueInt;
		basePriceCaymanSMiamiBlueInt=priceToInteger(basePriceCaymanSMiamiBlue);
		priceForEquipmentMiamiBlueInt=priceToInteger(priceForEquipmentMiamiBlue);
		deliveryProcessingHanglingFeeMiamiBlueInt=priceToInteger(deliveryProcessingHanglingFeeMiamiBlue);
		totalPriceMiamiBlueInt=priceToInteger(totalPriceMiamiBlue);
		
		String miamiBluePrice=driver.findElement(By.xpath("//div[@id='s_exterieur_x_IAF']/div[2]/div/div/div[2]")).getText();
		Assert.assertTrue(miamiBluePrice.equals(priceForEquipmentMiamiBlue));
		
		Assert.assertTrue(totalPriceMiamiBlueInt==(basePriceCaymanSMiamiBlueInt+priceForEquipmentMiamiBlueInt+deliveryProcessingHanglingFeeMiamiBlueInt));
		
		Thread.sleep(3000);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("scroll(0,250)");
		
		driver.findElement(By.xpath("//div[@id='ARA']/ul/li[6]/span/span")).click();
		String carreraSportsWheelPrice=driver.findElement(By.xpath("//div[@id='s_exterieur_x_IRA']/div[2]/div/div/div[2]")).getText();
		String priceForEquipmentMiamiBlueCarSpWhl=driver.findElement(By.xpath("//section[@id='s_price']/div/div[2]/div[2]")).getText();
		int priceForEquipmentMiamiBlueCarSpWhlInt=priceToInteger(priceForEquipmentMiamiBlueCarSpWhl);
		int carreraSportsWheelPriceInt=priceToInteger(carreraSportsWheelPrice);
		int miamiBluePriceInt=priceToInteger(miamiBluePrice);
		Assert.assertTrue(priceForEquipmentMiamiBlueCarSpWhlInt==(carreraSportsWheelPriceInt+miamiBluePriceInt));
		
		//15
		((JavascriptExecutor)driver).executeScript("scroll(0,1500)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='seats_73']/div[2]/span")).click();
		//16
		String powerSportSeat14Price=driver.findElement(By.xpath("//div[@id='seats_73']/div[2]/div/div[3]")).getText();
		int powerSportSeat14PriceInt=priceToInteger(powerSportSeat14Price);
		
		String priceForEquipmentMiamiBlueCarSpWhlSeat=driver.findElement(By.xpath("//section[@id='s_price']/div/div[2]/div[2]")).getText();
		int priceForEquipmentMiamiBlueCarSpWhlSeatInt=priceToInteger(priceForEquipmentMiamiBlueCarSpWhlSeat);
		System.out.println("priceForEquipmentMiamiBlueCarSpWhlSeatInt: "+priceForEquipmentMiamiBlueCarSpWhlSeatInt);
		System.out.println("powerSportSeat14PriceInt: "+powerSportSeat14PriceInt);
		System.out.println("carreraSportsWheelPriceInt: "+carreraSportsWheelPriceInt);
		System.out.println("miamiBluePriceInt: "+miamiBluePriceInt);
			
		Assert.assertTrue(priceForEquipmentMiamiBlueCarSpWhlSeatInt==(powerSportSeat14PriceInt+carreraSportsWheelPriceInt+miamiBluePriceInt));
		
		//17
		List<WebElement> webElementPricesWithItems=driver.findElements(By.xpath("//section[@id='s_price']/div//div/div[2]"));
		System.out.println("totalPrice(webElementPricesWithItems): "+totalPrice(webElementPricesWithItems));
		String totalPrice2=webElementPricesWithItems.get(3).getText();
		int totalPrice2Int=priceToInteger(totalPrice2);
		Assert.assertTrue(totalPrice2Int==totalPrice(webElementPricesWithItems));
		
		//18.Click on Interior Carbon Fiber
		((JavascriptExecutor)driver).executeScript("scroll(0,2500)");
		Thread.sleep(3000);
		driver.findElement(By.id("IIC_subHdl")).click();
		//19.Select Interior Trim in Carbon Fiber i.c.w. Standard Interior
		driver.findElement(By.xpath("//div[@id='vs_table_IIC_x_PEKH']/span")).click();
		
		String priceIntrTrimCarbnFbr=driver.findElement(By.xpath("//div[@id='vs_table_IIC_x_PEKH']/div/div[2]/div")).getText();
		int priceIntrTrimCarbnFbrInt=priceToInteger(priceIntrTrimCarbnFbr);
		String priceForEquiment19=driver.findElement(By.xpath("//section[@id='s_price']/div/div[2]/div[2]")).getText();
		int priceForEquiment19Int=priceToInteger(priceForEquiment19);
		int priceForItems19=priceForEquipmentMiamiBlueCarSpWhlSeatInt+priceIntrTrimCarbnFbrInt;
		//20 Verify that Price for Equipment is the sum of Miami Blue price + 20" Carrera Sport Wheels
		Assert.assertTrue(priceForEquiment19Int==priceForItems19);
		
		//21.Verify that total price is the sum of base price + Price for Equipment + Delivery, Processing and Handling Fee
		List<WebElement> webElementPrices21=driver.findElements(By.xpath("//section[@id='s_price']/div//div/div[2]"));
		System.out.println("totalPrice(webElementPrices21): "+totalPrice(webElementPrices21));
		String totalPrice21=webElementPrices21.get(3).getText();
		int totalPrice21Int=priceToInteger(totalPrice21);
		Assert.assertTrue(totalPrice21Int==totalPrice(webElementPrices21));
		
		//22 Click on Performance
		((JavascriptExecutor)driver).executeScript("scroll(0,2100)");
		driver.findElement(By.id("IMG_subHdl")).click();
		Thread.sleep(3000);
		//23.Select 7-speed Porsche Doppelkupplung (PDK)
		driver.findElement(By.id("vs_table_IMG_x_M250_x_c11_M250")).click();
		String priceDoppKup=driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250']/div/div[2]")).getText();
		//24.Select Porsche Ceramic Composite Brakes (PCCB)
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("scroll(0,2700)");
		driver.findElement(By.id("vs_table_IMG_x_M450_x_c81_M450")).click();
		String priceCeramicCB=driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M450']/div/div[2]/div")).getText();
		
		/*25.Verify that Price for Equipment is the sum of Miami Blue price + 20" Carrera Sport Wheels
		+ Power Sport Seats (14-way) with Memory Package + Interior Trim in Carbon Fiber i.c.w.
		Standard Interior + 7-speed Porsche Doppelkupplung (PDK) + Porsche Ceramic Composite
		Brakes (PCCB)*/
		int priceDoppKupInt=priceToInteger(priceDoppKup);
		int priceCeramicCBInt=priceToInteger(priceCeramicCB);
		
		String priceForEquiment25=driver.findElement(By.xpath("//section[@id='s_price']/div/div[2]/div[2]")).getText();
		int priceForEquiment25Int=priceToInteger(priceForEquiment25);
		int priceForItems25=priceForItems19+priceDoppKupInt+priceCeramicCBInt;
		Assert.assertTrue(priceForEquiment25Int==priceForItems25);
		//26
		List<WebElement> webElementPrices26=driver.findElements(By.xpath("//section[@id='s_price']/div//div/div[2]"));
		System.out.println("totalPrice(webElementPrices21): "+totalPrice(webElementPrices26));
		String totalPrice26=webElementPrices26.get(3).getText();
		int totalPrice26Int=priceToInteger(totalPrice26);
		Assert.assertTrue(totalPrice26Int==totalPrice(webElementPrices26));
		
		
		
	}
	public int totalPrice(List<WebElement> elements) {
		for(WebElement element:elements) {
			System.out.println(element.getText());
		}
		System.out.println();
		String basePrice=elements.get(0).getText();
		String priceForEquipment=elements.get(1).getText();
		String deliveryProcessingHanglingFee=elements.get(2).getText();
		int basePriceInt, priceForEquipmentInt, deliveryProcessingHanglingFeeInt;
//		String basePriceCaymanSRefined=basePriceCaymanS.replace("$","").replace(",","");
//		System.out.println("basePriceCaymanSRefined: "+basePriceCaymanSRefined);
		basePriceInt=priceToInteger(basePrice);
		priceForEquipmentInt=priceToInteger(priceForEquipment);
		deliveryProcessingHanglingFeeInt=priceToInteger(deliveryProcessingHanglingFee);
		
		
		return (basePriceInt+priceForEquipmentInt+deliveryProcessingHanglingFeeInt);
		 
	}
	
	public int priceToInteger(String s) {
		return Integer.parseInt(s.replace("$","").replace(",",""));
		
		
	}
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
