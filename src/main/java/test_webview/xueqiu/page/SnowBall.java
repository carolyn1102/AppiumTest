package test_webview.xueqiu.page;

import org.openqa.selenium.By;

public class SnowBall extends BasePage {
    public SnowBall() {
        super("com.xueqiu.android", ".view.WelcomeActivityAlias");
    }

    // 交易页面
    public TradePage trade() {
        click(By.xpath("//*[@text='交易']"));
        return new TradePage(driver);
    }
}
