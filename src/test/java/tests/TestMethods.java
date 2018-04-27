package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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
import static Credentials.PersAssignCreden.*;
import static Credentials.PersAssignCreden.syncPAbuttonID;
import static Credentials.QuestItemsCreden.*;
import static Credentials.QuestItemsCreden.finishQhID;
import static Credentials.QuestItemsCreden.seventhQiXPath;

public class TestMethods {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public TestMethods(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void PAfunctionalTEST() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //Login
        driver.findElement(By.id(loginInputID)).sendKeys("u0auto2@effie.ua");
        driver.hideKeyboard();
        driver.findElement(By.id(pswrdInputID)).sendKeys("testPass");
        driver.hideKeyboard();
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
        //        Синхронизация поручений
//        driver.findElementByXPath(fingerPoru4XPath).click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
//        Выполнение поручения
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editNewPAXPath))).click();
        //        кнопка "редактирования поручения"
        driver.findElementById("effie.app.com.effie:id/action_edit_tasks").click();
        driver.findElementById("effie.app.com.effie:id/action_task_close").click();
        driver.findElementById("effie.app.com.effie:id/input_comments").sendKeys("Some comment");
        driver.findElementById("effie.app.com.effie:id/photo_img").click();
        driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.ImageView[@resource-id = 'android:id/icon']").click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();


//        driver.findElementById("effie.app.com.effie:id/taskStatus").click();
//        driver.findElementByXPath("//android.widget.TextView[@text = 'Закрыто']").click();
//        driver.findElementById("effie.app.com.effie:id/taskComments").sendKeys("Some comment");
        driver.findElementByAccessibilityId("Перейти вверх").click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();


        System.out.println("Test Pers Assig pass");
        System.out.println(LocalDateTime.now());

    }

    public void VisitQItest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(By.id(loginInputID)).sendKeys("u0auto2@effie.ua");
        driver.hideKeyboard();
        driver.findElement(By.id(pswrdInputID)).sendKeys("testPass");
        driver.hideKeyboard();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View/android.widget.ImageView"))).click();

//        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageButton")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ImageButton' and ./parent::*[@id='route_menu_finger']]"))).click();

        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
        driver.findElement(By.id("effie.app.com.effie:id/tt_layout_clicker")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        Thread.sleep(7000);
//            Синхронизация добавленной ТТ
        MobileElement addpoint =  (MobileElement) driver.findElementByXPath(("//android.view.View/android.widget.ImageView"));
//        MobileElement addpoint =  driver.findElementByXPath(("//android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageButton"));

        addpoint.isEnabled();
        addpoint.isDisplayed();
        addpoint.click();

//        MobileElement addpoint = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageView");
//        MobileElement addpoint = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageView");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/sync_additional_points"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/btn_p"))).click();
        Thread.sleep(2000);
        //Возможно поиск по нумерации:
        MobileElement TTadded = (MobileElement) driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
//        MobileElement TTadded = driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@id='line_1_steps'] and ./*[@text='2']]] and ./*[./*[@id='tt_layout_clicker']]]"));
        TTadded.click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();

        System.out.println("Анкета логика данет с фото");
//    Первая анкета
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Анкета логика данет с фото (отчетность)']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        //Делаем фотку
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
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
        driver.findElement(By.id(okButtonID)).click();

        System.out.println("Анкета логика данет негативные кейсы ");

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
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        driver.findElement(By.id(okButtonID)).click();
        System.out.println("Анкета логика работы вопроса с разными форматами ответа");
//    Анкета с разными форматами ответов
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика работы вопроса с разными форматами ответа (отчетность)']"))).click();
//"ОК" для первой анкеты не нужен
        driver.findElement(By.id(okButtonID)).click();
//    Dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        driver.findElementById(inputAnswerID).sendKeys("In stock");
//        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]");
//        MobileElement el4 = (MobileElement) driver.findElementByXPath("//*[@text='В наличии']");
//        //android.widget.LinearLayout[contains(@text,'В нал')]
//        el4.click();
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//  QR code
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
//  Drobnoe
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
        driver.hideKeyboard();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        driver.hideKeyboard();
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

//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        driver.findElement(By.id(okButtonID)).click();

        driver.findElement(By.xpath("//android.widget.Button[@text = 'Завершение этапа']")).click();
        driver.findElement(By.id(okButtonID)).click();
//        Проверка на снятие GPS
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
        System.out.println("Test Visits pass");

//      Синхронизация(отправка)
        driver.findElementById(gamburgerMenuID).click();
        driver.findElementByXPath(syncMenuXPath).click();
        driver.findElementById(sendAllButtonID).click();
        driver.findElementById(syncButtonID).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successSyncTextXPath))).isDisplayed();
        driver.findElementById(okButtonID).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successSyncFilesXPath))).isDisplayed();
        driver.findElementById(okButtonID).click();
        System.out.println("Test Sync Send pass");
        System.out.println(LocalDateTime.now());

    }


    }

