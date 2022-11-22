package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class webScreens extends startWebDriver {

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static void scrollToShowRows(WebDriver driver, int rows) {

        String abc = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/div[1]/a/span")).getText();
        System.out.println("Value:" + abc);

        closeAlert(getDriver());

        WebElement showRows = driver.findElement(By.xpath("//div[@display=\"flex\"]/p[text()='Show rows']/following-sibling::div"));
        waitTo(2);
        showRows.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"tippy-content\"]//button[text()='"+rows+"']")));
        WebElement clkEle = driver.findElement(By.xpath("//div[@class=\"tippy-content\"]//button[text()='"+rows+"']"));
        clkEle.click();
    }

    public static void showVaueAt100(WebDriver driver, int rows) {

        WebElement searchValues1 = null;
        for(int idx=1; idx <= rows; idx++) {
            searchValues1 = driver.findElement(By.xpath("//colgroup/following-sibling::tbody/tr/td/p[text()='"+idx+"']"));

            js.executeScript("window.scrollBy(0,79)", "");
            if(!searchValues1.isDisplayed()) {
                js.executeScript("window.scrollBy(0,78)", "");
                waitTo(1);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Maybe later']")));
                driver.findElement(By.xpath("//button[text()='Maybe later']")).click();
            }

            try {
                searchValues1.click();
            } catch (Exception e) {
                js.executeScript("window.scrollBy(0,78)", "");
                searchValues1.click();
            }

            if(idx == rows) {

                WebElement crypto100  = driver.findElement(By.xpath("//colgroup/following-sibling::tbody/tr/td/p[text()='"+rows+"']/../following-sibling::*//p"));
                String crypto100Value = crypto100.getText();
                Assert.assertTrue(crypto100Value.trim().matches("[A-Z0-9a-z ]{1,}"));

            }
        }
    }

    public static void applyFiltersCrypto() {
        //Click on Add Filter
        By addFilter = By.xpath("//button[text()='Add Filter']");
        waitUntilLocated(driver, 10, addFilter);

        //Set MarketCap to $1B - $10B
        validateLocAndClick(driver.findElement(By.xpath("//button[text()='Market Cap']")));
        validateLocAndClick(driver.findElement(By.xpath("//button[text()='$1B - $10B']")));
        validateLocAndClick(driver.findElement(By.xpath("//button[text()='Apply Filter']")));

        //Set Price Cap to $101 - $1000
        validateLocAndClick(driver.findElement(By.xpath("//button[text()='Price']")));
        validateLocAndClick(driver.findElement(By.xpath("//button[text()='$101 - $1,000']")));
        validateLocAndClick(driver.findElement(By.xpath("//button[text()='Apply Filter']")));

        //To Show results
        validateLocAndClick(driver.findElement(By.xpath("//button[text()='Show results']")));
        waitTo(2);

        //To Check filters are applied
        WebElement filtersApplied = driver.findElement(By.xpath("//button[text()='2 More Filters']"));
        Assert.assertTrue(filtersApplied.isDisplayed());
    }

    public static void checkRecordsDetail() {
        WebElement chkCryptoName;
        WebElement chkCryptoPrice;
        WebElement chkCryptoMarCap;

        List<WebElement> count = driver.findElements(By.xpath("//colgroup/following-sibling::tbody/tr"));
        for(int idx=1; idx <= count.size(); idx++) {

            //Check Crypto Name
            chkCryptoName = driver.findElement(By.xpath("(//colgroup/following-sibling::tbody/tr/td[3])["+idx+"]//p"));
            String cryptoName = chkCryptoName.getText();
            Assert.assertTrue(cryptoName.trim().matches("[A-Z0-9a-z ]{1,}"));

            //Check Crypto Price
            chkCryptoPrice = driver.findElement(By.xpath("(//colgroup/following-sibling::tbody/tr/td[4])["+idx+"]"));
            String cryptoPrice = chkCryptoPrice.getText().replaceAll("\\$","");
            Assert.assertTrue(Float.parseFloat(cryptoPrice) > 100 && Float.parseFloat(cryptoPrice)  <= 1000);

            //Check Crypto Market Cap
            chkCryptoMarCap = driver.findElement(By.xpath("(//colgroup/following-sibling::tbody/tr/td[8])["+idx+"]"));
            String cryptoMarCap = chkCryptoMarCap.getText().replaceAll("[$|,]","");
            Assert.assertTrue(Float.parseFloat(cryptoMarCap) > 1000000000F && Float.parseFloat(cryptoMarCap)  <= 10000000000F);

        }
    }

    public static void validateLocAndClick(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.click();
    }

    public static void waitUntilLocated(WebDriver driver, int time, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public static void closeAlert(WebDriver driver) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='gv-close']")));
        } catch (Exception ignored) {}

        By alert = xpath("//div[@class='gv-close']");
        waitUntilLocated(getDriver(), 20, alert);
    }

    public static void waitTo(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void showFilters() {

        waitTo(2);
        closeAlert(getDriver());
        By filters = xpath("(//button[text()='Filters'])[2]");
        waitUntilLocated(getDriver(), 10, filters);
    }
}
