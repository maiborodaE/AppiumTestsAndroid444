//package tests;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import org.junit.Before;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import static Credentials.MenuButtonsCreden.*;
//
//public class TestMethods {
//    private AndroidDriver driver;
//    private WebDriverWait wait;
//
//    public TestMethods(AndroidDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.wait = wait;
//    }
//        public void login () {
//            //Login
//            driver.findElement(By.id(loginInputID)).
//                    sendKeys("u0auto2@effie.ua");
//            driver.findElement(By.id(pswrdInputID)).
//                    sendKeys("testPass");
//            driver.findElement(By.id(loginByttonID)).
//                    click();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(startDayButtonID))).click();
//
//        }
//
//
//    }