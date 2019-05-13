package AutomationPractice;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebOrder {
	WebDriver driver;
	Actions action;
	Random random;
	
	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");			
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
//	@Test
	public void Products() {
		login();
		List<String> allProductsList=new ArrayList<String>();
		List<String> purchasedProductsList=new ArrayList<String>();
		//2. Click on View all products link
		driver.findElement(By.xpath("//ul[@id='ctl00_menu']/li[2]/a")).click();
		List<WebElement> allProducts=driver.findElements(By.xpath("//*[@id='aspnetForm']/table/tbody/tr/td[2]/div[2]/table/tbody//tr/td[1]"));
		System.out.println("===========List of all products is as below===========");
		for(WebElement product:allProducts) {
			System.out.println(product.getText());
			//3. Remember all the product names from the table
			allProductsList.add(product.getText());
		}
		//4. Click on View all orders link
		driver.findElement(By.xpath("//ul[@id='ctl00_menu']/li[1]/a")).click();
		//5. Verify that all the values in the Products column match the names from step 4.
		List<WebElement> purchasedProducts=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody//tr/td[3]"));
		System.out.println("===========List of all purchased products is as below===========");
		for (WebElement purchasedProduct:purchasedProducts) {
			System.out.println(purchasedProduct.getText());
			purchasedProductsList.add(purchasedProduct.getText());
		}
		List<String> matchingList=new ArrayList<String>();
		for(String purchasedProduct:purchasedProductsList) {
			for(String product:allProductsList) {
				if(purchasedProduct.equals(product))
					matchingList.add(purchasedProduct);
			}
		}
		System.out.println("=========== Verification results are as follow ===========");
		System.out.println("Number of matching product is==== "+matchingList.size()+"\nNumber of purchased product is=== "+purchasedProductsList.size());
		Assert.assertTrue(matchingList.size()==purchasedProducts.size());
	}
	
//	@Test
	public void createOrder() throws InterruptedException {
		login();
		random=new Random();
		String[] allProducts= {"MyMoney","FamilyAlbum","ScreenSaver"};
		String productSent=allProducts[random.nextInt(allProducts.length-1)];
		String quantitySent="20";
		String nameSent="John Allen";
		String addressSent="123 Abc Str";
		String citySent="Luisville";
		String stateSent="Kentucky";
		String zipSent="12345";
		String cardTypeSent="MasterCard";
		String cardNumberSent="12345345668890961";
		String expirationDateSent="10/20";
		List<String> dataSentList=new ArrayList<String>();
		dataSentList.add(productSent);
		dataSentList.add(quantitySent);
		dataSentList.add(nameSent);
		dataSentList.add(addressSent);
		dataSentList.add(citySent);
		dataSentList.add(stateSent);
		dataSentList.add(zipSent);
		dataSentList.add(cardTypeSent);
		dataSentList.add(cardNumberSent);
		dataSentList.add(expirationDateSent);		
		driver.findElement(By.xpath("//*[@id='aspnetForm']/table/tbody/tr/td/ul/li[3]/a")).click();
		String productXpath="//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']//option[text()='"+productSent+"']";
		driver.findElement(By.xpath(productXpath)).click();
		Thread.sleep(3000);
		action=new Actions(driver);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).click();
		action.sendKeys(Keys.BACK_SPACE).sendKeys(quantitySent).build().perform();
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder']/tbody/tr/td/ol/li[5]/input[2]")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(nameSent);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(addressSent);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(citySent);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(stateSent);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipSent);
		String cardTypeXpath="//*[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr//td/label[text()='"+cardTypeSent+"']/preceding::input[1]";
		driver.findElement(By.xpath(cardTypeXpath)).click();
//		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumberSent);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expirationDateSent);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		driver.findElement(By.xpath("//*[@id='ctl00_menu']/li/a")).click();
		List<String> dataOrderDetailList=new ArrayList<String>();
		List<WebElement> orderDetails=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]//td"));
		System.out.println("================================= Order Detail =================================");
		boolean verifyOrder=false;
		for(WebElement orderDetail:orderDetails) {
			if(orderDetail.getText().length()>0) {
		System.out.println(orderDetail.getText());
		dataOrderDetailList.add(orderDetail.getText());
			}
		}
		for(String datasent:dataSentList) {
			verifyOrder=false;
			for(String order:dataOrderDetailList) {
				if(datasent.equals(order))
					verifyOrder=true;
		}
	}
		Assert.assertTrue(verifyOrder);
	}
	
//	@Test
	public void deleteOrder() {
	login();
	driver.findElement(By.xpath("//*[@id='ctl00_menu']/li/a")).click();
	List<WebElement> rowsCountBefore=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody//tr"));
	System.out.println("Rows count before deletion:===== "+rowsCountBefore.size());
	List<String> customerListBefore=new ArrayList<String>();
	List<WebElement> customerListElementBefore=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody//tr/td[2]"));
	for(WebElement customer:customerListElementBefore) {
		if(customer.getText().length()>0)
		customerListBefore.add(customer.getText());
	}
	System.out.println(customerListBefore);
	String deleteName="Steve Johns";
	driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody//tr//td[text()='"+deleteName+"']/preceding::td[1]")).click();
	driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
	
	driver.findElement(By.xpath("//*[@id='ctl00_menu']/li/a")).click();
	List<WebElement> rowsCountAfter=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody//tr"));
	System.out.println("Rows count after deletion:===== "+rowsCountAfter.size());
	List<String> customerListAfter=new ArrayList<String>();
	List<WebElement> customerListElementAfter=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody//tr/td[2]"));
	for(WebElement customer:customerListElementAfter) {
		if(customer.getText().length()>0)
			customerListAfter.add(customer.getText());
	}
	System.out.println(customerListAfter);
	Assert.assertTrue(customerListElementAfter.size()==customerListElementBefore.size()-1);
	customerListBefore.removeAll(customerListAfter);
	Assert.assertTrue(customerListBefore.get(0).equals(deleteName));
	}
	public void login() {
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}
	@Test
	public void  editOrder() throws InterruptedException {
	login();
	String editName="Charles Dodgeson";
	List<String> orderListBefore=new ArrayList<String>();
	List<WebElement> orderDetailBefore=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']//tr//td[text()='"+editName+"']/following-sibling::*"));
	System.out.println("======================= Order Detail Before Editing the Order is below==================================");
	for(WebElement elementsBefore:orderDetailBefore) {
		if(elementsBefore.getText().length()>0)
		orderListBefore.add(elementsBefore.getText());
		System.out.println(elementsBefore.getText());
	}
	driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody//tr//td[text()='"+editName+"']/following::td[11]")).click();
	String quantityUpdated="20";	
	action=new Actions(driver);
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).click();
	action.sendKeys(Keys.BACK_SPACE).sendKeys(quantityUpdated).build().perform();
	driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtTotal']/following::input[1]")).click();
	WebElement quantity=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
	Assert.assertTrue(quantity.isDisplayed());
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
	
	List<String> orderListAfter=new ArrayList<String>();
	List<WebElement> orderDetailAfter=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']//tr//td[text()='"+editName+"']/following-sibling::*"));
	System.out.println("======================= Order Detail After Editing the Order is below==================================");
	for(WebElement elementsAfter:orderDetailAfter) {
		if(elementsAfter.getText().length()>0)
		orderListAfter.add(elementsAfter.getText());
		System.out.println(elementsAfter.getText());
	}
	
	System.out.println("orderListAfter: "+orderListBefore);
	System.out.println("orderListAfter: "+orderListAfter);
	
	for(int i=0; i<orderListBefore.size();i++) {
		if(!orderListBefore.get(i).equals(orderListAfter.get(i))) {
			Assert.assertEquals(quantityUpdated,orderListAfter.get(i));
		}else {
			Assert.assertEquals(orderListBefore.get(i), orderListAfter.get(i));
		}
		
	}
	}
	
	@AfterMethod
	public void methodClose() throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();
	}
	
	@AfterClass
	public void classClose() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
