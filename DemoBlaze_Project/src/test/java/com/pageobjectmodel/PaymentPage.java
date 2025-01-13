package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	private WebDriver driver;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement cardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//*[contains(text(),'Purchase')]")
    private WebElement purchaseButton;

    @FindBy(xpath = "//p[contains(text(), 'Thank you for your purchase!')]")
    private WebElement successMessage;
    
    @FindBy(xpath = "//*[contains(text(),'OK')]")
    private WebElement okButton;

	public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillOrderDetails(String name, String country, String city, String card, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void clickPurchase() {
        purchaseButton.click();
    }
    
    public void clickOkBuuttron() {
    	okButton.click();

	}

    public boolean isPurchaseSuccessful() {
        try {
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false; 
        }
    }
}
