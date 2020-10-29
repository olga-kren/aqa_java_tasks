package test.java.HWLesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TaskLesson7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.amazon.com/");
        Thread.sleep(5000);
        By byTodayDeals = By.xpath("//a[@href='/international-sales-offers/b/?ie=UTF8&node=15529609011&ref_=nav_cs_gb_intl']");
        WebElement todayDealsBtn = driver.findElement(byTodayDeals);
        todayDealsBtn.click();
        Thread.sleep(2000);
        //find See details button and click
        By seeDetails = By.xpath("//*[@id='100 6176b4de']");
        WebElement seeDetailsBtn = driver.findElement(seeDetails);
        seeDetailsBtn.click();
        Thread.sleep(2000);

        WebElement productDetailBtn = driver.findElement(By.xpath("//*[@id='octopus-dlp-asin-stream']/ul/li[1]/span/div/div[1]/a/div"));
        productDetailBtn.click();
        Thread.sleep(2000);

        WebElement oldPrice = driver.findElement(By.xpath("//*[@id='price']/table/tbody/tr[1]/td[2]/span[1]"));
        String oldPriceStr = oldPrice.getText();

        WebElement newPrice = driver.findElement(By.xpath("//*[@id='priceblock_dealprice']"));
        String newPriceStr = newPrice.getText();

        String newPriceStrReplace = newPriceStr.replace("$","");
        String oldPriceStrReplace = oldPriceStr.replace("$","");

        System.out.println("New price: "+ newPriceStrReplace +", old price: " + oldPriceStrReplace);

        driver.close();

    }

}
