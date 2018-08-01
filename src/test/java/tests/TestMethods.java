package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static Credentials.MenuButtonsCreden.*;
import static Credentials.MenuButtonsCreden.backButtonAccID;
import static Credentials.PersAssignCreden.*;
import static Credentials.PersAssignCreden.syncPAbuttonID;
import static Credentials.QuestItemsCreden.*;
import static Credentials.QuestItemsCreden.eighthQiXPath;

public class TestMethods {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public TestMethods(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void PAfunctionalTEST() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        //Login
        driver.findElement(By.id(loginInputID)).sendKeys("u0auto2@effie.ua");
//        driver.hideKeyboard();
        driver.findElement(By.id(pswrdInputID)).sendKeys("testPass");
//        driver.hideKeyboard();
        driver.findElement(By.id("effie.app.com.effie:id/checkBoxSavePass")).click();
        driver.findElement(By.id(loginByttonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(startDayButtonID))).click();


        //Synchronization
        driver.findElement(By.id("effie.app.com.effie:id/step_button")).click();
        Thread.sleep(2000);
        //Принять данные для начала работы
        driver.findElement(By.id("effie.app.com.effie:id/sync_receive_full_option")).click();
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        Thread.sleep(20000);
        //Wait for sync
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Завершение этапа']"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();


//      Модуль с поручениями:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id((gamburgerMenuID)))).click();
        driver.findElementByXPath(PAmenuXPath).click();
//      Содать поручение:
        driver.findElementByXPath(fingerPoru4XPath).click();
        driver.findElementById(addPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/input_title").sendKeys("Some Title");
        driver.findElementById("effie.app.com.effie:id/taskAddress").click();
        driver.findElementById("effie.app.com.effie:id/checkBoxAddAs").click();
        driver.findElementById("effie.app.com.effie:id/fab_confirm").click();
        driver.findElementById("effie.app.com.effie:id/textTaskToDate").click();
        driver.findElementById(skipButtonID).click();
        driver.findElementById(imageAddButtonID).click();
        driver.findElementByXPath(photoCHoiceButtonXPath).click();
        //Делаем фотку
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
//        Чек-бокс необходимости сделанного фото в выполнении поручения
        driver.findElement(By.id("effie.app.com.effie:id/checkNeedPhotoReport")).click();

//        кнопка "сохранения поручения"
        driver.findElementById("effie.app.com.effie:id/action_task_save").click();
        //        Синхронизация поручений
//        driver.findElementByXPath(fingerPoru4XPath).click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();

//     ПЕРЕХОД НА МАРШРУТ
        driver.findElementByAccessibilityId(backButtonAccID).click();

        //Добавление ТТ в маршрут
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View/android.widget.ImageView"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
        driver.findElement(By.id("effie.app.com.effie:id/tt_layout_clicker")).click();
//        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.id("effie.app.com.effie:id/fab_confirm")).click();
        Thread.sleep(7000);
//            Синхронизация добавленной ТТ
        MobileElement addpoint =  (MobileElement) driver.findElementByXPath(("//android.view.View/android.widget.ImageView"));

        addpoint.isEnabled();
        addpoint.isDisplayed();
        addpoint.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/sync_additional_points"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();
        Thread.sleep(2000);
        //Возможно поиск по нумерации:
        MobileElement TTadded = (MobileElement) driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
        TTadded.click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();

        System.out.println("Выполнения поручения");
//    Шаг-поручения
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Поручения на торговую точку']")).click();




//        Выполнение поручения
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editNewPAXPath))).click();
        //        кнопка "выполнить поручения"
        driver.findElementById("effie.app.com.effie:id/action_task_close").click();
        driver.findElementById("effie.app.com.effie:id/input_comments").sendKeys("Some comment");
        driver.findElementById("effie.app.com.effie:id/photo_img").click();
//        Delaem foto:
//        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(3000);
//        driver.findElement(By.id(makePhotoID)).click();
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        driver.findElementByXPath(fingerPoru4XPath).click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();


        System.out.println("Test Pers Assig pass");
        System.out.println(LocalDateTime.now());

    }

    public void VisitQItest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        driver.findElement(By.id(loginInputID)).sendKeys("u0auto2@effie.ua");
//        driver.hideKeyboard();
        driver.findElement(By.id(pswrdInputID)).sendKeys("testPass");
//        driver.hideKeyboard();
        driver.findElement(By.id("effie.app.com.effie:id/checkBoxSavePass")).click();
        driver.findElement(By.id(loginByttonID)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(startDayButtonID))).click();

        //Synchronization
        driver.findElement(By.id("effie.app.com.effie:id/step_button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        Thread.sleep(20000);
        //Wait for sync
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Завершение этапа']"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        //Etap Marshrut
//Добавление ТТ в маршрут
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View/android.widget.ImageView"))).click();
      Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
        driver.findElement(By.id("effie.app.com.effie:id/tt_layout_clicker")).click();
        driver.findElement(By.id("effie.app.com.effie:id/fab_confirm")).click();
        Thread.sleep(7000);
//            Синхронизация добавленной ТТ
        MobileElement addpoint =  (MobileElement) driver.findElementByXPath(("//android.view.View/android.widget.ImageView"));
        addpoint.isEnabled();
        addpoint.isDisplayed();
        addpoint.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/sync_additional_points"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();
        Thread.sleep(2000);
        //Возможно поиск по нумерации:
        MobileElement TTadded = (MobileElement) driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
        TTadded.click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
//        Этап "ВИЗИТ"
//    Шаг-поручения(СКИП)
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Поручения на торговую точку']")).click();
        driver.findElementByAccessibilityId(backButtonAccID).click();
        System.out.println("Анкета логика данет с фото");
//    Первая анкета
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Анкета логика данет с фото (отчетность)']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        //Делаем фотку
        driver.findElement(By.id(photoImageButtonID)).click();
//        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(3000);
//        driver.findElement(By.id(makePhotoID)).click();
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        //Закрыли категорию вопроса
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//    Второй вопрос
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        driver.findElement(By.id(answerNetID)).click();
        driver.findElement(By.id(commentID)).sendKeys("Some Test Comment");
        driver.hideKeyboard();
        Thread.sleep(1000);
        driver.findElement(By.xpath(secondQiXPath)).click();
        Thread.sleep(1000);
//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        System.out.println("Анкета логика данет негативные кейсы ");
//    Вторая анкета: Анкета негативные кейсы данет
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика данет негативные кейсы (отчетность)']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
        driver.findElement(By.id(commitButtonID)).click();
        driver.findElement(By.id(answerNetID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
        driver.findElement(By.id(commitButtonID)).click();
        driver.findElement(By.id(commentID)).sendKeys("Some Test Comment");
//        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        System.out.println("С фото Анкета логика работы вопроса с разными форматами ответа");
//    Анкета с разными форматами ответов
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'С фото Анкета логика работы вопроса с разными форматами ответа (отчетность)']"))).click();
//    Dropdown
        System.out.println("Dropdown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        driver.findElementById(inputAnswerID).sendKeys("In stock");
//        driver.hideKeyboard();
        //Делаем фотку
        driver.findElement(By.id(photoImageButtonID)).click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//  QR code
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        driver.findElement(By.id(photoImageButtonID)).click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
//        driver.hideKeyboard();
//  Drobnoe
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
        driver.findElement(By.id(photoImageButtonID)).click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
//        driver.hideKeyboard();

//  Date
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementById(skipButtonID);
        el3.click();
        driver.findElement(By.id(photoImageButtonID)).click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
//  Text
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        driver.hideKeyboard();
        driver.findElement(By.id(photoImageButtonID)).click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
//  Procent
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(allID))).sendKeys("100");
        driver.findElement(By.id(countID)).sendKeys("50");
        driver.findElement(By.xpath("//android.widget.EditText[@text = '50%']")).isDisplayed();
        driver.findElement(By.id(okButtonID)).click();
        driver.findElement(By.id(photoImageButtonID)).click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
//    INT
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
//        driver.hideKeyboard();
        driver.findElement(By.id(photoImageButtonID)).click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();
        //    YesNo
        System.out.println("YesNo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eighthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        driver.findElement(By.id(photoImageButtonID)).click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(293, 958).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eighthQiXPath))).click();
//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//    Анкета с разными форматами ответов
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика работы вопроса с разными форматами ответа (отчетность)']"))).click();
//    Dropdown
        System.out.println("Dropdown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        driver.findElementById(inputAnswerID).sendKeys("In stock");
//        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//  QR code
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        driver.hideKeyboard();
//  Drobnoe
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
//        driver.hideKeyboard();

//  Date
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        Thread.sleep(2000);
        MobileElement el35 = (MobileElement) driver.findElementById(skipButtonID);
        el35.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
//  Text
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
//        driver.hideKeyboard();
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
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();

 //    YesNo
        System.out.println("YesNo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eighthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eighthQiXPath))).click();


//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Завершение этапа']")).click();
//        Проверка на снятие GPS
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/ok"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
        System.out.println("Test Visits pass");



//      Синхронизация(отправка)
        driver.findElementById(gamburgerMenuID).click();
        driver.findElementByXPath(syncMenuXPath).click();
        driver.findElementById(sendAllButtonID).click();
        driver.findElementById(syncButtonID).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();

        System.out.println("Test Sync Send pass");
        System.out.println(LocalDateTime.now());

    }

    }

