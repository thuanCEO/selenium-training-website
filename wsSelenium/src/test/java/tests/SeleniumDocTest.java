package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SeleniumDocPage;

@Epic("Selenium Website")
@Feature("Header Verification")
public class SeleniumDocTest extends BaseTest {

    @Test(description = "Verify header title on Selenium documentation page")
    @Severity(SeverityLevel.NORMAL)
    @Story("Verify page header")
    public void testSeleniumHeaderTitle() {
        SeleniumDocPage seleniumPage = new SeleniumDocPage(driver);
        seleniumPage.open();

        String header = seleniumPage.getHeaderTitle();
        Allure.step("Header Title: " + header);

        Assert.assertTrue(header.contains("The Selenium Browser Automation Project"));
    }
}
