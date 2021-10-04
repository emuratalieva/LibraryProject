package Library.us5_librarin_select_user_groups;

import Library.utility.BrowserUtil;
import Library.utility.Driver;
import Library.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianUserGroup extends TestBase {

    @Test
    public void librarianUserGroupSelection(){

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

        WebElement userGroupsDropDwn = driver.findElement(By.id("user_groups"));
        userGroupsDropDwn.click();

        Select select =new Select(driver.findElement(By.id("user_groups")));
         List<WebElement> groups =  select.getOptions();

         assertEquals(3, groups.size());



    }

}
