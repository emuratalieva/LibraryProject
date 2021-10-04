package Library.us4_librarian_logout;

import Library.utility.BrowserUtil;
import Library.utility.Driver;
import Library.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianLogOutFunction extends TestBase {

    @Test
    public void librarianLogoutFromHomepage(){

        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");

        WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys("librarian50@library");
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("Sdet2022*");
        BrowserUtil.waitFor(3);

        WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signIn.click();
        BrowserUtil.waitFor(3);

        WebElement usernameTopCornerBtn = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
        usernameTopCornerBtn.click();

        WebElement logout = driver.findElement(By.xpath("//a[.='Log Out']"));
        logout.click();

        String expectedResultTitle = "Login - Library";
        String actualResultTitle = driver.getTitle();
        assertEquals(expectedResultTitle,actualResultTitle );






    }

}
