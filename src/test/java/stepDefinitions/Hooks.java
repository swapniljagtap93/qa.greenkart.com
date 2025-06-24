package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContextSetup;

public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Before
    public void maximizeWindow() {
        testContextSetup.testBase.WebDriverManager().manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        testContextSetup.testBase.WebDriverManager().quit();
    }



}
