package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

import static stepDefinitions.startWebDriver.getDriver;

public class Hooks {

    @Before("@FrontendTask")
    public void scenarioStart() {
        startWebDriver.initialize();
        getDriver().manage().deleteAllCookies();
    }

    @Before("@MobileTasks")
    public void beforeScenario(Scenario scenario) throws MalformedURLException {

        String rawFeatureName = scenario.getName();

//        AppiumServer.start();
        startMobileDriver.initializeAppium(rawFeatureName);
    }

    @After("@FrontendTask")
    public void scenarioEnd(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        startWebDriver.teardown();
    }

    @After("@MobileTasks")
    public void scenarioEndMob(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        startMobileDriver.teardown();
    }
}
