package test_app.wework.page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class Wework extends BasePage {
    public Wework() {
        super("com.tencent.wework", ".launch.LaunchSplashActivity");
    }

    // 日程页面
    public SchedulePage schedule() {
        click(By.xpath("//*[@text='日程']"));
        return new SchedulePage(driver);
    }

    // 待办页面
    public TodoPage todo() {
        click(By.xpath("//*[contains(@text,'待办')]"));
        return new TodoPage(driver);
    }

    // 日历页面
    public CalendarPage calendar() {
        click(By.xpath("//*[@text='日程']"));
        click(By.id("gyr"));
        return new CalendarPage(driver);
    }

    // 日历新增成功之后，点击左上角返回按钮，才能继续增加日历
    public CalendarPage calendarBack() {
        click(By.id("gyb"));
        return new CalendarPage(driver);
    }

    // 汇报页面
    public ReportPage report() {
        click(By.xpath("//*[@text='工作台']"));
        // 下滑找到汇报菜单
        SwipeDown((AndroidDriver) driver);
        click(By.xpath("//*[@text='汇报']"));
        return new ReportPage(driver);
    }

//    // 上滑
//    public ReportPage SwipeUp(AndroidDriver driver) {
//        Dimension size = driver.manage().window().getSize();
//        int height = size.height;
//        int width = size.width;
//        new TouchAction(driver).longPress(PointOption.point(width / 2, 100))
//                .moveTo(PointOption.point(width / 2, height - 100)).release()
//                .perform();
//        return new ReportPage(driver);
//    }

    // 下滑
    public ReportPage SwipeDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .press(PointOption.point((int)(width*0.5), (int)(height*0.5)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
                .moveTo(PointOption.point((int)(width*0.5), (int)(height*0.1))).release().perform();
        return new ReportPage(driver);
    }

//    // 左滑
//    public ReportPage SwipeLeft(AndroidDriver driver) {
//        Dimension size = driver.manage().window().getSize();
//        int height = size.height;
//        int width = size.width;
//        new TouchAction(driver)
//                .longPress(PointOption.point(width - 100, height / 2))
//                .moveTo(PointOption.point(100, height / 2)).release().perform();
//        return new ReportPage(driver);
//    }
//
//    // 右滑
//    public ReportPage SwipeRight(AndroidDriver driver) {
//        Dimension size = driver.manage().window().getSize();
//        int height = size.height;
//        int width = size.width;
//        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
//                .moveTo(PointOption.point(width - 100, height / 2)).release()
//                .perform();
//        return new ReportPage(driver);
//    }

    // 日报提交成功之后，点击记录左上角返回按钮回到主界面，才能继续执行下一个case
    public ReportPage reportListBack() {
        By back = By.id("gyb");
        click(back);
        return new ReportPage(driver);
    }
}
