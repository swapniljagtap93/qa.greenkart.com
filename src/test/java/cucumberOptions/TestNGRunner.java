package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                 features = "src/test/java/features",
                glue = "stepDefinitions",
                monochrome = true,
                tags = "@Test",
                plugin =
                        { "pretty",
                        "html:target/cucumber-reports/cucumber.html",
                        "rerun:target//failed-tests//rerun.txt"
                         }
        )

public class TestNGRunner extends AbstractTestNGCucumberTests {


}
