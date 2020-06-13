package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class CalendarPage extends BasePage {
    private By add =By.id("ee");
    private final By calendarName =By.id("ee_");
    private final By save = byText("保存");
    private final By calendarList = By.id("gug");

    public CalendarPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public CalendarPage addCalendar(String name) {
        click(add);
        sendKeys(calendarName, name);
        click(save);
        return this;
    }

    public List<String> getCalendar(){
        return driver.findElements(calendarList).stream().map(x->x.getText()).collect(Collectors.toList());
    }

    public CalendarPage delCalendar() {
        MobileElement element=driver.findElementsById("d48").get(1);
        final By del = byText("删除日历");
        final By delConfirm = byText("确认删除");
        element.click();
        click(del);
        click(delConfirm);
        return this;
    }
}
