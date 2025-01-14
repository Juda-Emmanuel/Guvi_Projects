package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(id = "signup")
    private WebElement signUpButton;

    @FindBy(id = "submit")
    private WebElement loginSubmitButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public void clickLogin() {
        loginSubmitButton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
}
