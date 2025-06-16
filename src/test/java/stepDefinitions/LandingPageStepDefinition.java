package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() {

//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Users\\DELL\\eclipse-workspace\\qa.greenkart.com\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from the Home page");
    }

    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_the_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("search-field")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @Then("Validate product name in offers page matches with Landing page")
    public void Validate_product_name_in_offers_page_matches_with_Landing_page() {
        Assert.assertEquals(offerPageProductName, landingPageProductName);
    }

}
