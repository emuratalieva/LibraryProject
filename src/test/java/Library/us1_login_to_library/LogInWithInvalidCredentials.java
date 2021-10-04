package Library.us1_login_to_library;

import Library.utility.BrowserUtil;
import Library.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInWithInvalidCredentials extends TestBase {
    /**
     * AC #3 [negative]:
     * Given user is on the loginPage
     * When user enters invalid email address or password
     * And student click sign in button
     * Then verify the error message “Sorry, Wrong Email or Password”
     */
    @Test
    public void invalidLogIn(){

        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys("library@gmail.com");

        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("123456");

        WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signIn.click();

        BrowserUtil.waitFor(3);

        //Sorry, Wrong Email or Password
        //Then verify the error message “Sorry, Wrong Email or Password”

        WebElement warningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        String actualErrMsg = warningMsg.getText();

        BrowserUtil.waitFor(2);

        String expectedErrMsg = "Sorry, Wrong Email or Password";


        assertEquals(actualErrMsg,expectedErrMsg);


    }


}
