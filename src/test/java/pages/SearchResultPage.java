package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;
    By selectCellPhonesBy = By.xpath("//*[contains(text(), 'Cell Phones')][1]");


    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public SearchResultPage selectCellPhoneBtn(){
        driver.findElement(selectCellPhonesBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#searchDropdownBox > option:nth-child(1)")));
        return this;
    }

}
