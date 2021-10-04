package Library.us7_user_filter_book;

import Library.utility.BrowserUtil;
import Library.utility.Driver;
import Library.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserVerifyBookQuantityOption extends TestBase {

    @Test
    public void bookQuantityVerification(){
    Driver.getDriver().get("http://library2.cybertekschool.com/login.html");

    WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys("librarian50@library");
    WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("Sdet2022*");
        BrowserUtil.waitFor(3);

    WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signIn.click();
        BrowserUtil.waitFor(3);

    WebElement booksModule = driver.findElement(By.xpath("//span[.=\"Books\"]"));
        booksModule.click();
        BrowserUtil.waitFor(2);


        Select selectBookCategories = new Select(driver.findElement(By.id("book_categories")));
        List<WebElement> bookCategoriesDropDwn = selectBookCategories.getOptions();


        assertEquals(21,bookCategoriesDropDwn.size());

        BrowserUtil.waitFor(3);


    }

}
