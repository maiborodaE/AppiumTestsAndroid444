package tests;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Credentials.MenuButtonsCreden.*;
import static Credentials.PersAssignCreden.*;
import static Credentials.QuestItemsCreden.*;


public class PersonalAssig {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "My Phone");
        desiredCapabilities.setCapability("udid", "310072c8b3d92300"); //Gsamsung 5.1.1. tablet
//        desiredCapabilities.setCapability("udid", "6f9dea2f7d74"); //Xiaomi 7.1.2 N2G47H mobile

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "5.1.1");
        desiredCapabilities.setCapability("appPackage", "effie.app.com.effie");
        desiredCapabilities.setCapability("appActivity", "effie.app.com.effie.main.activities.LoginActivity");
        desiredCapabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }

    @Test
    public void sampleTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);

        //        Для 6го и 7го андроида:
//        MobileElement allowButton = (MobileElement) driver.findElementById(allowButtonID);
//            allowButton.click();
//            allowButton.click();
//            allowButton.click();


        //Login
        driver.findElement(By.id(loginInputID)).sendKeys("u0auto2@effie.ua");
        driver.findElement(By.id(pswrdInputID)).sendKeys("testPass");
        driver.findElement(By.id(loginByttonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(startDayButtonID))).click();


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


//      Модуль с поручениями:
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
        driver.findElementById(imageAddButtonID).click();
        driver.findElementByXPath(photoCHoiceButtonXPath).click();
        //Делаем фотку
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
//        Чек-бокс необходимости сделанного фото в выполнении поручения
        driver.findElement(By.id("effie.app.com.effie:id/checkNeedPhotoReport")).click();

//        кнопка "сохранения поручения"
        driver.findElementById("effie.app.com.effie:id/action_task_save").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageView");
//        Синхронизация поручений
        driver.findElementById("effie.app.com.effie:id/sync_tasks").click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
//        Выполнение поручения
        driver.findElementByXPath(editNewPAXPath).click();
        //        кнопка "редактирования поручения"
        driver.findElementById("effie.app.com.effie:id/action_edit_tasks").click();
        driver.findElementById("effie.app.com.effie:id/taskStatus").click();
        driver.findElementByXPath("//android.widget.TextView[@text = 'Закрыто']").click();
//        driver.findElementById("effie.app.com.effie:id/taskComments").sendKeys("Some comment");
        driver.findElementById("effie.app.com.effie:id/action_task_save").click();
        driver.findElementByAccessibilityId("Перейти вверх").click();
        driver.findElementById("effie.app.com.effie:id/sync_tasks").click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();


        System.out.println("Test Pers Assig pass");
        System.out.println(LocalDateTime.now());


    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
