package aqa.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BasePage {

    @Lazy
    @Autowired
    protected WebDriver driver;
}
