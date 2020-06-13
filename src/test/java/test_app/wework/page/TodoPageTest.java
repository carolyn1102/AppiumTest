package test_app.wework.page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoPageTest {

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

    @Test
    void add() {
        assertTrue(wework.todo().addToDo("18:30跑步").getTodo().contains("18:30跑步"));
    }

    @Test
    void get() {
        assertTrue(wework.todo().addToDo("23:00睡觉").getTodo().contains("23:00睡觉"));
    }

}