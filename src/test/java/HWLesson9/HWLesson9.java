package test.java.HWLesson9;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.pages.HomePage;
import test.java.pages.SearchResultPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class HWLesson9 extends TestBaseSetup {
    HomePage homePage;
    SearchResultPage searchResultPage;

    @BeforeMethod
    public void pageInitialize() {

        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void searchIphoneTest(){

        homePage
                .open()
                .searchInputSubmit(iphone);
        List<WebElement> searchItemList =
        searchResultPage
                .selectAppleBoxBtn()
                .getResultList();

        for ( WebElement searchItem: searchItemList) {

            String actualSearchNameResult = searchResultPage.getNameItem(searchItem).toLowerCase();
            assertTrue(actualSearchNameResult.contains(iphone));
        }
    }

}
