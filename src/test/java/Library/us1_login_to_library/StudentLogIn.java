package Library.us1_login_to_library;

import Library.utility.BrowserUtil;
import Library.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AC#2: Given student is on the loginPage
 * Then verify that the URL is“https://library2.cybertekschool.com/login.html”
 * When student enters valid email address and password
 * And student click sign in button
 * Then verify that there are 2 models on the page
 */
public class StudentLogIn extends TestBase {



        @Test
        public void studentVerifyTitle(){
            driver.get("http://library2.cybertekschool.com/login.html");

            String actualResultUrl = driver.getCurrentUrl();
            String expectedResultUrl = "https://library2.cybertekschool.com/login.html";

            assertEquals(expectedResultUrl,actualResultUrl);
        }

        @Test
        public void studentLogInWithValidCredentials(){
           driver.get("http://library2.cybertekschool.com/login.html");
            //TODO: When student enters valid email address and password

            List<String> usernames = new ArrayList<>(Arrays.asList("student58@library",
                    "student59@library","student60@library")) ;
            String password = "Sdet2022*";

            for (String eachUsername : usernames) {
                WebElement inputUsername = driver.findElement(By.id("inputEmail"));
                inputUsername.sendKeys(eachUsername);

                WebElement passwordInput = driver.findElement(By.id("inputPassword"));
                passwordInput.sendKeys(password);
                BrowserUtil.waitFor(3);

                WebElement signInBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
                signInBtn.click();

                BrowserUtil.waitFor(3);

                List<WebElement> modules = driver.findElements(By.className("title"));

                if (modules.size() == 2) {
                    System.out.println("For user " + eachUsername + " Passed !");
                    System.out.println("Actual modules : " + modules.size());
                } else {
                    System.out.println("For user " + eachUsername + " Fail!!! There are : " + modules.size() + " modules");
                }

                BrowserUtil.waitFor(1);
                driver.findElement(By.xpath("//a[@role='button']")).click();

                BrowserUtil.waitFor(1);
                driver.findElement(By.linkText("Log Out")).click();
            }



//                WebElement profileBtn = driver.findElement(By.id("navbarDropdown"));
//                profileBtn.click();
//
//                WebElement logOut = driver.findElement(By.linkText("Log Out"));
//                logOut.click();
//
//                BrowserUtil.waitFor(2);

               // List<WebElement> modules = driver.findElements(By.className("title"));

             //   BrowserUtil.waitFor(2);

             //   int expectedModules = 2;

             //   assertEquals(expectedModules,modules.size());
                //




            }


        @Test
        public void verifyModules(){





    }


    }