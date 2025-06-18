package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinition {
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    OffersPage offersPage;

    public OffersPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_the_same_shortname_in_offers_page(String shortName) throws InterruptedException {
       // Switch_to_offers_page();
       testContextSetup.genericUtils.switchWindowToChild();
        offersPage = testContextSetup.pageObjectsManager.getOffersPage();
        offersPage.searchForProduct(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
    }

//    public void Switch_to_offers_page() {
//        Set<String> windows = testContextSetup.driver.getWindowHandles();
//        Iterator<String> it = windows.iterator();
//        String parentWindow = it.next();
//        String childWindow = it.next();
//        testContextSetup.driver.switchTo().window(childWindow);
//    }

    @Then("Validate product name in offers page matches with Landing page")
    public void Validate_product_name_in_offers_page_matches_with_Landing_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }

}
