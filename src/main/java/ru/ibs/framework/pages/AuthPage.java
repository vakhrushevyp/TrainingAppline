package ru.ibs.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {


    @FindBy(xpath = "//form[@id='login-form']//fieldset//input[@id='prependedInput']")
    WebElement inputLogin;
    @FindBy(xpath = "//form[@id='login-form']//input[@id='prependedInput2']")
    WebElement inputPass;
    @FindBy(xpath = "//form[@id='login-form']//button[@id='_submit']")
    WebElement loginButton;



    public AuthPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void authorization (String login, String password) {
        inputLogin.sendKeys(login);
        inputPass.sendKeys(password);
        loginButton.click();

        }

}
