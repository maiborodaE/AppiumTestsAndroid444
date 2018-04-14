package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumTest {

    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> driver = null;
        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "310072c8b3d92300"); //Gsamsung 5.1.1. tablet
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "5.1.1");
        caps.setCapability("appPackage", "effie.app.com.effie");
        caps.setCapability("appActivity", "effie.app.com.effie.main.activities.LoginActivity");
        caps.setCapability("noReset", false);
        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        //Added 5 seconds wait so that the app loads completely before starting with element identification
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WebDriverWait wait = new WebDriverWait(driver, 120);

        PersonalAssig personalAssig = new PersonalAssig();
            personalAssig.sampleTest();


}

}