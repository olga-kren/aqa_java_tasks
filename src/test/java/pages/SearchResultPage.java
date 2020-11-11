package test.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SearchResultPage {
    private Logger logger = LogManager.getLogger(SearchResultPage.class);
    WebDriver driver;
    WebDriverWait wait;

    By selectAppleBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
    By searchResultReadyBy = By.xpath("//div[@data-component-type='s-search-result']");
    By searchItemListBy = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }
    public SearchResultPage selectAppleBoxBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(selectAppleBoxBy));
        driver.findElement(selectAppleBoxBy).click();
        return this;
    }
    public List<WebElement> getResultList (){
        return driver.findElements(searchResultReadyBy);

    }
    public String getNameItem(WebElement searchItem){
        List<WebElement> searchItemList = searchItem.findElements(searchItemListBy);
        searchItemList.toString();
        String actualSearchNameItem = searchItem.getText();
        return actualSearchNameItem;
    }

}
