package ru.ibs.tests.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTests {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeAll
    public void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        /*
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        options.setBinary("C:\\Users\\VAKHRUSHEV\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        */
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://training.appline.ru/user/login");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

    }



    @AfterAll
    public void afterAll() {
        driver.quit();
    }

}
