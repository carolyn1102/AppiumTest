package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.List;
import java.util.stream.Collectors;

public class ReportPage extends BasePage{

    public ReportPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public ReportPage addDailyReport(String workContent) {
        click(byText("日报"));
        By daily =By.xpath("//android.widget.EditText[1]");
        sendKeys(daily,workContent);
//        final By toReport = By.xpath("//*[@content-desc='请选择汇报对象']");
//        MobileElement element=driver.findElementsById("fq2").get(2);
//        click(toReport);
//        click(byText("企业通讯录"));
//        element.click();
//        click(By.xpath("//*[contains(@text,'确定')]"));

        // 下滑找到提交按钮
        SwipeDown((AndroidDriver) driver);
        MobileElement element =driver.findElementByAccessibilityId("提交");
        element.click();

        // 日报提交后自动跳转至详情页，此时需要点击返回按钮回到我提交的日报列表页
        By detailBack=By.id("gyb");
        click(detailBack);
        return this;
    }

    public List<String> getReport() {

        click(byText("记录"));
        By submitBymyself = byText("我提交的");
        click(submitBymyself);

        // 用wait会报错 java.lang.IllegalMonitorStateException
//        synchronized (driver) {
//            try {
//                driver.manage().timeouts().wait(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待5秒，然后滑动");

        // 上滑刷新
        SwipeUp((AndroidDriver) driver);
        System.out.println("已执行上滑刷新操作");

        By reportList = By.className("android.widget.TextView");

        return driver.findElements(reportList).stream().map(x->x.getText()).collect(Collectors.toList());
    }

    // 下滑
    public void SwipeDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height - 100))
                .moveTo(PointOption.point(width / 2, 100)).release().perform();
    }

    // 上滑刷新
    public void SwipeUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
//        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, 480))
                .moveTo(PointOption.point(width / 2, 275)).release().perform();
    }


    public ReportPage delDailyReport() {
        click(byText("记录"));
        By submitBymyself = byText("我提交的");
        click(submitBymyself);
        By reportList = By.id("dse");
        click(reportList);
        By delMenu=By.id("gym");
        click(delMenu);
        click(byText("删除"));
        click(byText("确定"));

        return this;
    }

    public ReportPage addWeeklyReport(String workContent) {
        click(byText("周报"));
        By weekly =By.xpath("//android.widget.EditText[1]");
        sendKeys(weekly,workContent);

        // 下滑找到提交按钮
        SwipeDown((AndroidDriver) driver);
        MobileElement element =driver.findElementByAccessibilityId("提交");
        element.click();

        // 周报提交后自动跳转至详情页，此时需要点击返回按钮回到我提交的周报列表页
        By detailBack=By.id("gyb");
        click(detailBack);

        return this;
    }

    public ReportPage delWeeklyReport() {
        click(byText("记录"));
        By submitBymyself = byText("我提交的");
        click(submitBymyself);
        By reportList = By.id("dse");
        click(reportList);
        By delMenu=By.id("gym");
        click(delMenu);
        click(byText("删除"));
        click(byText("确定"));

        return this;
    }

 }
