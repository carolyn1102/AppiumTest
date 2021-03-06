package test_webview.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private final int timeOutInSecondsDefault = 60;
    //    AndroidDriver<MobileElement> driver;
    AppiumDriver<MobileElement> driver;
    //    IOSDriver
    WebDriverWait wait;
    String packageName;
    String activityName;

    public BasePage(String packageName, String activityName) {
        this.packageName = packageName;
        this.activityName = activityName;
        startApp(this.packageName, this.activityName);
    }

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSecondsDefault);
    }

    public void startApp(String packageName, String activityName){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "192.168.223.101:5555");
        desiredCapabilities.setCapability("appPackage", packageName);
        desiredCapabilities.setCapability("appActivity", activityName);
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("udid", "");
        desiredCapabilities.setCapability("chromedriverExecutable", "D:\\chromedriver\\chromedriver.exe");
//        desiredCapabilities.setCapability("dontStopAppOnReset", "true");
//        desiredCapabilities.setCapability("skipLogcatCapture", "true");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //todo: 等待优化
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeOutInSecondsDefault);
    }


    public void quit() {
        driver.quit();
    }


    public By byText(String text){
        return By.xpath("//*[@text='"+ text + "']");
    }
    public MobileElement find(By by) {
        return driver.findElement(by);
    }

    public MobileElement find(String text) {
        return driver.findElement(byText(text));
    }

    public void click(By by) {
        //todo: 异常处理
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void click(String text) {
        //todo: 异常处理
        find(text).click();
    }

    public void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    //todo:
    public void waitElement() {

    }

    //webview part
    public void switchContext(String name){
        driver.getContextHandles().forEach(context -> {
            if(context.contains(name)){
                driver.context(context);
            }
        });
    }

    //webview part
    public void switchWindowByTitle(String title){
        int count = 10;
        boolean isSuccess = false;
        while (!isSuccess && count-- >0){
            for(String window: driver.getWindowHandles()){
                driver.switchTo().window(window);
                if(driver.getTitle().contains(title)){
                    isSuccess = true;
                    break;
                }
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if(!isSuccess) System.out.println("切换窗口失败--->" + title);

    }
}
