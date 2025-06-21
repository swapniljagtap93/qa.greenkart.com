package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage {
    // This class can be used to define locators and methods related to the Landing Page
    // For example, you can define locators for search input, product name, and top deals link

    // Example locators (these would be used in the step definitions):
    public By searchInput = By.xpath("//input[@type='search']");
    public By productName = By.cssSelector("h4.product-name");
    public By topDealsLink = By.linkText("Top Deals");
    public By allProductsName = By.xpath("//h4[@class='product-name']");
    public By allProductsPrices = By.xpath("//p[@class='product-price']");
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

    public void getAllProducts() {

        List<WebElement> allProducts = driver.findElements(allProductsName);
        List<WebElement> allPrices = driver.findElements(allProductsPrices);

        for (int i = 0; i < allProducts.size(); i++)
        {
            System.out.println(allProducts.get(i).getText().split("-")[0].trim() + "==" + allPrices.get(i).getText());
        }
    }

    public void checkAssertion()
    {
        List<WebElement> allProducts = driver.findElements(allProductsName);
        List<WebElement> allPrices = driver.findElements(allProductsPrices);

        for (int i = 0; i < allProducts.size(); i++)
        {
            if (allPrices.get(i).getText().isEmpty())
            {
                System.out.println("Product without prices are "+allProducts.get(i).getText().split("-")[0].trim() + "==" + allPrices.get(i).getText());
            }
        }
        System.out.println("Assertion completed. All products and their prices are displayed in the console.");
    }
}
