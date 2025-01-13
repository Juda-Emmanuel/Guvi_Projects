package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	private WebDriver driver;

    @FindBy(id = "username") 
    private WebElement usernameField;

    @FindBy(id = "password") 
    private WebElement passwordField;

    @FindBy(id = "signin2") 
    private WebElement signupButton;

	public SignUpPage(WebDriver driver2) {
		this.driver = driver;
	}

	public void SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignup() {
        signupButton.click();
    }
}
