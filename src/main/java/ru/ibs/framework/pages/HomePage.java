package ru.ibs.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {




    @FindBy(xpath = "//h1[@class='oro-subtitle']")
     WebElement header;

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li")
    List<WebElement> mainMenu;

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li/ul/li/a/span/..")
    List<WebElement> subMenu;



    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void checkHeader(String headerText) {
        Assertions.assertEquals(headerText, header.getText(),"Текст заголовка не соответствует" );
    }

    public void selectMainMenu (String textMenu) {
        for (WebElement item : mainMenu) {
            if (item.getText().equalsIgnoreCase(textMenu)) {
                item.click();
                return;
            }

        }
        Assertions.fail("Пункт меню '" + textMenu + "' не найден");

    }

    public void selectSubMenu (String textSubMenu) {

        for (WebElement items: subMenu) {
            System.out.println(items.getText());
            if (items.getText().equalsIgnoreCase(textSubMenu)){
                items.click();
                return;
            }
         }
        Assertions.fail("Пункт подменю '" + textSubMenu + "' не найден");
    }


}
