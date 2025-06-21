package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectsManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;
    LandingPage landingPage;
    PageObjectsManager pageObjectsManager;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    public void InitializeLandingPage() {
        landingPage = testContextSetup.pageObjectsManager.getLandingPage();
    }

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() {


    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        //    pageObjectsManager = new PageObjectsManager(testContextSetup.driver);
        // Create pageObjectsManager object in the testContextSetup constructor
        landingPage = testContextSetup.pageObjectsManager.getLandingPage();
        landingPage.searchForProduct(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getProductName();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from the Home page");
    }

    @When("User click on Top Deals link in the Landing Page")
    public void user_click_on_top_deals_link_in_the_landing_page() {
        landingPage.clickTopDeals();
    }


    @When("User fetches all the products from the landing page")
    public void userFetchesAllTheProductsFromTheLandingPage() {
        InitializeLandingPage();
        landingPage.getAllProducts();
    }

    @Then("User should see all the products and their prices")
    public void userShouldSeeAllTheProductsAndTheirPrices() {
        InitializeLandingPage();
        landingPage.checkAssertion();
    }
}
