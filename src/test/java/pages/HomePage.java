package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By searchInputBy = By.id("twotabsearchtextbox");
    By searchSubmitBy = By.xpath("//*[@id='nav-search-submit-text']/input");

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public HomePage open(){
        driver.get("https://www.amazon.com/");
        return this;
    }
    public HomePage searchInputSubmit(String text){
        WebElement searchInput = driver.findElement(searchInputBy);
        searchInput.sendKeys(text);
        WebElement searchSubmitBtn = driver.findElement(searchSubmitBy);
        searchSubmitBtn.click();
        return this;
    }

}
