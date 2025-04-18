package ru.ibs.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
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
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

    }


    @Test
    @Step ("Test 1")
    @DisplayName("Тест 1")


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

        WebElement openCompanyList = driver.findElement(By.xpath("//div/a[@id='company-selector-show']"));
        openCompanyList.click();

        WebElement company = driver.findElement(By.xpath("//div//span[contains(text(),'Укажите организацию')]"));
        company.click();


        WebElement companyInput = company.findElement(By.xpath("//div//input[@class='select2-input select2-focused']"));

        wait.until(ExpectedConditions.visibilityOf(companyInput));

        companyInput.sendKeys("Aplana");

        WebElement companySearchResult = driver.findElement(By.xpath("//div//span[(@class='select2-match')and(contains(text(),'Aplana'))]"));
        wait.until(ExpectedConditions.visibilityOf(companySearchResult));

        companySearchResult.click();

        WebElement checkBoxTickets = driver.findElement(By.xpath("//div//label[contains(text(),'Заказ билетов')]"));
        checkBoxTickets.click();

        WebElement arrivalCity = driver.findElement(By.xpath("//input[contains(@name,'arrivalCity')]"));
        arrivalCity.click();
        arrivalCity.sendKeys("Россия, Ижевск");

        WebElement depDatePlan = driver.findElement(By.xpath("//input[contains(@name,'departureDatePlan')and(@placeholder='Укажите дату')]"));
        depDatePlan.click();
        depDatePlan.sendKeys("12.03.2025");

        WebElement selectedDate = driver.findElement(By.xpath("//td[contains(@class,'current-day')]"));
        selectedDate.click();



        WebElement returnDatePlan = driver.findElement(By.xpath("//input[contains(@name,'returnDatePlan')and(@placeholder='Укажите дату')]"));
        returnDatePlan.click();
        returnDatePlan.sendKeys("28.03.2025");
        WebElement selectedDateTwo = driver.findElement(By.xpath("//td[contains(@class,'current-day')]"));
        selectedDateTwo.click();


        WebElement saveBtn = driver.findElement(By.xpath("//button[(@type='submit')and(contains(@class,'main-group'))]"));
        saveBtn.click();

        WebElement loader = driver.findElement(By.xpath("//div[@class='loader-content']"));
        wait.until(ExpectedConditions.invisibilityOf(loader));

        WebElement validatorKs = driver.findElement(By.xpath("//div//span[contains(text(),'Командированные сотрудники')]/../..//span[@class='validation-failed']"));
        WebElement validatorVs = driver.findElement(By.xpath("//div//span[contains(text(),'Внештатные сотрудники')]/../..//span[@class='validation-failed']"));

        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", validatorKs.getText(), "Текст валидации не отобразился");
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", validatorVs.getText(), "Текст валидации не отобразился");








        Thread.sleep(2000);


    }

    @AfterAll
    public static void afterAll() {

        driver.quit();
    }


}
