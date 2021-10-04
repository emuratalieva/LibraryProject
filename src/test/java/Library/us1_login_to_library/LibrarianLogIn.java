package Library.us1_login_to_library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibrarianLogIn {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //        Given librarian is on the loginPage
//        Then verify that the title is “Login - Library”

        driver.get("http://library2.cybertekschool.com/login.html");

        if (driver.getTitle().equals("Login - Library")) {
            System.out.println("Passed");
        } else {
            System.out.println("Not passed");
            System.out.println("Login - Library (Expected)");
            System.out.println(driver.getTitle() + " (Actual)");
        }

//        When librarian enters valid email address and password
// student58@library Sdet2022*
        ArrayList<String> emails = new ArrayList<>(Arrays.asList("librarian50@library","librarian19@library"));

        for (String eachEmail : emails) {
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachEmail);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            Thread.sleep(3000);

            WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign in']"));
            signIn.click();
            Thread.sleep(3000);// need to wait until page load


            List<WebElement> modules = driver.findElements(By.className("title"));

            if(modules.size() == 3){
                System.out.println("For user "+eachEmail+" Passed !");
                System.out.println("Actual modules : "+ modules.size());
            }else{
                System.out.println("For user "+eachEmail+" Fail!!! There are : "+modules.size() + " modules");
            }

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[@role='button']")).click();

            Thread.sleep(1000);
            driver.findElement(By.linkText("Log Out")).click();

        }

          Thread.sleep(2000);
          driver.quit();

//        And librarian click sign in button
//        Then verify that there are 3 models on the pag



    }

}
