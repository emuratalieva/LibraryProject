package Library.us2_librarian_add_newUser;
import Library.utility.BrowserUtil;
import Library.utility.TestBase;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class LibrarianAddNewUser extends TestBase {

    /**
     * US2: As a librarian, I should be able to add a new user.
     * AC #1:
     * Given librarian is on the homePage
     * When librarian click Users module
     * And librarian click “+Add User” button
     * When librarian enter full name, password, email and
     * address
     * And librarian click save changes
     * Then verify a new user is created
     */
    @Test
    public void librarianAddUser() {

        driver.get("http://library2.cybertekschool.com/login.html");

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

        WebElement addUserBtn = driver.findElement(By.xpath("//a[@href='tpl/add-user.html']"));
        addUserBtn.click();

        Faker faker = new Faker();

        WebElement fullnameInputBox = driver.findElement(By.name("full_name"));
        fullnameInputBox.sendKeys(faker.name().fullName());

        BrowserUtil.waitFor(2);

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInputBox.sendKeys(faker.numerify("######"));

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys(faker.internet().emailAddress());

        WebElement addressInputBox = driver.findElement(By.id("address"));
        addressInputBox.click();
        addressInputBox.sendKeys(faker.address().fullAddress());

        BrowserUtil.waitFor(2);


        WebElement saveChangesBtn = driver.findElement(By.cssSelector("#add_user_modal .btn-primary"));
        saveChangesBtn.submit();

        BrowserUtil.waitFor(1);


        String expectedToastMsg = "The user has been created.";
        WebElement actualToastMsg = driver.findElement(By.cssSelector(".toast-message"));
        if (expectedToastMsg.equals(actualToastMsg.getText())) {
            System.out.println("-------------------------------------");
            System.out.println("Test Passed");
            System.out.println("actualToastMsg = " + actualToastMsg.getText());
            System.out.println("expectedToastMsg = " + expectedToastMsg);
        } else {
            System.out.println("-------------------------------------");
            System.out.println("Test Failed");
            System.out.println("actualToastMsg = " + actualToastMsg);
            System.out.println("expectedToastMsg = " + expectedToastMsg);
        }

        BrowserUtil.waitFor(2);


    }

    }
