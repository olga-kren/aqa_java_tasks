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
    String iphone = "iphone";
    String samsung = "samsung";

    @BeforeMethod
    public void pageInitialize() {
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        homePage.open();
    }

    @Test
    public void searchIphoneTest(){

        homePage
                .searchInputSubmit(iphone);

        List<WebElement> searchIphoneList =
        searchResultPage
                .selectAppleBoxBtn()
                .getResultList();

        for ( WebElement searchItem: searchIphoneList) {
            String actualSearchIphoneResult =
                    searchResultPage
                            .getNameItem(searchItem)
                            .toLowerCase();
            assertTrue(actualSearchIphoneResult.contains(iphone), "Search result contains iPhone");
        }
    }
    @Test
    public void samsungSearchTest(){
        homePage
                .searchInputSubmit(samsung);

        List<WebElement> searchSamsungList =
            searchResultPage
                .getResultList();

        for ( WebElement searchItem: searchSamsungList) {
            String actualSearchSamsungResult = searchResultPage
                .getNameItem(searchItem)
                .toLowerCase();
            assertTrue(actualSearchSamsungResult.contains(samsung), "Search result contains Samsung");
    }
}
}
