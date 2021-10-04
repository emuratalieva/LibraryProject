package Library.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserName){
        WebDriver driver;
        switch(browserName.toLowerCase()){

            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox" :
               WebDriverManager.chromedriver().setup();
               driver = new FirefoxDriver();
               break;

            case "opera" :
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;

            default:
                driver = null;
                System.out.println("Unknown browser type!!! "+browserName);

        }

        driver.manage().window().maximize();
        return driver;
    }

}
