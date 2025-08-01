package pages.SafeRailway;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;
import utils.LocatorLoader;


public class SaleRailwayPage extends BaseTest {
    private WebDriver driver;
    private ElementUtil elementUtil;

    private String elementMenuOptions = LocatorLoader.getLocators("menuOptions","Register");

    public SaleRailwayPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void clickMenuOptionRegister() {
        elementUtil.getElementByXpath(elementMenuOptions).click();
    }
}
