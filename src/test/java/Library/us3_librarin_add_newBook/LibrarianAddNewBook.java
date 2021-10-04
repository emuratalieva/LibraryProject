package Library.us3_librarin_add_newBook;

import Library.utility.BrowserUtil;
import Library.utility.Driver;
import Library.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LibrarianAddNewBook extends TestBase {
    /**
     * AC #1:
     * Given librarian is on the homePage
     * When librarian click Books module
     * And librarian click “+Add Book” button
     * When librarian enter BookName, ISBN, Year, Author, and Description
     * And librarian click save changes
     * Then verify a new book is added
     */
    @Test
    public void librarianNewBook(){

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
        BrowserUtil.waitFor(1);

        WebElement addBookBtn = driver.findElement(By.xpath("//a[@href='tpl/add-book.html']"));
        addBookBtn.click();
        BrowserUtil.waitFor(1);

        WebElement bookNameBox = driver.findElement(By.xpath("//input[@class='form-control'][@placeholder='Book Name']"));
        bookNameBox.sendKeys("Save the Planet");

        WebElement isbnBox = driver.findElement(By.name("isbn"));
        isbnBox.sendKeys("9781518968785");

        WebElement yearBox = driver.findElement(By.name("year"));
        yearBox.sendKeys("2017");

        WebElement authorInput = driver.findElement(By.xpath("//input[@class='form-control'][@placeholder='Author']"));
        authorInput.sendKeys("Matt Montanez");


        WebElement bookCategoryDropDwn = driver.findElement(By.id("book_group_id"));
        Select selectObj = new Select(bookCategoryDropDwn);
        selectObj.selectByVisibleText("Action and Adventure");

        WebElement descriptionBox = driver.findElement(By.id("description"));
        descriptionBox.sendKeys("Save the Planet: Reduce, Reuse, and Recycle");

        WebElement saveChangesBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        saveChangesBtn.submit();

        String expectedToastMsg = "The book has been created.";
        WebElement actualToastMsg = driver.findElement(By.cssSelector(".toast-message"));
        if(expectedToastMsg.equals(actualToastMsg.getText())){
            System.out.println("-------------------------------------");
            System.out.println("Test Passed");
            System.out.println("actualToastMsg = " + actualToastMsg.getText());
            System.out.println("expectedToastMsg = " + expectedToastMsg);
        }else{
            System.out.println("-------------------------------------");
            System.out.println("Test Failed");
            System.out.println("actualToastMsg = " + actualToastMsg);
            System.out.println("expectedToastMsg = " + expectedToastMsg);
        }

        BrowserUtil.waitFor(2);









    }




}
