package test.java.HWLesson9;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.pages.HomePage;
import test.java.pages.SearchResultPage;

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
                .searchInputSubmit("iPhone");
        searchResultPage
                .selectCellPhoneBtn();


//        ;


    }

}
