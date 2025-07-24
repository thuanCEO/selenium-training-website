package pages;

import constants.UrlConstants;
import locators.SeleniumDocPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumDocPage {
    private WebDriver driver;

    public SeleniumDocPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(UrlConstants.SELENIUM_DOCUMENTATION_URL);
    }

    public String getHeaderTitle() {
        WebElement title = driver.findElement(SeleniumDocPageLocators.HEADER_TITLE);
        return title.getText();
    }
}
