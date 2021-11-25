package aqa.wait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Objects;

@Component
public class CustomWait {

    private static int FLUENT_WAIT_TIMEOUT = 1000;

    private static int POLLING = 3;

    protected static WebDriver driver;

    public static FluentWait<WebDriver> getNewFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    public static void waitUntilDocumentReadyState(WebDriver driver) {
        getNewFluentWait(driver)
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .until((ExpectedCondition<Boolean>) wd ->
                        ((JavascriptExecutor) Objects.requireNonNull(wd))
                                .executeScript("return document.readyState")
                                .equals("complete"));
    }

    public static WebElement waitWithPollingUntilVisibilityAndGetElement(WebElement element) {
        return getNewFluentWait(driver)
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitUntilVisibilityAndGetElement(WebElement element) {
        return getNewFluentWait(driver).until(ExpectedConditions.visibilityOf(element));
    }
}