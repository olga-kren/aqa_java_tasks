package test.java.HWLesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class HWLesson8 {
    WebDriver driver;
    WebDriverWait wait;
    By signInBy = By.xpath("//*[@id='nav-link-accountList']/div");
    By createYourAccountBy = By.id("createAccountSubmit");
    By createYourAccount2By = By.xpath("//*[@id='continue']");
    By nameInputBy = By.cssSelector("#ap_customer_name");
    By emailInputBy = By.cssSelector("#ap_email");
    By passwordBy = By.cssSelector("#ap_password");
    By passwordCheckBy = By.cssSelector("#ap_password_check");
//    By nameAlertBy = By.id("auth-customerName-missing-alert");
//    By emailAlertBy = By.id("auth-email-missing-alert");
//    By passAlertBy = By.id("auth-password-missing-alert");

    String expectedBorderColor = "rgb(221, 0, 0)";
    @BeforeMethod
    public void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10, 500);
    }
    public void openCreateAccountFlow(){
        driver.get("https://www.amazon.com/");
        WebElement signInBtn = driver.findElement(signInBy);
        signInBtn.click();
        WebElement createYourAccountBtn = driver.findElement(createYourAccountBy);
        createYourAccountBtn.click();
    }
    public void clickCreateAccountBtn2(){
        WebElement createYourAccount2Btn = driver.findElement(createYourAccount2By);
        createYourAccount2Btn.click();
    }
    @Test
    public void CreateAccountTest(){
        openCreateAccountFlow();
        clickCreateAccountBtn2();
        WebElement nameInput = driver.findElement(nameInputBy);
        WebElement emailInput = driver.findElement(emailInputBy);
        WebElement passwordInput = driver.findElement(passwordBy);

        WebElement nameAlert = driver.findElement(By.id("auth-customerName-missing-alert"));
        WebElement emailAlert = driver.findElement(By.id("auth-email-missing-alert"));
        WebElement passAlert = driver.findElement(By.id("auth-password-missing-alert"));

        String actualNameBorderClr = nameInput.getCssValue("border-color");
        String actualEmailBorderClr = emailInput.getCssValue("border-color");
        String actualPassBorderClr = passwordInput.getCssValue("border-color");

        assertEquals(actualNameBorderClr, expectedBorderColor);
        assertEquals(actualEmailBorderClr, expectedBorderColor);
        assertEquals(actualPassBorderClr, expectedBorderColor);
        assertEquals(nameAlert.getText(), "Enter your name");
        assertEquals(emailAlert.getText(), "Enter your email");
        assertEquals(passAlert.getText(), "Enter your password");

    }
    @Test
    public void CreateAccountTest2(){
        openCreateAccountFlow();
        driver.findElement(nameInputBy).sendKeys("somename");
        driver.findElement(emailInputBy).sendKeys("somemail@mail.com");
        driver.findElement(passwordBy).sendKeys("qwerty");
        clickCreateAccountBtn2();
        WebElement passwordCheck = driver.findElement(passwordCheckBy);
        WebElement passwordCheckAlert = driver.findElement(By.id("auth-passwordCheck-missing-alert"));
        String actualPassCheckBorderClr = passwordCheck.getCssValue("border-color");

        assertEquals(actualPassCheckBorderClr, expectedBorderColor);
        assertEquals(passwordCheckAlert.getText(),"Type your password again");
    }
    @AfterMethod
       public void finalizeBrowser() {
        driver.quit();
    }

}
