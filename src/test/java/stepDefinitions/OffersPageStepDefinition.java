package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OffersPageStepDefinition {
    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public OffersPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_the_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows = testContextSetup.driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        testContextSetup.driver.switchTo().window(childWindow);
        testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @Then("Validate product name in offers page matches with Landing page")
    public void Validate_product_name_in_offers_page_matches_with_Landing_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }

}
