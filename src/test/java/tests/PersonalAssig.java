package tests;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Credentials.MenuButtonsCreden.skipButtonID;

public class PersonalAssig {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "My Phone");
        desiredCapabilities.setCapability("udid", "310072c8b3d92300");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "5.1.1");
        desiredCapabilities.setCapability("appPackage", "effie.app.com.effie");
        desiredCapabilities.setCapability("appActivity", "effie.app.com.effie.main.activities.LoginActivity");
        desiredCapabilities.setCapability("noReset", false);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }

    @Test
    public void sampleTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);

        MobileElement el1 = (MobileElement) driver.findElementById("effie.app.com.effie:id/input_login_la");
        el1.sendKeys("u0auto2@effie.ua");
        MobileElement el2 = (MobileElement) driver.findElementById("effie.app.com.effie:id/input_password_la");
        el2.sendKeys("testPass");
        driver.findElementById("effie.app.com.effie:id/btn_login_la").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/buttonStartDay"))).click();


        //Synchronization
        driver.findElement(By.id("effie.app.com.effie:id/step_button")).click();
        Thread.sleep(2000);
        //Only Text
        driver.findElement(By.id("effie.app.com.effie:id/sync_receive_text")).click();
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        Thread.sleep(20000);
        //Wait for sync
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/btn_p"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Завершение этапа']"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();


        MobileElement el10 = (MobileElement) driver.findElementById("Open navigation drawer");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[@text = 'Мои поручения']");
        el11.click();
//      Содать поручение:
        MobileElement fingerPoru4 = (MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageView");
        fingerPoru4.click();
        MobileElement el13 = (MobileElement) driver.findElementById("effie.app.com.effie:id/fab_add_task");
        el13.click();
        driver.findElementById("effie.app.com.effie:id/input_title").sendKeys("Some Title");
        driver.findElementById("effie.app.com.effie:id/taskAddress").click();
        driver.findElementById("effie.app.com.effie:id/checkBoxAddAs").click();
        driver.findElementById("effie.app.com.effie:id/fab_confirm").click();
        driver.findElementById("effie.app.com.effie:id/textTaskToDate").click();
        MobileElement el14 = (MobileElement) driver.findElementByAccessibilityId("09 апреля 2018");
        el14.click();
        driver.findElementById(skipButtonID).click();
        driver.findElementById("effie.app.com.effie:id/fab_save_task").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageView");
//        Синхронизация поручений
        driver.findElementById("effie.app.com.effie:id/sync_tasks").click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        driver.findElementById("effie.app.com.effie:id/assignmentTitle").click();
        driver.findElementById("effie.app.com.effie:id/fab_edit").click();
        driver.findElementById("effie.app.com.effie:id/taskStatus").click();
        driver.findElementByXPath("//android.widget.TextView[@text = 'Закрыто']").click();
//        driver.findElementById("effie.app.com.effie:id/taskComments").sendKeys("Some comment");
        driver.findElementById("effie.app.com.effie:id/fab_save_task").click();
        driver.findElementByAccessibilityId("Перейти вверх").click();
        driver.findElementById("effie.app.com.effie:id/sync_tasks").click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();


        System.out.println("Test pass");
















    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
