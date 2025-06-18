package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {
    public WebDriver driver;
    LandingPage landingPage;
    OffersPage offersPage;

    public PageObjectsManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage()
    {
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    public OffersPage getOffersPage(){
        offersPage = new OffersPage(driver);
        return offersPage;
    }
}