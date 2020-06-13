package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SchedulePage extends BasePage {
    //todo:多版本app、多平台的app 定位符通常有差别
    private final By taskName = By.id("b2k");
    private final By save = byText("保存");
    private final By taskList = By.id("gg_");
    private By add =By.id("gym");
    // 选择日期
    MobileElement element=driver.findElementsById("bd9").get(18);

    private By del=By.id("bfi");
    private final By delConfirm=By.id("b_o");

    public SchedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SchedulePage addSchedule(String name, String time){
        element.click();
        click(add);
        sendKeys(taskName, name);
        click(save);
        return this;
    }

    public List<String> getSchedule(String day){
        if(day!=null){
            //todo:选择日期
        }
        return driver.findElements(taskList).stream().map(x->x.getText()).collect(Collectors.toList());
    }

    public SchedulePage delSchedule() {
        element.click();
        click(taskList);
        click(del);
        click(delConfirm);
        return this;
    }

}
