package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PrestaShop3FromMentoring { //Page object class
	WebDriver driver;
    public PrestaShop3FromMentoring(WebDriver driver){
        this.driver=driver;
    }
    //Username
    @FindBy(id="email")
    public WebElement username;

    //Password
    @FindBy(id="passwd")
    public WebElement password;

    //Login
    @FindBy(id="SubmitLogin")
    public WebElement loginButton;

    //Sign in
    @FindBy(linkText="Sign in")
    public WebElement signIn;


    //Hover over to the Cart icon
    @FindBy(xpath="//a[@title='View my shopping cart']")
    public WebElement hoverOver;

    //Verify emty message
    @FindBy(xpath="//p[.='Your shopping cart is empty.']")
    public WebElement getVerifyMessageForEmpty;

    //Delete from the Cart
    @FindBy(xpath="//a[@class='ajax_cart_block_remove_link']")
    public WebElement deleteFromCart;

    //Close Pup-up window after adding the product
    @FindBy(xpath="//span[@title='Close window']")
    public WebElement closePupupWindow;

    //Go back to home page
    @FindBy(xpath = "//*[@title='Return to Home']")
    public WebElement prestaShopHomePage;

    //Log out //a[@class='logout']
    @FindBy(xpath="//a[@class='logout']")
    public WebElement logout;

    //Continue shopping
    @FindBy(xpath="//span[@title='Continue shopping']")
    public WebElement continueShopping;

    //Proceed to checkout
    @FindBy(xpath="//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckout;


    //Auto Login
    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

        //Hover over to the add to card
    public WebElement hoverOver(String productName, String position){
        String xpath = "(//h5/a[@title='"+productName+"'])["+position+"]";
        return driver.findElement(By.xpath(xpath));
    }

    public void signIn(){

        signIn.click();
    }

    //Adding product to the card
    public WebElement addToCard(String orderNumber){
        String xpath = "//a[@data-id-product='"+orderNumber+"']";
        return driver.findElement(By.xpath(xpath));
    }

    //Check inside the cart if product  text is there
    public WebElement checkProductInTheCart(String prdName){
        String xpath = "//a[.='"+prdName+"']";
        return driver.findElement(By.xpath(xpath));
    }

    //Cart quantity delete
    public WebElement cartQuantityDelete(int putOrderNumber){
        String xpath = "(//a[@class='cart_quantity_delete'])["+putOrderNumber+"]";
        return driver.findElement(By.xpath(xpath));
    }

    //Your shopping cart contains:
    @FindBy(xpath="//span[@class='heading-counter']")
    public WebElement verifyMessageforProduct;

}

