package aqa.tests.suits;

import aqa.pages.GooglePage;
import aqa.pages.SearchResultPage;
import aqa.tests.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchTest2 extends BaseTest {

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private SearchResultPage searchResultPage;

    @Test
    public void positiveLogin() {
        googlePage.openLoginPage();
        googlePage.typeSearchRequest("TestNG");
        googlePage.pressEnter();
        assertThat(searchResultPage.getCurrentUrl()).startsWith("https://www.google.com/search?q=TestNG");
    }
}