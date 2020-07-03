package test_app.winmagic.page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class MainPage extends BasePage {
    public RoomPage toSwitch(){
        System.out.println("右滑打开抽屉");
        SwipeRight((AndroidDriver) driver);
        click(byText("吊炸天"));
        return new RoomPage(driver);
    }

    // 右滑拉开首页左侧栏
    public RoomPage SwipeRight(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        new TouchAction(driver).longPress(PointOption.point(20, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release()
                .perform();
        return new RoomPage(driver);
    }
}
