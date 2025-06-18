package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        return driver;
    }

}
