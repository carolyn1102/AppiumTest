package com.test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestSelenium {
    WebDriver driver;

    @Test
    public void testSelenium() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        //利用chromedriver控制chrome
        driver = new ChromeDriver(options);
        driver.findElement(By.xpath("//*[@id=\'_hmt_click\']/div[1]/div[4]/div[2]/a[1]/div/span[1]")).click();
        System.out.println(driver.manage().getCookies());

        // chrome远程debug模式打开（其他网页全部关闭），然后登录至待测页面，获取cookie并保存至cookie.txt文本内
        try {
            FileWriter fileWriter = new FileWriter("cookie.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : driver.manage().getCookies()) {
                bufferedWriter.write(cookie.getName() + ';' +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" +
                        cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
