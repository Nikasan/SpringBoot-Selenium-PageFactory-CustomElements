package aqa.customelement;

import aqa.customelement.abstraction.Element;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static aqa.wait.CustomWait.*;

public class Input extends Element {
    public Input(WebElement webElement) {
        super(webElement);
    }

    public void waitAndSendKeys(Keys keys, WebDriver driver) {
        getNewFluentWait(driver).until(ExpectedConditions.visibilityOf(webElement)).sendKeys(keys);
    }

    public void waitAndSendKeys(String str, WebDriver driver) {
        getNewFluentWait(driver).until(ExpectedConditions.visibilityOf(webElement)).sendKeys(str);
    }



    public void waitClearAndSendKeys(String keys, WebDriver driver) {
        getNewFluentWait(driver).until(ExpectedConditions.visibilityOf(webElement)).clear();
        webElement.sendKeys(keys);
    }

    public void waitWithPollingAndSendKeys(String keys, WebDriver driver) {
        waitUntilDocumentReadyState(driver);
        waitWithPollingUntilVisibilityAndGetElement(webElement).sendKeys(keys);
    }
}