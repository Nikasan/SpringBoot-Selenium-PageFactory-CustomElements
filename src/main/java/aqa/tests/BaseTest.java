package aqa.tests;

import aqa.MoexEkbdAutotestsApplication;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

/**
 *
 */
@SpringBootTest(classes = MoexEkbdAutotestsApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Lazy
    @Autowired
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void before() {
        System.out.println("Test Suite is running");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("Test method is running!");
    }

    @AfterMethod()
    public void afterMethod(ITestResult testResult, Method method) {
        System.out.println("------- The webdriver is closing --------");
        if (testResult.isSuccess()) {
            System.out.println(String.format("\n\n\nTest '%s' has successfully PASSED", method.getName()));
        } else {
            System.out.println(String.format("\n\n\nTest '%s' has FAILED", method.getName()));
        }
        this.driver.quit();
    }
}