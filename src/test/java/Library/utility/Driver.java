package Library.utility;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * make Singleton pattern
 * 1. Make Constructor private
 * 2. private static field
 * 3. public getter for the field
 * --if the static field is not assgned value yet(is null)
 *    create new object and assign it
 * -- if not -> return same static field value
 *
 */
public class Driver {

    private static WebDriver obj;

    private Driver(){} // empty constructor -> to block creating of object for this particular driver

    public static WebDriver getDriver(){

        if(obj == null){
            System.out.println("Creating Object first time");
            WebDriverManager.chromedriver().setup();
            obj = new ChromeDriver();
            obj.manage().window().maximize();
            return obj;
        }
        System.out.println("Object already existing returning existing one");
            return obj;


        }



    }


