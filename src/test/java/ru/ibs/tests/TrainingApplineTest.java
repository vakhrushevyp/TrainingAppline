package ru.ibs.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.ibs.framework.pages.AuthPage;
import ru.ibs.framework.pages.HomePage;
import ru.ibs.tests.base.BaseTests;

public class TrainingApplineTest extends BaseTests {


    @Test
    @DisplayName("Тест 1")

    public void test() throws InterruptedException {

        AuthPage authPage = new AuthPage(driver);
        HomePage homePage = new HomePage(driver);



        authPage.authorization("Taraskina Valeriya", "testing");
        homePage.checkHeader("Панель быстрого запуска");
        homePage.selectMainMenu("Расходы");
        homePage.selectSubMenu("Командировки");


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




}
