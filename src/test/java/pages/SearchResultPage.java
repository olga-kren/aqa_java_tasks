package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;
//    By selectCellPhonesBy = By.xpath("//*[contains(text(), 'Cell Phones')][1]");
    By selectAppleBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");



    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public SearchResultPage selectAppleBoxBtn(){
        driver.findElement(selectAppleBoxBy).click();
        return this;
    }
    public List<WebElement> getResultList (){
//        logger.info("Get list of carts");
        return driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

    }
    public String getNameItem(WebElement searchItem){
        List<WebElement> searchItemList = searchItem.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        searchItemList.toString();
        String actualSearchNameItem = searchItem.getText();
        return actualSearchNameItem;
    }
}
