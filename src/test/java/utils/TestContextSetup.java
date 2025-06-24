package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectsManager;

public class TestContextSetup {

    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectsManager pageObjectsManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() {
        testBase = new TestBase();
        pageObjectsManager = new PageObjectsManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
