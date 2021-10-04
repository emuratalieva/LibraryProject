package Library.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    public WebDriver driver;


    @BeforeEach
    public void setupWebDriver(){
         driver = Driver.getDriver(); // WebDriverFactory.get("chrome")
      //  driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
