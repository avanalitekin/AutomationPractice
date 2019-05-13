package AutomationPractice;

import utilities.ConfigurationReader;
import utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrestaShop3FromMentoringTestClass {
	Actions actions;
	public String cartExpected;
	public String cartActual;
	WebDriver driver;
	PrestaShop3FromMentoring ref;

	@BeforeMethod
	public void beforeMethod() {
	String url = "http://automationpractice.com/index.php";
	driver = Driver.getDriver(url);
	ref = PageFactory.initElements(driver, PrestaShop3FromMentoring.class);
	}
	
	@AfterMethod
	public void afterMethod() {
	Driver.closeDriver();	
	}

//	@Test(priority = 0)
	public void CartLoginTest() throws InterruptedException {
		
// 3. Add any product in the PrestaShop3FromMentoring to the cart
		// 3. Add any product in the PrestaShop3FromMentoring to the cart
		actions=new Actions(driver);
		actions.moveToElement(ref.hoverOver("Blouse", "1")).perform();
		Thread.sleep(1000);
		ref.addToCard("2").click();
		Thread.sleep(3000);

		// Closing Pup-up winwof after adding the product
		actions.moveToElement(ref.closePupupWindow).click().build().perform();

		// 4. Hover over the cart icon
		actions.moveToElement(ref.hoverOver).perform();

		// 5. Verify that cart contains the product
		cartActual = ref.checkProductInTheCart("Blouse").getText();
		cartExpected = "Blouse";
		Assert.assertEquals(cartActual, cartExpected);

		// 6. Login as any valid user
		ref.signIn();
		// PrestaShop3FromMentoring.login("suayip.tekin@gmail.com", "yakubemir"); BEFORE
		// CONFIGURATION.PROPERTIES
		String username = ConfigurationReader.getProperty("username");
		String password = ConfigurationReader.getProperty("password");
		ref.login(username, password);

		// . Hover over the cart icon
		actions.moveToElement(ref.hoverOver).perform();

		// 8. Verify that cart information is same as step 5
		cartActual = ref.checkProductInTheCart("Blouse").getText();
		cartExpected = "Blouse";
		Assert.assertEquals(cartActual, cartExpected);

	}

//	@Test(priority = 1)
	public void cartLogout() throws InterruptedException {
		actions=new Actions(driver);
		
		ref.signIn();

		String username = ConfigurationReader.getProperty("username");
		String password = ConfigurationReader.getProperty("password");
		ref.login(username, password);

		// 4. Go back to home page
		Thread.sleep(3000);
		ref.prestaShopHomePage.click();
		Thread.sleep(3000);

		// 5. Add any product in the PrestaShop3FromMentoring to the cart
		actions.moveToElement(ref.hoverOver("Blouse", "1")).build().perform();
		Thread.sleep(1000);
		ref.addToCard("2").click();
		Thread.sleep(3000);

		// Closing Pup-up winwof after adding the product
		ref.closePupupWindow.click();

		// 6. Hover over the cart icon
		actions.moveToElement(ref.hoverOver).perform();

		// 7. Verify that cart contains the product
		cartActual = ref.checkProductInTheCart("Blouse").getText();
		cartExpected = "Blouse";
		Assert.assertEquals(cartActual, cartExpected);

		// 8.Logout
		ref.logout.click();

		// 9.Verify the cart contains the word empty
		cartExpected = "empty";
		cartActual = ref.hoverOver.getText();
		Assert.assertTrue(cartActual.contains(cartExpected));
	}

//	@Test(priority = 2)
	public void cartIconDeleteTest() throws InterruptedException {
		actions=new Actions(driver);
		// 3. Add any product in the PrestaShop3FromMentoring to the cart
		actions.moveToElement(ref.hoverOver("Printed Dress", "1")).perform();
		Thread.sleep(1000);
		ref.addToCard("3").click();
		Thread.sleep(3000);

		// 4. Click on Continue shopping
		ref.continueShopping.click();

		// 5. Hover over the cart icon
		actions.moveToElement(ref.hoverOver).perform();

		// 6. Click the x to delete the product
		ref.deleteFromCart.click();

		// 7. Verify word empty is displayed in the Cart icon
		ref.hoverOver.click();
		cartExpected = "empty";
		cartActual = ref.hoverOver.getText();
		Assert.assertTrue(cartActual.contains(cartExpected));

	}

	@Test(priority = 3)

	public void cartCheckouteleteTest() throws InterruptedException {

		actions=new Actions(driver);
		// 3. Add any product in the PrestaShop3FromMentoring to the cart
		actions.moveToElement(ref.hoverOver("Printed Dress", "1")).perform();
		Thread.sleep(1000);
		ref.addToCard("3").click();
		Thread.sleep(3000);

		// 4. Click on Continue shopping
		ref.continueShopping.click();

		// 5. Add another product in the PrestaShop3FromMentoring to the cart
		actions.moveToElement(ref.hoverOver("Printed Summer Dress", "1")).perform();
		Thread.sleep(1000);
		ref.addToCard("5").click();
		Thread.sleep(3000);

		// 6. Click on Proceed to checkout
		ref.proceedToCheckout.click();
		

		// 7. Verify message Your shopping cart contains: 2 Products

		cartExpected = "Your shopping cart contains: 2 Products";
		cartActual = ref.verifyMessageforProduct.getText();
		System.out.println(cartActual);
		Assert.assertEquals(cartActual, cartExpected);

		// 8. Click the delete icon to delete one of the products
		ref.cartQuantityDelete(1).click();

		// 9. Verify message Your shopping cart contains: 1 Product
		ref.hoverOver.click();
		cartExpected = "Your shopping cart contains: 1 Product";
		cartActual = ref.verifyMessageforProduct.getText();
		System.out.println(cartActual);
		Assert.assertEquals(cartActual, cartExpected);

		// 10. Click the delete icon to delete the second product
		ref.cartQuantityDelete(1).click();

		// 11. Verify message Your shopping cart is empty
		ref.hoverOver.click();
		cartExpected = "Your shopping cart is empty.";
		cartActual = ref.getVerifyMessageForEmpty.getText();
		System.out.println(cartActual);
		Assert.assertTrue(cartActual.contains(cartExpected));
	}
}
