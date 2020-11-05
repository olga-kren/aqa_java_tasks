package test.java.HWLesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;

public class HWLesson9 extends TestBaseSetup {
    By searchInputBy = By.id("twotabsearchtextbox");

    @Test
    public void searchIphoneTest(){
        driver.get("https://www.amazon.com/");
        WebElement searchInput = driver.findElement(searchInputBy);
        searchInput.click();
    }
}
