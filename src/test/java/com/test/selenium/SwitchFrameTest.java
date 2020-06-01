package com.test.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SwitchFrameTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.testclass.cn/test_html/frame/frameset.html");
        driver.manage().window().maximize();
    }

    @Order(0)
    @Test
    public void switchLeftFrame() throws InterruptedException {
        /*一、定位页面最左侧的Frame：
        1.首先定位页面最左边的Frame；
        2.获取最左侧Frame中内容；
        3.通过条件判断获取的内容是否复核预期结果；
        4.点击界面按钮,弹出Alert,获取Alert,并且接受Alert;*/

        driver.switchTo().frame("leftframe");
        String text = driver.findElement(By.xpath("/html/body/p")).getText();
        System.out.println(text);
        assert text.contains("www.testclass.cn");

        driver.findElement(By.xpath("/html/body/input")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

    }

    @Order(1)
    @Test
    public void switchMiddleFrame() throws InterruptedException {
        /*二、定位页面最中间的Frame：
        1.从最左侧的Frame中跳转到最外层的页面；
        2.定位页面中间的Frame；
        3.获取页面中间Frame中的内容；
        4.通过条件判断获取的内容是否复核预期结果；
        5.在中间页面input框中输入内容；
        6.点击提交,弹出Alert,获取Alert,并且接受Alert；*/
        driver.switchTo().parentFrame();
        driver.switchTo().frame("middleframe");
        String text=driver.findElement(By.xpath("/html/body/p[1]")).getText();
        System.out.println(text);
        assert text.contains("html");

        driver.findElement(By.xpath("//*[@id='text']")).clear();
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("test");

        driver.findElement(By.xpath("//*[@id='button']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }


    @Order(2)
    @Test
    public void switchRightFrame() throws InterruptedException {
        /*三、定位页面最右边的Frame：
        1.从中间的Frame中跳转到最外层的页面；
        2.定位到页面最右边的Frame；
        3.获取页面最右边Frame中的内容；
        4.通过条件判断获取的内容是否复核预期结果；
        5.选择测试类型：安全测试。*/
        driver.switchTo().defaultContent();
        driver.switchTo().frame("rightframe");
        String text=driver.findElement(By.xpath("/html/body/p")).getText();
        System.out.println(text);
        assert text.contains("软件测试");
        driver.findElement(By.xpath("//*[@id='security_test']")).click();
        Thread.sleep(3000);
        System.out.println("==========================");

    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
