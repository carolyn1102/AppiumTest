package test_webview.xueqiu.page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test_app.wework.page.Wework;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.MarketPage;

import static org.junit.jupiter.api.Assertions.*;

class TradePageTest {
    private static SnowBall snowBall;

    @BeforeAll
    static void beforeAll(){
        snowBall = new SnowBall();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void openAccountForStockA() {
        snowBall.trade().openAccountForStockA();
    }
}