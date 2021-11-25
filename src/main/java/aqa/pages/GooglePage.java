package aqa.pages;

import aqa.customelement.Button;
import aqa.customelement.Input;
import aqa.customelement.customdecorator.CustomFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.openqa.selenium.support.PageFactory.initElements;

@Component
@Scope("prototype")
public class GooglePage extends BasePage {

    @Value("${url}")
    private String url;

    @FindBy(name = "q")
    private Input search;

    @FindBy(id = "login")
    private Button magnifier;

    public void openLoginPage() {
        this.driver.get(url);
    }

    public void typeSearchRequest(String request) {
        search.waitAndSendKeys(request, driver);
    }

    public void clickSearch() {
        magnifier.waitUntilDocumentIsReadyAndClick(driver);
    }

    public void pressEnter() {
        search.waitAndSendKeys(Keys.ENTER, driver);
    }

    @PostConstruct
    public void init() {
        System.out.println("---------" + this.driver.getClass().toString() + "---------");
        initElements(new CustomFieldDecorator(this.driver), this);
    }
}