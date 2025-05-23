package ru.ibs.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {

    WebDriver driver;

    @FindBy(xpath = "//form[@id='login-form']//fieldset")
    WebElement loginForm;


        public AuthPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void authorization (String login, String password) {
        loginForm.findElement(By.xpath(".//input[@id='prependedInput']")).sendKeys(login);
        loginForm.findElement(By.xpath(".//input[@id='prependedInput2']")).sendKeys(password);
        loginForm.findElement(By.xpath(".//button[@id='_submit']")).click();
        }


}
