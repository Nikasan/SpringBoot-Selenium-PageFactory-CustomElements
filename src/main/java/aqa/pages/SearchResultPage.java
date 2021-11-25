package aqa.pages;

import aqa.customelement.Input;
import aqa.customelement.customdecorator.CustomFieldDecorator;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.support.PageFactory.initElements;

@Component
public class SearchResultPage extends BasePage {

    @FindBy(name = "q")
    private Input searchField;

    @PostConstruct
    public void init() {
        initElements(new CustomFieldDecorator(this.driver), this);
    }

    public String getCurrentUrl(){
       return this.driver.getCurrentUrl();
    }
}
