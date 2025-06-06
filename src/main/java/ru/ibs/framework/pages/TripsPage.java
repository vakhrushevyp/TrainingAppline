package ru.ibs.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TripsPage {



    public TripsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//h1[@class='oro-subtitle']")
   WebElement headerAllTrips;
    @FindBy(xpath = "//div/a[@title='Создать командировку']")
    WebElement createTripButton;



   public void waitHeader () {
       Assertions.assertTrue(headerAllTrips.isDisplayed());

   }

   public void createTrip() {
       createTripButton.click();
   }





}
