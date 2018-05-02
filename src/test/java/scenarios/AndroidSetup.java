//package scenarios;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Properties;
//
//public class AndroidSetup {
//    protected AndroidDriver driver;
//
//    protected void prepareAndroidForAppium() throws MalformedURLException {
//        File appDir = new File("/Users/nishant/Development/AppiumDemo/apps");
//        File app = new File(appDir, "Flipkart.3.0.apk");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("device","Android");
//
//        //mandatory capabilities
//        capabilities.setCapability("310072c8b3d92300","Android");
//        capabilities.setCapability("platformName","Android");
//
//        //other caps
//        capabilities.setCapability("app", app.getAbsolutePath());
//        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//    @Test
//    public void helloTest()
//
//    {
//
//
//        String app_package_name = "com.flipkart.android:id/";
//        By userId = By.id(app_package_name + "user_id");
//        By password = By.id(app_package_name + "user_password");
//        By showPassword = By.id(app_package_name + "show_password");
//        By login_Button = By.id(app_package_name + "btn_login");
//
//        driver.findElement(userId).sendKeys("someone@testvagrant.com");
//        driver.findElement(password).sendKeys("testvagrant123");
//        driver.findElement(showPassword).click();
//        driver.findElement(login_Button).click();
//    }
////    {
////        File appDir = new File("/Users/Steve/Development/SampleApps");
////        File app = new File(appDir, "Flipkart.apk");
////        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("device","Android");
//////mandatory capabilities
////        capabilities.setCapability("0deviceName","Android");
////        capabilities.setCapability("platformName","Android");
////        capabilities.setCapability("udid", Properties.udid);
//
////other caps
////        capabilities.setCapability("app", app.getAbsolutePath());
////        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//
