package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;

public class mobileRunSteps extends startMobileDriver {

    mobileScreens mob = new mobileScreens();

    @Given("Launch zoom app")
    public void launchZoomApp() {
        String home = "//android.widget.TextView[@text='Start or join a meeting']";
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(xpath(home)));
    }

    @And("Click Join a meeting")
    public void clkJoinMeeting() {
        mob.clickJoinMeeting();
    }

    @Then("Validate Join button is disabled")
    public void checkJoinButton1() {
        mob.checkJoinButtonDisabled();
    }

    @And("Enter {string} digits meeting id")
    public void meetingID(String id) {
        mob.enterMeetingID(id);
    }

    @Then("Validate Join button is enabled")
    public void checkJoinButton2() {
        mob.checkJoinButtonEnabled();
    }

    @And("Toggle on Turn off my video")
    public void turnVideo() {
        mob.turnOffMyVideo();
    }

    @Then("Click on Join")
    public void joinMeeting() {

        By joinBtn = By.xpath("//android.widget.Button[@text='Join']");
        mobileScreens.waitUntilLocated(joinBtn,null);
    }

    @When("Put the app in background")
    public void runAppInBackground() {
        ((AndroidDriver)driver).runAppInBackground(Duration.ofSeconds(5));
    }

    @And("then launch it back to foreground")
    public void putAppForeground() {
        ((AndroidDriver)driver).activateApp("us.zoom.videomeetings");
    }

    @Then("Validate the Invalid meeting Id text in pop up")
    public void validateTextPopUp() {
        mob.validateInldTextPopUp();
    }

    @Given("Launch LinkedIn app")
    public void launchLinkedInApp() {
        String home = "//android.widget.Button[@text='Join now']";
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(xpath(home)));
    }

    @When("Swipe left till last slide and verify the text on each one")
    public void swipeLeft() {
        mob.swipeLeftValidate();
    }

    @When("Login using correct credentials")
    public void login() {
        mob.loginLinkedInApp();
    }

}
