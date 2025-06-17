package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    // This class can be used to define locators and methods related to the Landing Page
    // For example, you can define locators for search input, product name, and top deals link

    // Example locators (these would be used in the step definitions):
    public By searchInput = By.xpath("//input[@type='search']");
    public By productName = By.cssSelector("h4.product-name");
    public By topDealsLink = By.linkText("Top Deals");
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    // You can also define methods to interact with these elements if needed
    public void searchForProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
    }

    public String getProductName() {
        return driver.findElement(this.productName).getText().split("-")[0].trim();
    }

    public void clickTopDeals() {
        driver.findElement(topDealsLink).click();
    }
}
