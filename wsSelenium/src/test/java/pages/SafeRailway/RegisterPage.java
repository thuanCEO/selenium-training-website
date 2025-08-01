package pages.SafeRailway;


import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;
import utils.LocatorLoader;

public class RegisterPage  extends BaseTest {
    private ElementUtil elementUtil;

    private String elementInputEmail = LocatorLoader.getLocators("inputEmail");
    private String elementInputPassword = LocatorLoader.getLocators("inputPassword");
    private String elementInputConfirmPassword = LocatorLoader.getLocators("inputConfirmPassword");
    private String elementInputPID = LocatorLoader.getLocators("inputPID");
    private String elementButtonRegister = LocatorLoader.getLocators("buttonRegister");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void fillInputEmail(String value) {
        elementUtil.fillInputByXpath(elementInputEmail,value);
    }

    public void fillInputPassword(String value) {
        elementUtil.fillInputByXpath(elementInputPassword,value);
    }

    public void fillInputConfirmPassword(String value) {
        elementUtil.fillInputByXpath(elementInputConfirmPassword,value);
    }

    public void fillInputPID(String value) {
        elementUtil.fillInputByXpath(elementInputPID,value);
    }

    public void clickRegisterButton() {
        elementUtil.getElementByXpath(elementButtonRegister).click();
    }

    public void registerNewAccount(String email, String password, String confirmPassword, String pid) {
        this.fillInputEmail(email);
        this.fillInputPassword(password);
        this.fillInputConfirmPassword(confirmPassword);
        this.fillInputPID(pid);
        this.clickRegisterButton();
    }
}
