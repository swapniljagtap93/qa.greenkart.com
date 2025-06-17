package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() {

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage = new LandingPage(testContextSetup.driver);
        landingPage.searchForProduct(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getProductName();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from the Home page");
    }

    @When("User click on Top Deals link in the Landing Page")
    public void user_click_on_top_deals_link_in_the_landing_page() {
        landingPage.clickTopDeals();
    }

}
