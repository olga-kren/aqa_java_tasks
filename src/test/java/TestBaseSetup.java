package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import test.java.utils.Screenshots;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseSetup {
    public WebDriver driver;

    @BeforeMethod
    public void initializeBrowser(ITestContext iTestContext) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void finalizeBrowser() {
//        Screenshots screenshots = new Screenshots(driver);
//        screenshots.makeScreenshot(testResult);
        driver.quit();
        }


}
