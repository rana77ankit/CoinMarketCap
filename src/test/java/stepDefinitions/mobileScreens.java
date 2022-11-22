package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class mobileScreens extends startMobileDriver {

    public void clickJoinMeeting() {
        //To click on 'Join a Meeting'
        By addFilter = By.xpath("//android.widget.Button[@text='Join a Meeting']");
        waitUntilLocated(addFilter, null);
    }

    public void checkJoinButtonDisabled() {
        //Validate Join button is disabled
        waitTillVisible("//android.widget.Button[@text='Join']");
        WebElement joinBtn = driver.findElement(By.xpath("//android.widget.Button[@text='Join']"));
        Assert.assertFalse(joinBtn.isEnabled());
    }

    public void enterMeetingID(String id) {
        By meetID = By.xpath("//android.widget.AutoCompleteTextView");
        waitUntilLocated(meetID, id);
    }

    public void checkJoinButtonEnabled() {
        //Validate Join button is enabled
        WebElement joinBtn = driver.findElement(By.xpath("//android.widget.Button[@text='Join']"));
        Assert.assertTrue(joinBtn.isEnabled());
    }

    public void turnOffMyVideo() {
        //Toggle on Turn off my video
        By toggle = By.xpath("//android.widget.TextView[@text=\"Don't Connect To Audio\"]/following-sibling::*");
        waitUntilLocated(toggle, null);
    }

    public void validateInldTextPopUp() {
        //Validate the Invalid meeting Id text in pop up
        By invldText = By.xpath("//android.widget.TextView");
        waitTillVisible(invldText.toString().replaceAll("By.xpath: ",""));

        WebElement errorMsg = driver.findElement(invldText);
        Assert.assertEquals(errorMsg.getText(),"Invalid meeting ID. Please check and try again.");
    }

    public static void waitUntilLocated(By locator, String value) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
        if(value != null)
            driver.findElement(locator).sendKeys(value);
    }

    public static void waitTillVisible(String path) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(xpath(path)));
    }

    public static void waitTo(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loginLinkedInApp() {

        By signIn = By.xpath("//android.widget.Button[@text='Sign in']");
        waitUntilLocated(signIn, null);
        waitTo(4);
    }

    public void swipeLeftValidate() {

        By home1 = By.xpath("//android.widget.ImageView[@content-desc='Connect to opportunity']");
        waitTillVisible(home1.toString().replaceAll("By.xpath: ",""));
        System.out.println("RRRRRRRR:"+driver.findElement(home1).getText());
        Assert.assertEquals(driver.findElement(home1).getText(),"Connect to opportunity");
    }
}
