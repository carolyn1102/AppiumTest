package com.test.selenium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSnowBall {
    private static AndroidDriver driver;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("udid","127.0.0.1:7555");
        desiredCapabilities.setCapability("deviceName", "MuMu emulator");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset",true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    // 添加三只股票
    public void addStock() {
        // 点击搜索
        driver.findElementById("com.xueqiu.android:id/home_search").click();
        // 点击去选股
        driver.findElementByXPath("//android.widget.TextView[@text='去选股']").click();
        // 选择已有的选股策略"美股"
        driver.findElementByXPath("//android.widget.TextView[@text='美股']").click();
        // 选择股票添加自选
        driver.findElementByXPath("//android.widget.TextView[@text='选择股票添加自选']").click();
        // 勾选前3个
        driver.findElementByXPath("//android.widget.TextView[@text='西连购物中心']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Gogo']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='LiveXLive Media']").click();
        // 点击"添加到"
        driver.findElementByXPath("//android.widget.TextView[@text='添加到(3)']").click();
        // 点击"确定"
        driver.findElementByXPath("//android.widget.TextView[@text='确定']").click();

        // 提示"添加成功"则断言成功
        String response = driver.findElementByXPath("//android.widget.Toast[@text='添加成功']").getText();
        assertEquals(response,"添加成功");

        // 点击行情菜单，断言新增的三只股票名称是否匹配
        driver.findElementByXPath("//android.widget.RelativeLayout[1]").click();
        String stockName1 = driver.findElementByXPath("//android.widget.TextView[@text='西连购物中心']").getText();
        String stockName2 = driver.findElementByXPath("//android.widget.TextView[@text='Gogo']").getText();
        String stockName3 = driver.findElementByXPath("//android.widget.TextView[@text='LiveXLive Media']").getText();
        assertEquals(stockName1,"西连购物中心");
        assertEquals(stockName2,"Gogo");
        assertEquals(stockName3,"LiveXLive Media");

    }

    @Test
    public void deleteStock() {
        driver.findElementById("com.xueqiu.android:id/iv_back").click();
        driver.findElementByAccessibilityId("转到上一层级").click();
        driver.findElementByXPath("//android.widget.TextView[@text='取消']").click();
        // 回到行情页
        driver.findElementByXPath("//android.widget.TextView[@text='行情']").click();
        // 点击编辑
        driver.findElementById("com.xueqiu.android:id/edit_group").click();
        // 点击全选
        driver.findElementById("com.xueqiu.android:id/check_all").click();
        // 点击取消关注
        driver.findElementById("com.xueqiu.android:id/cancel_follow").click();
        // 点击确定
        driver.findElementByXPath("//android.widget.TextView[@text='确定']").click();

        String response= driver.findElementByXPath("//android.widget.TextView[@text='该分组暂无股票']").getText();
        assertEquals(response,"该分组暂无股票");
    }

    @AfterAll
    public static void tearDown() {

        driver.quit();
    }
}
