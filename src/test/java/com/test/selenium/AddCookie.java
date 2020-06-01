package com.test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCookie {
    @Test
    void chrome() {
        String url="https://work.weixin.qq.com/wework_admin/frame";
        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().deleteAllCookies();

        driver.manage().addCookie(new Cookie("pgv_pvi","8063145984"));
        driver.manage().addCookie(new Cookie("RK","ifWV2"));
        driver.manage().addCookie(new Cookie("ptcz","c7c511911536c06c7adbf6f91797437958c9598a77285137ee48484f6a9db941"));
        driver.manage().addCookie(new Cookie("pgv_pvid","5115005408"));
        driver.manage().addCookie(new Cookie("_ga","GA1.2.1639755099.1587120050"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d","1587120050,1587376131,1587376153"));
        driver.manage().addCookie(new Cookie("pac_uid","0_5ebe3e9d77417"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan","zh"));
        driver.manage().addCookie(new Cookie("wwrtx.ref","direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid","59909438553825"));
        driver.manage().addCookie(new Cookie("ww_rtkey","1094022182"));
        driver.manage().addCookie(new Cookie("_gid","GA1.2.1402838610.1590976852"));
        driver.manage().addCookie(new Cookie("wwrtx.vst","tY9n7yq_4VpGNBqbf7bdqAtYsMboVhrFnRwMi5e6ZA2Anfz8lv89yeEKNz5yAxKVe-AkgIed352eMQr24_eek0kZxgonTTfDv_xgxEAXxUU5BhTx6qOqGkI_h_jlg5pY8SqCKMC1IaCxQPsT6aFB0WwoqguMJbYMvYkvvy0iNhqAhM10dH8euFEJyf53ms9Z4D-3WCQnGLLoBdw7oShJJs5z2YYR1qZiapL69XZKBf7vtOK9Tnfbk0fYfKbpUmv37ND05iyIyPg1hvkdJrc7Xw"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st","a1811328"));
        driver.manage().addCookie(new Cookie("wwrtx.sid","yRFghLhlW4pq9dqYLaBFc6xrlzIML_qsivd-B4X2VtVkIhTd7NXcT30V6zs1pe8T"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype","1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid","1970325006124173"));
        driver.manage().addCookie(new Cookie("wxpay.vid","1688851958549946"));
        driver.manage().addCookie(new Cookie("wwrtx.vid","1688851958549946"));
        driver.manage().addCookie(new Cookie("wwrtx.logined","true"));

        System.out.println(driver.manage().getCookies());
        driver.get(url);
    }
}

