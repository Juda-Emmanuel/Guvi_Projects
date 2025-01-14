package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisplayContactPage {

	private WebDriver driver;

	@FindBy(xpath = "//tr[5]")
	private WebElement contactDisplay;
	
    @FindBy(id = "contact-first-name")
    private WebElement firstName;

    @FindBy(id = "contact-last-name")
    private WebElement lastName;

    @FindBy(id = "contact-email")
    private WebElement email;

    @FindBy(id = "contact-phone")
    private WebElement phone;

    @FindBy(id = "contact-company")
    private WebElement company;

    @FindBy(id = "contact-birthday")
    private WebElement birthday;

    @FindBy(id = "edit-button")
    private WebElement editButton;

    @FindBy(id = "delete-button")
    private WebElement deleteButton;

    public DisplayContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPhone() {
        return phone.getText();
    }

    public String getCompany() {
        return company.getText();
    }

    public String getBirthday() {
        return birthday.getText();
    }

    public void clickEdit() {
        editButton.click();
    }

    public void clickDelete() {
        deleteButton.click();
    }

	public Boolean isContactDisplayed(String string) {
		return contactDisplay.isDisplayed();
	}

}
