package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import static Credentials.QuestItemsCreden.*;

public class QuestItems {

        public static void main(String[] args) throws InterruptedException {
//private  AppiumDriver<MobileElement> driver;
//    public void login() throws InterruptedException {

        AppiumDriver<MobileElement> driver = null;

//    public void setUp() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 120);

        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "310072c8b3d92300");
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


//    public void validateHomeScreenTest() throws InterruptedException {


        //Login
        driver.findElement(By.id("effie.app.com.effie:id/input_login_la")).clear();
        driver.findElement(By.id("effie.app.com.effie:id/input_login_la")).sendKeys("u0auto2@effie.ua");
        driver.findElement(By.id("effie.app.com.effie:id/input_password_la")).sendKeys("testPass");
        driver.findElement(By.id("effie.app.com.effie:id/btn_login_la")).click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/buttonStartDay"))).click();


        //Synchronization
        driver.findElement(By.id("effie.app.com.effie:id/step_button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/sync_receive_text")).click();
        //След степ , когда "ок" только 1
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        Thread.sleep(20000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/btn_p"))).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();

        //Возможно поиск по нумерации:
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/" +
                "android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/" +
                "android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout")).click();

        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();

        //Set anketu
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Анкета логика данет с фото (отчетность)']")).click();

//Test
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'флагтест']")).click();
        MobileElement requiredComment = driver.findElement(By.id(starQuestsID));
        requiredComment.isDisplayed();
//        driver.findElement(By.id(daNetVipadalkaID)).click();
        //Set NET
        driver.findElement(By.xpath(answerNetID)).click();
        requiredComment.isDisplayed();
        //Comment obyaz
        driver.findElement(By.id(commentAnswerID)).sendKeys("some comment");
        try {
            MobileElement requiredComment1 = driver.findElement(By.id(starQuestsID));
        } catch (NoSuchElementException e) {
// Element wasn't found. Do something here
            System.out.println("Вопрос теперь обязательный");
        }
//Test

//        driver.findElement(By.id(daNetVipadalkaID)).click();
        driver.findElement(By.xpath(answerDaID)).click();
        driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageButton")).click();
            driver.findElement(By.id("MENUID_CAMERA_MODE")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("MENUID_SHUTTER")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.sec.android.app.camera:id/okay"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/action_preview_done"))).click();
            //okButton
            driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text = 'Завершение этапа']")).click();
            driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
        }}
