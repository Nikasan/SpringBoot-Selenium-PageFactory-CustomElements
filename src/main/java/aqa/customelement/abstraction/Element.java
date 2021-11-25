package aqa.customelement.abstraction;

import org.openqa.selenium.WebElement;

public abstract class Element implements IElement {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    protected String getLocator() {
        return webElement.toString();
    }
}
