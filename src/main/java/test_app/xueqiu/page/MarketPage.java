package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MarketPage {
    private AndroidDriver driver;
    private By nameLocator=By.id("com.xueqiu.android:id/tv_name");

    public MarketPage() {
    }

    public MarketPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public MarketPage addStock(){
        // 点击搜索
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/action_search");
        el2.click();

        // 点击去选股
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='去选股']");
        el3.click();

        // 选择已有的选股策略"美股"
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='美股']");
        el4.click();

        // 选择股票添加自选
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='选择股票添加自选']");
        el5.click();

        // 勾选元素组中的前3个

        MobileElement el6 = (MobileElement) driver.findElements(nameLocator).get(0);
        el6.click();

        MobileElement el7 = (MobileElement) driver.findElements(nameLocator).get(1);
        el7.click();

        MobileElement el8 = (MobileElement) driver.findElements(nameLocator).get(2);
        el8.click();

        // 点击"添加到"
        MobileElement el9 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='添加到(3)']");
        el9.click();

        // 点击"确定"
        MobileElement el10 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='确定']");
        el10.click();

        return this;

    }

    // 添加后查看返回
    public String getToast() {
        MobileElement el16 = (MobileElement) driver.findElementByXPath("//android.widget.Toast[@text='添加成功']");
        return el16.getText();
    }

    public MarketPage delStock(){
        driver.findElementById("com.xueqiu.android:id/iv_back").click();
        driver.findElementByAccessibilityId("转到上一层级").click();
        driver.findElementByXPath("//android.widget.TextView[@text='取消']").click();
        // 回到行情页
        driver.findElementByXPath("//android.widget.TextView[@text='行情']").click();
        // 点击编辑
        MobileElement el12 = (MobileElement) driver.findElementById("com.xueqiu.android:id/edit_group");
        el12.click();

        // 点击全选
        MobileElement el13 = (MobileElement) driver.findElementById("com.xueqiu.android:id/check_all");
        el13.click();

        // 点击取消关注
        MobileElement el14 = (MobileElement) driver.findElementById("com.xueqiu.android:id/cancel_follow");
        el14.click();

        // 点击确定
        MobileElement el15 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='确定']");
        el15.click();

        return this;
    }
    // 删除后查看返回
    public String getResponse(){
        MobileElement el11 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='该分组暂无股票']");
        return el11.getText();
    }
}
