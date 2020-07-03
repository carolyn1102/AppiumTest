package test_webview.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TradePage extends BasePage {
    public TradePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private  final By sendPhone = By.id("phone-number");

    private final By sendCode = By.id("code");

    public TradePage openAccountForStockA() {
        click(byText("A股开户"));
//        sendKeys(sendPhone,"18688886666");
//        sendKeys(sendCode,"123456");
//        click(byText("立即开户"));
        driver.findElementById("phone-number").sendKeys("18888886666");
        driver.findElementById("code").sendKeys("123456");
        click(byText("立即开户"));
        return this;
    }

}
