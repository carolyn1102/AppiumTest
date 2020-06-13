package test_app.wework.page;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReportPageTest {
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
    void addDailyReport() {
        assertTrue(wework.report().addDailyReport("日报20200612").getReport().contains("今日工作：日报20200612"));
        wework.reportListBack();
    }

    @Order(2)
    @Test
    void delDailyReport() {
        assertFalse(wework.report().delDailyReport().getReport().contains("今日工作：日报20200612"));
        wework.reportListBack();
    }

    @Order(3)
    @Test
    void addWeeklyReport() {
        assertTrue(wework.report().addWeeklyReport("周报20200612").getReport().contains("本周工作：周报20200612"));
        wework.reportListBack();
    }

    @Order(4)
    @Test
    void delWeeklyReport() {
        assertFalse(wework.report().delWeeklyReport().getReport().contains("本周工作：周报20200612"));
    }
}