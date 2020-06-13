package test_app.xueqiu.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage{

    public SearchPage toSearch(){
        click(By.id("home_search"));
//        MobileElement el4 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
//        el4.click();
        return new SearchPage(driver);
    }

    public MarketPage toStock(){
        click(byText("行情"));
//        MobileElement el1= (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='行情']");
//        el1.click();
        return new MarketPage(driver);
    }

}
