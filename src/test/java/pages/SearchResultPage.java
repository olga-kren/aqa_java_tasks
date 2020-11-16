package test.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SearchResultPage {
    private Logger logger = LogManager.getLogger(SearchResultPage.class);
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[3]//*[@class='a-icon a-icon-checkbox']")
    public List <WebElement> checkBoxesBrand;
    @FindBy(xpath = "(//i[@class='a-icon a-icon-extender-expand'])[2]")
    public WebElement clickSeeMore;
    @FindBy(xpath = ("//span[@class='a-size-medium a-color-base a-text-normal']"))
    public List<WebElement> searchNameList;




    By hpCheckBoxBy = By.xpath("//i[@class='a-icon a-icon-checkbox'])[1]");
    By selectAppleBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
    By searchResultReadyBy = By.xpath("//div[@data-component-type='s-search-result']");
    By searchItemListBy = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

//    By hpCheckBoxBy = By.xpath("//*[@id='p_89/HP']/span/a/span");
//    By selectBrandsAreaBy = By.xpath("(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[3]");
//    By clickSeeMoreBy = By.xpath("(//span[@class='a-expander-prompt'])[2]");

    public SearchResultPage(WebDriver driver){
        logger.trace("SEARCH RESULT PAGE was initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
        PageFactory.initElements(driver, this);
    }
    public SearchResultPage selectAppleBoxBtn(){
        logger.info("Select Apple check box");
        wait.until(ExpectedConditions.elementToBeClickable(selectAppleBoxBy));
        driver.findElement(selectAppleBoxBy).click();
        return this;
    }
 /*   public SearchResultPage clickHpCheckBox(){
        logger.info("Click on HP checkbox");
        hpCheckBox.click();
        return this;
    }*/
    public SearchResultPage clickSeeMoreLabel(){
        logger.info("Click to expand checkbox list");
        wait.until(ExpectedConditions.elementToBeClickable(clickSeeMore));
        clickSeeMore.click();
        return this;
    }
    public SearchResultPage clickCheckBoxes(String value){
        logger.info("Click proper checkbox");
        logger.warn("WARN: problem with checkbox");
        WebElement brandName =
                driver.findElement(By.xpath(value));
        brandName.click();
        return this;
    }

    public List<WebElement> getResultList (){
        logger.info("Get serch result");
        return driver.findElements(searchResultReadyBy);
    }
    public String getNameItem(WebElement searchItem){
        logger.info("Find name of " + searchItem);
        List<WebElement> searchItemList = searchItem.findElements(searchItemListBy);
        searchItemList.toString();
        String actualSearchNameItem = searchItem.getText();
        return actualSearchNameItem;
    }
/*
    public SearchResultPage clickBrand (String brand) {
        logger.info("Click Brand");
        WebElement brandName =
                driver.findElement(By.xpath("//li[@class='a-spacing-micro' and @aria-label='" + brand + "']"));

        brandName.click();
        return this;
    }
*/

/*
    public List<WebElement> getBrandList (){
        checkBoxesBrand.toString();


//        clickSeeMore.click();
        return checkBoxesBrand;
    }
*/


}
