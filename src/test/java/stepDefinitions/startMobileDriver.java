package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class startMobileDriver {

    public static AppiumDriver driver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static void initializeAppium(String checkApp) throws MalformedURLException {

        String currAppPackage = null, currAppActivity = null;
        if(checkApp.contains("Zoom")) {
            currAppPackage = BaseClass.prop.getProperty("appPackage1");
            currAppActivity = BaseClass.prop.getProperty("appActivity1");
        } else if(checkApp.contains("LinkedIn")) {
            currAppPackage = BaseClass.prop.getProperty("appPackage2");
            currAppActivity = BaseClass.prop.getProperty("appActivity2");
        }

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, BaseClass.prop.getProperty("mobile"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, BaseClass.prop.getProperty("platform"));
        capabilities.setCapability("noReset", BaseClass.prop.getProperty("noReset"));
        //capabilities.setCapability(MobileCapabilityType.APP, BaseClass.prop.getProperty("app"));
        capabilities.setCapability("appPackage", currAppPackage);
        capabilities.setCapability("appActivity", currAppActivity);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, BaseClass.prop.getProperty("platform_version"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", "true");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void teardown() {
        driver.quit();
    }
}
