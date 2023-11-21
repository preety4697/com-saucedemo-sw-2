package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
       // Enter the valid username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter the valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.id("login-button")).click();
        //Verify the text products
        String expectedText = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualText = actualTextElement.getText();
        ////Verify expected and actual text
        Assert.assertEquals("Products ",expectedText, actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        // Enter the valid username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter the valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(5000);

        //Verify that six products are displayed on page
        List<WebElement> productsDisplayed = driver.findElements(By.className("inventory_item"));
        int number = productsDisplayed.size();
        System.out.println("Number of products displayed in the page" + number);
        Thread.sleep(5000);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
