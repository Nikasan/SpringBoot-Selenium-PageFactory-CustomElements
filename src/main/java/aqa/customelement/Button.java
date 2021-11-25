package aqa.customelement;

import aqa.customelement.abstraction.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static aqa.wait.CustomWait.*;

public class Button extends Element {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void waitAndClick(WebDriver driver) {
        getNewFluentWait(driver).until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public void waitUntilDocumentIsReadyAndClick(WebDriver driver) {
        waitUntilDocumentReadyState(driver);
        getNewFluentWait(driver).until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public void waitWithPollingUntilDocumentIsReadyAndClick(WebDriver driver) {
        waitUntilDocumentReadyState(driver);
        waitWithPollingUntilVisibilityAndGetElement(webElement).click();
    }
}
