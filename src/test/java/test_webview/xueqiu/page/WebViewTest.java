package test_webview.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebViewTest {
    private AndroidDriver driver;

    @BeforeEach
    public void setup(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "192.168.161.101:5555");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("udid", "");
        desiredCapabilities.setCapability("chromedriverExecutable", "D:/chromedriver/chromedriver.exe");
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

    }

    @Test
    public void webview_native() {
        driver.findElement(By.xpath("//*[@text='交易']")).click();
        driver.findElement(By.xpath("//*[@text='基金开户']")).click();
    }

    @Test
    public void webview_web() throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='交易']")).click();
        for (int i = 0; i < 2; i++) {
            driver.getContextHandles().forEach(context -> System.out.println(context.toString()));
            Thread.sleep(500);
        }
        driver.context(driver.getContextHandles().toArray()[1].toString());

        driver.getWindowHandles().forEach(window -> {
            System.out.println(window);
            System.out.println(driver.getTitle());
            driver.switchTo().window(window);
            System.out.println(driver.getPageSource());
        });

//        driver.getWindowHandles().stream().filter(win->{
//            driver.switchTo().window(win);
//            return driver.getTitle().contains("实盘交易");
//        });

        Object[] array = driver.getWindowHandles().toArray();
        driver.switchTo().window(array[array.length - 1].toString());

        driver.findElement(By.xpath("//div[h1='A股开户']")).click();

    }
}
