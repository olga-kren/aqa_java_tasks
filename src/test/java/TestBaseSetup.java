package test.java;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.java.utils.Screenshots;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {
    public WebDriver driver;

    @BeforeClass
    public void initializeBrowser(ITestContext iTestContext) {
/*        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);*/
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions ffOption = new FirefoxOptions();
        try {
            //driver = new RemoteWebDriver(new URL("http://ec2-18-223-162-200.us-east-2.compute.amazonaws.com:4444/wd/hub"), chromeOptions);
            MutableCapabilities options = System.getProperty("browser").equals("chrome")
                    ? chromeOptions
                    : ffOption;
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        iTestContext.setAttribute("driver", driver);
    }

    @AfterClass
    public void finalizeBrowser() {
//        Screenshots screenshots = new Screenshots(driver);
//        screenshots.makeScreenshot(testResult);
        driver.quit();
        }


}
