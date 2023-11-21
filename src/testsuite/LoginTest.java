package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValidCredentials
 *      Enter “tomsmith” username
 *      Enter “SuperSecretPassword!” password
 *      Click on ‘LOGIN’ button
 *      Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 *      Enter “tomsmith1” username
 *      Enter “SuperSecretPassword!” password
 *      Click on ‘LOGIN’ button
 *      Verify the error message “Your username is invalid!”
 * 3. verifyThePasswordErrorMessage
 *      Enter “tomsmith” username
 *      Enter “SuperSecretPassword” password
 *      Click on ‘LOGIN’ button
 *      Verify the error message “Your password is invalid!”
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    // Declare baseUrl
    String baseUrl = "http://the-internet.herokuapp.com/login";

    // Open Browser
    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter UserName
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        // Enter Password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        // Verify the "Secure Area"
        // expected result
         String expectedText = "You logged into a secure area!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash success']"));
        String actualText = actualTextElement.getText().substring(0,30);
        // verify expected and actual
        Assert.assertEquals(expectedText,actualText);
       // System.out.println(actualText);

    }



    @Test
    public void verifyTheUsernameErrorMessage() {
        // Enter UserName
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
        // Enter Password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        // Verify the "Your username is invalid!"
        // expected result
        String expectedText = "Your username is invalid!";

        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'invalid!')]"));
        String actualText = actualTextElement.getText().substring(0,25);
        // verify expected and actual
       Assert.assertEquals(expectedText,actualText);
        //System.out.println(actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Enter UserName
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        // Enter Password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword");
        // Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        // Verify the "Your password is invalid!"
        // expected result
        String expectedText = "Your password is invalid!";

        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'invalid!')]"));
        String actualText = actualTextElement.getText().substring(0,25);
        // verify expected and actual
        Assert.assertEquals(expectedText,actualText);
       // System.out.println(actualText);

    }
    @After
    public void tearDown(){

         closeBrowser();
    }
}
