package test.java.HWLesson10;

import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import test.java.TestBaseSetup;
import test.java.pages.HomePage;
import test.java.pages.SearchResultPage;
import test.java.utils.PropertyLoader;

import java.util.List;
import static org.testng.Assert.assertTrue;

public class HWLesson10 extends TestBaseSetup {
    HomePage homePage;
    SearchResultPage searchResultPage;

    @BeforeMethod
    public void pageInitialize() {
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);

    }

    @Test(dataProvider = "LaptopBrands")
    public void searchLaptopPage (String brand, String value){
        homePage
                .open()
                .searchInputSubmit(PropertyLoader.loadProperty("laptop"));
        searchResultPage
                .clickSeeMoreLabel()
                .clickCheckBoxes(value);

        List<WebElement> searchBrandList =
                searchResultPage.getResultList();

        for (WebElement brandItem: searchBrandList) {

            String actualSearchBrandResult = brandItem
                    .getText()
                    .toLowerCase();
            assertTrue(actualSearchBrandResult.contains(brand),
                    "Expected result should contain " + brand);

        }
        searchResultPage.clearSelection();
    }
    @DataProvider(name = "LaptopBrands")
    public Object[][] dataProvider(){
        return new Object[][]{
                {"hp", "//li[@id=\"p_89/HP\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"acer", "//li[@id=\"p_89/Acer\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"asus", "//li[@id=\"p_89/ASUS\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"lenovo", "//li[@id=\"p_89/Lenovo\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"dell", "//li[@id=\"p_89/Dell\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"microsoft", "//li[@id=\"p_89/Microsoft\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"apple", "//li[@id=\"p_89/Apple\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"chuwi", "//li[@id=\"p_89/CHUWI\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"lg", "//li[@id=\"p_89/LG\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"jumper", "//li[@id=\"p_89/jumper\"]//i[@class=\"a-icon a-icon-checkbox\"]"}
        };
    }

}

