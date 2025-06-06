package ru.ibs.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.ibs.framework.pages.AuthPage;
import ru.ibs.framework.pages.CreateTripPage;
import ru.ibs.framework.pages.HomePage;
import ru.ibs.framework.pages.TripsPage;
import ru.ibs.tests.base.BaseTests;

public class TrainingApplineTest extends BaseTests {


    @Test
    @DisplayName("Тест 1")

    public void test() throws InterruptedException {

        AuthPage authPage = new AuthPage(driver);
        HomePage homePage = new HomePage(driver);
        TripsPage tripsPage = new TripsPage(driver);
        CreateTripPage createTripPage = new CreateTripPage(driver);

        authPage.authorization("Taraskina Valeriya", "testing");
        homePage.checkHeader("Панель быстрого запуска");
        homePage.selectMainMenu("Расходы");
        homePage.selectSubMenu("Командировки");
        tripsPage.waitHeader();
        tripsPage.createTrip();
        createTripPage.checkHeader("Создать командировку");
        createTripPage.selectElement("Выберите подразделение");
        createTripPage.selectOption("Отдел внутренней разработки");
        createTripPage.openCompanyList();
        createTripPage.selectCompany("Aplana");
        createTripPage.selectCheckbox("Заказ билетов");
        createTripPage.enterCity(1,"Россия, Ижевск");
        createTripPage.enterPlanDates("06.06.2025", "12.06.2025");
        createTripPage.buttonSave();
        createTripPage.checkErrorMessage();


        Thread.sleep(2000);


    }




}
