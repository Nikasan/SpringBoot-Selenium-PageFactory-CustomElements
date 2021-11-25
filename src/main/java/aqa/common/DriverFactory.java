package aqa.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

   public WebDriver buildDriver(String browser) {
        WebDriver driver = null;
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            if (browser.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }
}