package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = "@target//failed-tests//rerun.txt",
                glue = "stepDefinitions",
                monochrome = true,
                tags = "@Test",
                plugin =
                        { "pretty",
                        "html:target/cucumber-reports/cucumber.html"
                         }
        )

public class TestNGRerun extends AbstractTestNGCucumberTests {


}
