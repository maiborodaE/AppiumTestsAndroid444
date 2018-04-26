//package tests;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.By;
//import org.testng.annotations.*;
//import java.net.URL;
//import java.net.MalformedURLException;
//import java.util.logging.Level;
//
//public class TestAndroid712 {
//        private String reportDirectory = "reports";
//        private String reportFormat = "xml";
//        private String testName = "LoginTest";
//        protected AndroidDriver<AndroidElement> driver = null;
//
//        DesiredCapabilities dc = new DesiredCapabilities();
//
//        @BeforeMethod
//        public void setUp() throws MalformedURLException {
//            dc.setCapability("reportDirectory", reportDirectory);
//            dc.setCapability("reportFormat", reportFormat);
//            dc.setCapability("testName", testName);
//            dc.setCapability(MobileCapabilityType.UDID, "92012a9704bc154a");
//            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "effie.app.com.effie");
//            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".main.activities.LoginActivity");
//            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//            driver.setLogLevel(Level.INFO);
//        }
//
//        @Test
//        public void testLoginTest() {
//            driver.unlockDevice();
//            driver.startActivity("effie.app.com.effie", ".main.activities.LoginActivity");
//            driver.findElement(By.xpath("//*[@id='input_login_la']")).sendKeys("u0mc1@ipland.com.ua");
//            driver.hideKeyboard();
//            driver.findElement(By.xpath("//*[@id='input_password_la']")).sendKeys("testPass");
//            driver.hideKeyboard();
//            driver.findElement(By.xpath("//*[@text='Вход']")).click();
//            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='buttonStartDay']")));
//            driver.findElement(By.xpath("//*[@id='buttonStartDay']")).click();
//        }
//
//        @AfterMethod
//        public void tearDown() {
//            driver.quit();
//        }
//    }
//}
