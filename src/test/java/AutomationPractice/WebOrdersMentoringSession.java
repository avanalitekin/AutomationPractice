package AutomationPractice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WebOrdersMentoringSession {
	WebDriver driver;
	Select list;
	Random random=new Random();
	Faker faker=new Faker();

	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
    //since we have this step in every test case, we can write separate method for it and then just call it
    public void login(){
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$password']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$login_button']")).click();
    }

    @Test
    public void testProducts(){

        //1.  1.Login to Web Orders application using “Tester”and “test”
        login();

        //2.Click on View all products link
        driver.findElement(By.xpath("//*[.='View all products']")).click();

        //3 Remember all the product names from the table
        //lets create arrayList of WebElements which contains needed information about ProductNames
        List<WebElement> productNames = driver.findElements(By.xpath("//table[@class='ProductsTable']/tbody/tr/td[1]"));

        List<String> productNamesViewAll;
        productNamesViewAll = new ArrayList<String>();

        for(WebElement productNameViewAll : productNames){
            System.out.println(productNamesViewAll.add(productNameViewAll.getText()));
        }

        //4 Click on View all orders link
        driver.findElement(By.xpath("//*[.='View all orders']")).click();

        //5 Verify that all the values in the Products column match the names from step 4.
        List<WebElement> allProductNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[3]"));

        for(WebElement allNames: allProductNames){
            System.out.println(allNames);
            Assert.assertTrue(productNamesViewAll.contains(allNames.getText()));
        }



//        boolean found = false;
//        for (int i = 0; i < allProductNames.size(); i++){
//            if(allProductNames.get(i).getText().equals("MyMoney")){
//                found = true;
//                System.out.println("PASS");
//                break;
//            }
//        }
//        found = false;
//        for (int i = 0; i < allProductNames.size(); i++){
//            if(allProductNames.get(i).getText().equals("FamilyAlbum")){
//                found = true;
//                System.out.println("PASS");
//                break;
//            }
//        }
//        found = false;
//        for (int i = 0; i < allProductNames.size(); i++){
//            if(allProductNames.get(i).getText().equals("ScreenSaver")){
//                found = true;
//                System.out.println("PASS");
//                break;
//            }
//        }
//        System.out.println("All products are found");
    }

    @Test
    public void createOrder() throws InterruptedException{
        //1 VerifyLogin to Web Ordersapplication using “Tester”and “test””
        login();

        driver.findElement(By.xpath("//*[.='View all orders']"));
        List<WebElement> previuosOrderInfo = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr[2]"));

        for(WebElement previousOrder: previuosOrderInfo){
            System.out.println(previousOrder.getText());
        }

        //2 Click on Orderlink
        driver.findElement(By.xpath("//*[.='Order']")).click();

        //3 Select a product (Select different product every time) -> write method for different Product
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$fmwOrder$ddlProduct']")).click();

        //4 Enter data to all the required fields(Enter different data every time)

        WebElement productOptions = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        list = new Select(productOptions);
        List<WebElement> options = list.getOptions();
        int optionsIndex = random.nextInt(options.size() + 1);
        list.selectByIndex(optionsIndex);

        driver.findElement(By.xpath("//*[@value='MyMoney']")).click();
        int quantity = random.nextInt(99);

        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys(quantity + "");
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(faker.name().fullName().toString());
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$fmwOrder$TextBox2']")).sendKeys(faker.address().streetName().toString());
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$fmwOrder$TextBox3']")).sendKeys(faker.address().city().toString());
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$fmwOrder$TextBox4']")).sendKeys(faker.address().state().toString());
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$fmwOrder$TextBox5']")).sendKeys(faker.address().zipCode().toString().replace("-",""));

        int index = random.nextInt(3) + 1;
        WebElement radioForCardType = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_cardList_"+index+"']"));

        if(!(radioForCardType.isSelected())){
            radioForCardType.click();
        }
        System.out.println(radioForCardType.isSelected());

        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$fmwOrder$TextBox6']")).sendKeys(faker.finance().creditCard().replace("-", "").toString());

        int month = random.nextInt(12);
        int year = random.nextInt(25);

        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys(((month<10) ? "0" + month : month) +"/" +((year < 10) ? "0" + year : year));
        Thread.sleep(5000);

        //5 Click Proceed
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
        //6 Click on link View all orders
        driver.findElement(By.xpath("//*[.='View all orders']")).click();
        //7 Verify that all the order details are correct

        List<WebElement> actualOrderInfo = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr[2]"));

        for(WebElement actualOrder: actualOrderInfo){
            System.out.println(actualOrder.getText());
        }

        //verify if info matches
    }

    @Test
    public void delete() throws InterruptedException {
            //1 VerifyLogin to Web Ordersapplication using “Tester”and “test”
            login();
            //2 Delete a random entry from the table
            driver.findElement(By.xpath("//*[.='View all orders']"));

            List<WebElement> allRowsBefore = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
            for (WebElement allRow : allRowsBefore) {
                System.out.println(allRow.getText());
            }
            int rowsBefore = allRowsBefore.size();
            System.out.println("Total rows before delete: " + allRowsBefore.size());

            //3 Verify that table row count decreased by 1
            int index = random.nextInt(rowsBefore);
            String nameToDelete = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid_ctl0" + index + "_OrderSelector']")).getText();
            System.out.println(nameToDelete);

            WebElement toDelete = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid_ctl0" + index + "_OrderSelector']"));
            toDelete.click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@name='ctl00$MainContent$btnDelete']")).click();

            List<WebElement> allRowsAfter = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
            for (WebElement allRow : allRowsAfter) {
                System.out.println(allRow.getText());
            }
            int rowsAfter = allRowsAfter.size();
            System.out.println(allRowsAfter.size());

            int decreased = rowsBefore - rowsAfter;
            Assert.assertTrue(decreased == 1);

            //5 Verify Name column does not contain deleted person’sname
            for (WebElement rowsToCheck : allRowsAfter) {
                Assert.assertTrue(!(nameToDelete.equals(rowsToCheck)));
            }
        }


    @Test
    public void edit() throws InterruptedException{
        //1
        login();

        //check how many edit bottuns we have
        List<WebElement> allRowsBefore = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
        for (WebElement allRow : allRowsBefore) {
            System.out.println(allRow.getText());
        }
        int columnsIndex = random.nextInt(allRowsBefore.size()+2);
        System.out.println(columnsIndex);
        //2 Click edit button for any entry
        WebElement editButton = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr["+columnsIndex+"]/td[13]"));
        editButton.click();

        Thread.sleep(5000);
        int quantityNew = random.nextInt(99);
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys(quantityNew + "");

        //4 Click Calculate
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //5 Verify that new quantity is displayed

        WebElement quantityAdded = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        Assert.assertTrue(quantityAdded.isDisplayed());

        // 6.Click Update
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class='btn_light']")).click();

        List<WebElement> rawsBefore = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

        List<String> rawInfoBefore;
        rawInfoBefore = new ArrayList<String>();

        for(WebElement rawBefore : rawsBefore){
            System.out.println(rawInfoBefore.add(rawBefore.getText()));
        }

        //8 Verify that other information in that row did not change
        Thread.sleep(5000);
        driver.navigate().back();

        WebElement quantityAdded2 = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        System.out.println(quantityAdded2);
        Assert.assertTrue(quantityAdded2.isDisplayed());

        //take name to find row system changed
        WebElement rowChanged = driver.findElement(By.xpath("//*[@name='ctl00$MainContent$fmwOrder$txtName']"));
        String nameFromRow = rowChanged.getAttribute("value");
        Thread.sleep(5000);

        //8
        driver.findElement(By.xpath("//*[@class='btn_light']")).click();
        Thread.sleep(5000);

        List<WebElement> rawInfoAfter = driver.findElements(By.xpath("//td[.='"+nameFromRow+"']"));
        for (WebElement rawInfo: rawInfoAfter){
            System.out.println(rawInfo);
            Assert.assertTrue(rawInfoBefore.contains(rawInfo.getText()));
        }
    }

}