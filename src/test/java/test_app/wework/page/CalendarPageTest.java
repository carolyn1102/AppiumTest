package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalendarPageTest {

    AppiumDriver<MobileElement> driver;
    private static Wework wework;

    @BeforeAll
    static void beforeAll(){
        wework = new Wework();

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Order(1)
    @Test
    void add() {
        assertTrue(wework.calendar().addCalendar("2020新日历").getCalendar().contains("2020新日历"));
        wework.calendarBack();
    }

    @Order(2)
    @Test
    void get() {
        assertTrue(wework.calendar().addCalendar("2021新日历").getCalendar().contains("2021新日历"));
        wework.calendarBack();
    }

    @Order(3)
    @Test
    void del() {
        assertFalse(wework.calendar().delCalendar().getCalendar().contains("2020新日历"));
    }
}