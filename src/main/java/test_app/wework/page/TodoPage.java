package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class TodoPage extends BasePage {
    private final By todoName= By.id("b2k");
    private final By save = byText("保存");
    private final By todoList = By.id("gw9");
    private By add =By.id("gym");

    public TodoPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public TodoPage addToDo(String name) {
        // 新建一个待办
        click(add);
        sendKeys(todoName,name);
        click(save);
        return this;
    }

    public List<String> getTodo(){
        return driver.findElements(todoList).stream().map(x->x.getText()).collect(Collectors.toList());
    }

}