package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectHotelPage extends BasePage {

	@FindBy(name = "radiobutton_0")
    private WebElement selectHotelRadioButton;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public SelectHotelPage(WebDriver driver) {
        super(driver);
    }

    public void selectHotel() {
        selectHotelRadioButton.click();
    }

    public BookingPage clickContinue() {
        continueButton.click();
        return new BookingPage(driver);
    }
}
