package Library.us6_librarian_user_status;

import Library.utility.BrowserUtil;
import Library.utility.Driver;
import Library.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianUserStatus_Avtive_VS_Inacive extends TestBase {

    @Test
    public void librarianSelectUserStatus(){

        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");

        WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys("librarian50@library");
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("Sdet2022*");
        BrowserUtil.waitFor(3);

        WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signIn.click();
        BrowserUtil.waitFor(3);

        WebElement usersModule = driver.findElement(By.xpath("//span[@class='title'][.='Users']"));
        usersModule.click();

        BrowserUtil.waitFor(3);

        Select select = new Select(driver.findElement(By.id("user_status")));
        List<WebElement> status = select.getOptions();

        assertEquals(2,status.size());

        BrowserUtil.waitFor(3);





    }


}
