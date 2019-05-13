package AutomationPractice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class WebOrderCevat {
	WebDriver driver;
	Actions action;
	Faker faker=new Faker();
@Test
public void createOrder(){
    login();
    driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
    Select select = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
    Random random = new Random();
    int startOption = 1;
    int endOption = select.getOptions().size();
    Integer number = startOption + random.nextInt(endOption - startOption);
    select.selectByIndex(number);

    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]")).sendKeys(Integer.toString(faker.number().numberBetween(1,30)));

    int min = 112;
    int max = 400;
    int betweenTwoNum = new Random().nextInt((max - min) + 1) + min;
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtDiscount\"]")).sendKeys(Integer.toString(random.nextInt(25)));
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtTotal\"]")).sendKeys(Integer.toString(random.nextInt(150)));
    //driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/ol[1]/li[5]/input[2]")).click();
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys(faker.name().fullName());
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).sendKeys(faker.address().streetAddress());
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")).sendKeys(faker.address().city());
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")).sendKeys(faker.address().state());
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]")).sendKeys(Integer.toString(betweenTwoNum));
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/ol[3]/li["+ Integer.toString(faker.number().numberBetween(1,3))+"]")).click();
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")).sendKeys(Integer.toString(random.nextInt(987998084)));


    String pattern = "mm/yy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys(date);
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();

    driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[1]/a")).click();

}
public void login() {
	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	driver.findElement(By.id("ctl00_MainContent_login_button")).click();
}
}