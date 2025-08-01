package tests.SafeRailway;

import base.BaseTest;
import constants.LocatorFilePaths;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SafeRailway.RegisterPage;
import pages.SafeRailway.SaleRailwayPage;
import pages.Selenium.SeleniumDocPage;
import utils.LocatorLoader;
import static constants.LocatorFilePaths.*;

import static constants.UrlConstants.SAFE_RAILWAY_URL;


@Epic("Selenium Website")
@Feature("Header Verification")
public class RegisterAccount extends BaseTest {
    private LocatorFilePaths locatorFilePaths;
    private SaleRailwayPage salePage;
    private RegisterPage registerPage;

    @BeforeMethod
    public void setupLocators() {
        LocatorLoader.clear();
        LocatorLoader.loadMultiple(locatorFilePaths.SAFE_RAILWAY_LOCATOR_FILE,locatorFilePaths.REGISTER_PAGE_LOCATOR_FILE);
        driver.get(SAFE_RAILWAY_URL);
        salePage = new SaleRailwayPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test(description = "Navigate To Register Page")
    @Severity(SeverityLevel.NORMAL)
    @Story("Register Account")
    public void testNavigateToRegisterPage() throws InterruptedException {
        salePage.clickMenuOptionRegister();

        registerPage.registerNewAccount(
                "sssaaaaaaa@gmail.com",
                "23232323",
                "23232323",
                "23232323");


        Thread.sleep(10000);




    }
}
