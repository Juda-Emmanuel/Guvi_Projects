package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookingPage extends BasePage{

	@FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "address")
    private WebElement billingAddressField;

    @FindBy(id = "cc_num")
    private WebElement creditCardNumberField;

    @FindBy(id = "cc_type")
    private WebElement creditCardTypeDropdown;

    @FindBy(id = "cc_exp_month")
    private WebElement ccExpMonthDropdown;

    @FindBy(id = "cc_exp_year")
    private WebElement ccExpYearDropdown;

    @FindBy(id = "cc_cvv")
    private WebElement ccCvvField;

    @FindBy(id = "book_now")
    private WebElement bookNowButton;

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void enterGuestDetails(String firstName, String lastName, 
                                  String billingAddress, String ccNumber, 
                                  String ccType, String expMonth, String expYear, 
                                  String cvv) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        billingAddressField.sendKeys(billingAddress);
        creditCardNumberField.sendKeys(ccNumber);

        Select ccTypeDropdown = new Select(creditCardTypeDropdown);
        ccTypeDropdown.selectByVisibleText(ccType);

        Select expMonthDropdown = new Select(ccExpMonthDropdown);
        expMonthDropdown.selectByVisibleText(expMonth);

        Select expYearDropdown = new Select(ccExpYearDropdown);
        expYearDropdown.selectByVisibleText(expYear);

        ccCvvField.sendKeys(cvv);
    }

    public void clickBookNow() {
        bookNowButton.click();
    }
}
