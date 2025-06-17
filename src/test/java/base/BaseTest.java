package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {
    protected WebDriver driver;

    static {
        // Silencia os logs de WARNING do Selenium e DevTools
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        Logger.getLogger("org.openqa.selenium.devtools").setLevel(Level.OFF);
    }



    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
