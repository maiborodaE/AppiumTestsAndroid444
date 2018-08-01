package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static Credentials.MenuButtonsCreden.*;
import static Credentials.QuestItemsCreden.*;
import static Credentials.QuestItemsCreden.commentID;
import static Credentials.QuestItemsCreden.secondQiXPath;

public class TestForPhoto {


    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "My Phone");
//        desiredCapabilities.setCapability("udid", "30041c9e8a5bc200"); // samsung 4.4.4
//        desiredCapabilities.setCapability("udid", "310057f6b8f48300"); // samsung 4.4.4
        desiredCapabilities.setCapability("udid","10.8.168.105:7777"); //wifi asnova

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "4.4.4");
        desiredCapabilities.setCapability("appPackage", "effie.app.com.effie");
        desiredCapabilities.setCapability("appActivity", "effie.app.com.effie.main.activities.LoginActivity");
        desiredCapabilities.setCapability("noReset", true);
//                desiredCapabilities.setCapability("autoAcceptAlerts", true);


        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
//        URL remoteUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }
    @Test
    public void photoSTOshtuk() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(By.id(loginByttonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета PG (отчетность)']"))).click();
        driver.findElement(By.id(okButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Промо-дисплеи']"))).click();
        int i = 1;

       while (i <100) {
            //Делаем фотку
            driver.findElement(By.id(photoImageButtonID)).click();
//        driver.findElement(By.id(cameraTypeID)).click();
            Thread.sleep(3000);
//        driver.findElement(By.id(makePhotoID)).click();
            (new TouchAction(driver)).tap(293, 958).perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
            i++;
        }

    }
}