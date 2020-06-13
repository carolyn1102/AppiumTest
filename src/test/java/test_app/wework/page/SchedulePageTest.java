package test_app.wework.page;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SchedulePageTest {

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
        assertTrue(wework.schedule().addSchedule("逛街", null).getSchedule(null).contains("逛街"));
    }

    @Order(2)
    @Test
    void get() {
        assertTrue(wework.schedule().addSchedule("吃粽子",null).getSchedule(null).contains("吃粽子"));
    }

    @Order(3)
    @Test
    void del() {
        assertFalse(wework.schedule().delSchedule().getSchedule(null).contains("逛街"));
    }
}