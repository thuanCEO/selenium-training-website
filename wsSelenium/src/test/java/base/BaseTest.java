package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentReportManager;

import java.lang.reflect.Method;

public class BaseTest implements WebDriverProvider {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
//         options.addArguments("--headless");  // nếu muốn chạy headless, uncomment dòng này.
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @BeforeMethod
    public void startTest(Method method) {
        // Khởi tạo một ExtentTest cho mỗi test case
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test failed: " + result.getThrowable());  // Ghi lại lỗi nếu test thất bại
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");  // Ghi lại nếu test thành công
        }

        // Ghi lại thời gian và thông tin thêm
        test.info("Test execution completed");

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
