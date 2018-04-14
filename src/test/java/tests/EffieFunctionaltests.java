package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import static Credentials.MenuButtonsCreden.*;
import static Credentials.PersAssignCreden.*;
import static Credentials.QuestItemsCreden.*;
public class EffieFunctionaltests {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> driver = null;
//        WebDriverWait wait = new WebDriverWait(driver, 3);


        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "310072c8b3d92300"); //Gsamsung 5.1.1. tablet
//        caps.setCapability("udid", "30041c9e8a5bc200"); // samsung 4.4.4
//        caps.setCapability("udid", "B5GBB18130152285"); //huawey 6.0

//        int device = 444;
//        int device = 511;
//        caps.setCapability("udid", "10.8.168.37:7777"); //Give Device wifiAsnova of your mobile phone
//        caps.setCapability("udid", "192.168.43.40:4444"); //Give Device wifiMezu of your mobile phone
//        caps.setCapability("udid", "10.0.3.232:4444"); //Give Device wi seleniumcamp of your mobile phone


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


//        driver.manage().timeouts().implicitlyWait(60,  TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 120);

//        Для 6го андроида:
//        MobileElement allowButton =  driver.findElement(By.id(allowButtonID));
//            allowButton.click();
//            allowButton.click();
//            allowButton.click();
//


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
        //Etap Marshrut
//Добавление ТТ в маршрут
//Для 5го андроида:
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageButton")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
            driver.findElement(By.id("effie.app.com.effie:id/tt_layout_clicker")).click();
            driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
//            Синхронизация добавленной ТТ
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/" +
                    "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/" +
                    "android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageButton"))).click();
            driver.findElement(By.id("effie.app.com.effie:id/sync_additional_points")).click();
            driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/btn_p"))).click();
            Thread.sleep(2000);
        //Возможно поиск по нумерации:
        MobileElement TTadded = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/" +
                "android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/" +
                "android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
        TTadded.click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();

        System.out.println("Первая анкета");
//    Первая анкета
    driver.findElement(By.xpath("//android.widget.Button[@text = 'Анкета логика данет с фото (отчетность)']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
    //Делаем фотку
    driver.findElement(By.id(photoImageButtonID)).click();
//    driver.findElement(By.id(cameraTypeID)).click();
    Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
    //Закрыли категорию вопроса
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//    Второй вопрос
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
    driver.findElement(By.id(answerNetID)).click();
    driver.findElement(By.id(commentID)).sendKeys("Some Test Comment");
    driver.findElement(By.xpath(secondQiXPath)).click();
//  Завершение анкеты
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
    driver.findElement(By.id(okButtonID)).click();

        System.out.println("Вторая анкета");

//    Вторая анкета: Анкета негативные кейсы данет
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика данет негативные кейсы (отчетность)']"))).click();
    driver.findElement(By.id(okButtonID)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
    driver.findElement(By.id(okButtonID)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
    driver.findElement(By.id(commitButtonID)).click();
    driver.findElement(By.id(answerNetID)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
    driver.findElement(By.id(okButtonID)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
    driver.findElement(By.id(commitButtonID)).click();
    driver.findElement(By.id(commentID)).sendKeys("Some Test Comment");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
    driver.findElement(By.id(okButtonID)).click();
        System.out.println("Третья анкета");
//    Анкета с разными форматами ответов
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика работы вопроса с разными форматами ответа (отчетность)']"))).click();
//"ОК" для первой анкеты не нужен
                driver.findElement(By.id(okButtonID)).click();
//    Dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        driver.findElementById(inputAnswerID).sendKeys("In stock");
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]");
        el4.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//  QR code
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
//  Drobnoe
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
//  Date
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("09 апреля 2018");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById(skipButtonID);
        el3.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc = '09 апреля 2018']"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(skipButtonID)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
//  Text
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
//  Procent
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(allID))).sendKeys("100");
        driver.findElement(By.id(countID)).sendKeys("50");
        driver.findElement(By.xpath("//android.widget.EditText[@text = '50%']")).isDisplayed();
        driver.findElement(By.id(okButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
//    INT
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();

//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        driver.findElement(By.id(okButtonID)).click();

        driver.findElement(By.xpath("//android.widget.Button[@text = 'Завершение этапа']")).click();
        driver.findElement(By.id(okButtonID)).click();
//        Проверка на снятие GPS
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();


        System.out.println("Test Visits pass");
        System.out.println(LocalDateTime.now());

}


    }
