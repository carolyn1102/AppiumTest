package test_webview.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TradePage extends BasePage {
    public TradePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        //用来确保交易页面加载成功了
        switchContext("WEBVIEW_");

        find(By.xpath("//div[h1='A股开户']"));
        switchWindowByTitle("实盘交易");
    }

    public TradePage openAccountForStockA() {
        click(By.xpath("//div[h1='A股开户']"));

        switchWindowByTitle("平安证券 极速开户");

        sendKeys(By.xpath("//input[contains(@placeholder,'手机号')]"), "18688886666");

        sendKeys(By.xpath("//input[contains(@placeholder,'验证')]"), "123456");

        click(By.xpath("//div[h1='立即开户']"));

        return this;
    }

}
