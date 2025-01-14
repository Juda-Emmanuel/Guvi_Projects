package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactPage {

	private WebDriver driver;

	@FindBy(xpath = "//tr[5]")
	private WebElement selectContact;
	
	@FindBy(id = "edit-contact")
	private WebElement editContactButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement updateFirstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement updateLastNameField;
    
    @FindBy(xpath = "//input[@id='birthdate']")
    private WebElement updateBirtheDateField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement updateEmailField;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement updatePhoneField;

    @FindBy(xpath = "//input[@id='street1']")
    private WebElement updateStreetAddress1;
    
    @FindBy(xpath = "//input[@id='street2']")
    private WebElement updateStreetAddress2;
    
    @FindBy(xpath = "//input[@id='city']")
    private WebElement updateCityField;
    
    @FindBy(xpath = "//input[@id='stateProvince']")
    private WebElement updateStateField;

    @FindBy(xpath = "//input[@id='postalCode']")
    private WebElement updatePostalCodeField;
    
    @FindBy(xpath = "//input[@id='country']")
    private WebElement updateCountryField;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement updateSubmitButton;
    
    @FindBy(xpath = "//button[@id='return']")
    private WebElement retunToContactButton;

    public EditContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void selectContact() {
    	selectContact.click();
	}

    public void editContactButton() {
    	editContactButton.click();
	}
    
    public void editFirstName(String updatedFirstName) {
    	updateFirstNameField.clear();
    	updateFirstNameField.sendKeys(updatedFirstName);
    }

    public void editLastName(String updatedLastName) {
    	updateLastNameField.clear();
    	updateLastNameField.sendKeys(updatedLastName);
    }
    
    public void editBirthDate(String updatedBirthDate) {
    	updateBirtheDateField.clear();
    	updateBirtheDateField.sendKeys(updatedBirthDate);

	}

    public void editEmail(String updatedEmail) {
    	updateEmailField.clear();
    	updateEmailField.sendKeys(updatedEmail);
    }

    public void editPhone(String updatedPhone) {
    	updatePhoneField.clear();
    	updatePhoneField.sendKeys(updatedPhone);
    }

    public void editStreet1(String updatedStreet1) {
    	updateStreetAddress1.clear();
    	updateStreetAddress1.sendKeys(updatedStreet1);
    }

    public void editStreet2(String updatedStreet2) {
    	updateStreetAddress2.clear();
    	updateStreetAddress2.sendKeys(updatedStreet2);
    }
    
    public void editCity(String updatedCity) {
    	updateCityField.clear();
    	updateCityField.sendKeys(updatedCity);
	}
    
    public void editState(String updatedState) {
    	updateStateField.clear();
    	updateStateField.sendKeys(updatedState);
	}
    
    public void editPostalCode(String updatedPostalCode) {
    	updatePostalCodeField.clear();
    	updatePostalCodeField.sendKeys(updatedPostalCode);
	}
    
    public void editCountry(String updatedCountry) {
    	updateCountryField.clear();
    	updateCountryField.sendKeys(updatedCountry);
	}

    public void clickUpdate() {
    	updateSubmitButton.click();
    }
    
    public void returntoContact() {
    	retunToContactButton.click();
	}
}
