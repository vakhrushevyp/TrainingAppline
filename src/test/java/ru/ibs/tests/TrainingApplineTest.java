package ru.ibs.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrainingApplineTest {


    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        /*
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
      options.setBinary("C:\\Users\\VAKHRUSHEV\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        */
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://training.appline.ru/user/login");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

    }


    @Test
    public void test() throws InterruptedException {

        WebElement loginForm = driver.findElement(By.xpath("//form[@id='login-form']//fieldset"));
        loginForm.findElement(By.xpath(".//input[@id='prependedInput']")).sendKeys("Taraskina Valeriya");
        loginForm.findElement(By.xpath(".//input[@id='prependedInput2']")).sendKeys("testing");
        loginForm.findElement(By.xpath(".//button[@id='_submit']")).click();

        WebElement header = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));

        Assertions.assertEquals("Панель быстрого запуска", header.getText(), "Текст заголовка не соответствует");

        WebElement menuRashody = driver.findElement(By.xpath("//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']"));
        menuRashody.click();

        WebElement subMenuRashody = menuRashody.findElement(By.xpath("./../following-sibling::*//li/a/span[text()='Командировки']"));
        subMenuRashody.click();

        WebElement headerAllTrips = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));

        wait.until(ExpectedConditions.visibilityOf(headerAllTrips));

        WebElement createTripButton = driver.findElement(By.xpath("//div/a[@title='Создать командировку']"));
        createTripButton.click();

        WebElement createTripHeader = driver.findElement(By.xpath("//h1[@class='user-name']"));
        wait.until(ExpectedConditions.visibilityOf(createTripHeader));

        Assertions.assertEquals("Создать командировку", createTripHeader.getText(), "Заголовок не соответствует");

        WebElement selectSubdivision = driver.findElement(By.xpath("//div/span[contains(text(),'Выберите подразделение')]/.."));
        selectSubdivision.click();

        WebElement selectSubdivisionElement = driver.findElement(By.xpath("//div/span[contains(text(),'Выберите подразделение')]/..//option[contains(text(), 'Отдел внутренней разработки')]"));
        selectSubdivisionElement.click();





        Thread.sleep(2000);


    }

    @AfterAll
    public static void afterAll() {

        driver.quit();
    }


}
