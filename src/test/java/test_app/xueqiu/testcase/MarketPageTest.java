package test_app.xueqiu.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.MarketPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketPageTest {
    static  MainPage mainPage;
    static MarketPage marketPage;
    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        marketPage=new MainPage().toStock();
    }

    @Test
    void add() {
        assertEquals(marketPage.addStock().getToast(),"添加成功");

    }

    @Test
    void del() {

        assertTrue(marketPage.delStock().getResponse().equals("该分组暂无股票"));

    }

}
