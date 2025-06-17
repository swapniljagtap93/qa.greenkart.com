package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
public WebDriver driver;

public OffersPage(WebDriver driver){
    this.driver=driver;
}
    public By searchInput = By.id("search-field");
    public By offersPageProductName=By.cssSelector("tr td:nth-child(1)");

    public void searchForProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
    }
    public String getProductName(){
        return driver.findElement(offersPageProductName).getText();
    }
}
