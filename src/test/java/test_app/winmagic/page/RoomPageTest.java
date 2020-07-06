package test_app.winmagic.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomPageTest {
    AppiumDriver<MobileElement> driver;
    static MainPage mainPage;
    static RoomPage roomPage;

    @BeforeAll
    static void beforeAll(){
        roomPage = new MainPage().toSwitch();

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void switchRoom() {
//        assertTrue(driver.findElement(By.id("com.wingto.winmagic:id/device_item_layout")).getText().contains("吊炸天"));

    }

}
