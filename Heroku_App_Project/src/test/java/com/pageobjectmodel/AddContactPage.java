package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//button[@id='add-contact']")
	protected WebElement addContactButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;
    
    @FindBy(xpath = "//input[@id='birthdate']")
    private WebElement birtheDateField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='street1']")
    private WebElement streetAddress1;
    
    @FindBy(xpath = "//input[@id='street2']")
    private WebElement streetAddress2;
    
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;
    
    @FindBy(xpath = "//input[@id='stateProvince']")
    private WebElement stateField;

    @FindBy(xpath = "//input[@id='postalCode']")
    private WebElement postalCodeField;
    
    @FindBy(xpath = "//input[@id='country']")
    private WebElement countryField;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void addContactButton() {
    	addContactButton.click();
	}

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    
    public void enterBirthDate(String birthDate) {
    	birtheDateField.sendKeys(birthDate);

	}

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void enterStreet1(String street1) {
    	streetAddress1.sendKeys(street1);
    }

    public void enterStreet2(String street2) {
    	streetAddress2.sendKeys(street2);
    }
    
    public void enterCity(String city) {
    	cityField.sendKeys(city);
	}
    
    public void enterState(String state) {
    	stateField.sendKeys(state);
	}
    
    public void enterPostalCode(String postalCode) {
    	postalCodeField.sendKeys(postalCode);
	}
    
    public void enterCountry(String country) {
    	countryField.sendKeys(country);
	}

    public void clickSubmit() {
        submitButton.click();
    }
}
