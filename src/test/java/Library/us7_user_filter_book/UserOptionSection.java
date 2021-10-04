package Library.us7_user_filter_book;

import Library.utility.BrowserUtil;
import Library.utility.Driver;
import Library.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserOptionSection extends TestBase {

    @Test
    public void userSelectDramaOptionBook(){

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

        WebElement allCategories = driver.findElement(By.id("book_categories"));
        allCategories.click();

        Select dropdownObjs=new Select(allCategories);

        dropdownObjs.selectByVisibleText("Drama");

        WebElement optionDrama = driver.findElement(By.xpath("//option[.='Drama']"));


        assertTrue(optionDrama.isSelected());

        BrowserUtil.waitFor(3);






    }

}
