package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "My Phone");
//        desiredCapabilities.setCapability("udid", "310072c8b3d92300"); //Gsamsung 5.1.1. tablet
//        desiredCapabilities.setCapability("udid", "52003f78ec665421"); //Samsung 7.0 J7 Mobile
                desiredCapabilities.setCapability("udid", "920106db4844234a"); //Samsung 5.1.1. MOBILE Small


//        desiredCapabilities.setCapability("udid", "92012a9704bc154a"); //Samsung SM-J320H 5.1.1. MOBILE

//        desiredCapabilities.setCapability("udid", "6f9dea2f7d74"); //Xiaomi 7.1.2 N2G47H mobile
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "5.1.1");
        desiredCapabilities.setCapability("appPackage", "effie.app.com.effie");
        desiredCapabilities.setCapability("appActivity", "effie.app.com.effie.main.activities.LoginActivity");
        desiredCapabilities.setCapability("noReset", false);
//                desiredCapabilities.setCapability("autoAcceptAlerts", true);


        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }


    @Test
    public void visitQI() throws InterruptedException {

        TestMethods testMethods = new TestMethods((AndroidDriver) driver, new WebDriverWait(driver, 20));
        testMethods.VisitQItest();
    }
    @Test
    public void personalAssTests() throws InterruptedException {

        TestMethods testMethods = new TestMethods((AndroidDriver) driver, new WebDriverWait(driver, 20));
        testMethods.PAfunctionalTEST();
    }


}