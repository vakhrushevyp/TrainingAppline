package ru.ibs.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreateTripPage {





    public CreateTripPage(WebDriver driver) {
        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//h1[@class='user-name']")
    WebElement createTripHeader;
    @FindBy(xpath = "//div/div[contains(@class,'control-label')]//following::div")
    List<WebElement> list;
    @FindBy(xpath = "//div//option")
    List<WebElement> options;
    @FindBy(xpath = "//div/a[@id='company-selector-show']")
    WebElement openCompanyList;
    @FindBy(xpath = "//div//span[@class='select2-chosen']")
    WebElement choiceCompany;
    @FindBy(xpath = "//div//input[@class='select2-input select2-focused']")
    WebElement inputCompany;
    @FindBy(xpath = "//div//span[(@class='select2-match')]")
    WebElement resultCompany;
    @FindBy(xpath = "//div[@class='oro-clearfix']/label")
    List<WebElement> checkbox;
    @FindBy(xpath = "//div/input[contains(@name,'City')]")
    List<WebElement> city;
    @FindBy(xpath = "//input[contains(@name,'DatePlan')and(@placeholder='Укажите дату')]")
    List<WebElement> datePlans;
    @FindBy(xpath = "//td[contains(@class,'current-day')]")
    WebElement currentDate;

    @FindBy(xpath = "//button[(@type='submit')and(contains(@class,'main-group'))]")
    WebElement btnSave;

    @FindBy(xpath = "//div[@class='loader-content']")
    WebElement loader;

    @FindBy(xpath = "//div//span[contains(text(),'Командированные сотрудники')]/../..//span[@class='validation-failed']")
    WebElement validatorKs;
    @FindBy(xpath = "//div//span[contains(text(),'Внештатные сотрудники')]/../..//span[@class='validation-failed']")
    WebElement validatorVs;





    public void checkHeader (String headerText) {
        Assertions.assertEquals(headerText, createTripHeader.getText(), "Заголовок не соответствует");
    }

    public void selectElement (String elementText) {
        for (WebElement item: list ) {
            if (item.getText().contains(elementText)) {
                item.click();
                return;
            }

        }
        Assertions.fail("Элемент '" + elementText + "' не найден на странице");

    }

    public void selectOption (String optionText) {
        for (WebElement item: options ) {
            if (item.getText().contains(optionText)) {
                item.click();
                return;
            }

        }
        Assertions.fail("Элемент '" + optionText + "' не найден на странице");

    }

    public void openCompanyList () {
        openCompanyList.click();
    }

    public void selectCompany (String companyName)  {
        choiceCompany.click();
        inputCompany.sendKeys(companyName);

        if (resultCompany.isDisplayed()) {
            resultCompany.click();
        }
        Assertions.assertEquals(companyName, choiceCompany.getText(),
                "Не удалось выбрать компанию, выбрана: " + choiceCompany.getText());

    }


    public void selectCheckbox (String text) {
        for (WebElement item: checkbox             ) {
            if (item.getText().contains(text)) {
                item.click();
                return;
            }

        }
        Assertions.fail("Чекбокс '" + text + "' не найден на странице");
    }

    public void enterCity (int i, String text) {
        city.get(i).click();
        city.get(i).sendKeys(text);

    }

    public void enterPlanDates (String date1, String date2) {
        datePlans.get(0).click();
        datePlans.get(0).sendKeys(date1);
        currentDate.click();
        datePlans.get(1).click();
        datePlans.get(1).sendKeys(date2);
        currentDate.click();

    }

    public void buttonSave () throws InterruptedException {
        btnSave.click();

    }

    public void checkErrorMessage () {

        Assertions.assertAll(
                "Текст валидации не отобразился или не совпадает",
        ()-> Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", validatorKs.getText()),
        ()-> Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", validatorVs.getText())
        );



    }



//        WebElement validatorKs = driver.findElement(By.xpath("//div//span[contains(text(),'Командированные сотрудники')]/../..//span[@class='validation-failed']"));
//        WebElement validatorVs = driver.findElement(By.xpath("//div//span[contains(text(),'Внештатные сотрудники')]/../..//span[@class='validation-failed']"));
//
//        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", validatorKs.getText(), "Текст валидации не отобразился");
//        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", validatorVs.getText(), "Текст валидации не отобразился");
//
//







}
