package aqa.common;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverComponent {

    @Value("${browser:chrome}")
    private String browser;

    @Value("${app.message}")
    private String applicationMessage;

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @Bean
    @Scope("prototype")
    public WebDriver webDriver() {
        if (driverThreadLocal.get() == null) {
            driverThreadLocal.set(new DriverFactory().buildDriver(browser));
        }
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.set(null);
        }
    }
}