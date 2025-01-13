package com.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	@FindBy(id = "signin2")
	private WebElement signupButton;

	@FindBy(xpath = "//a[@id='login2']")
	private WebElement loginButton;

	@FindBy(id = "nameofuser")
	private WebElement welcomeUserText;

	@FindBy(xpath = "//a[@id='nava']//img")
	private WebElement siteLogo;

	@FindBy(className = "list-group-item")
	private List<WebElement> categories;

	@FindBy(className = "nav-link")
	private List<WebElement> menuOptions;
	
	@FindBy(id = "logout2") 
    private WebElement logOut;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	public void clickSignup() {
		signupButton.click();
	}

	public void clickLogin() {
		loginButton.click();
	}

	public boolean isSignupButtonVisible() {
		return signupButton.isDisplayed();
	}

	public boolean isLoginButtonVisible() {
		return loginButton.isDisplayed();
	}

	public void isWelcomeUserDisplayed() {
		boolean displayed = welcomeUserText.isDisplayed();
		System.out.println("Welcome User Text is Visible " + displayed);
	}

	public List<WebElement> allCategoryVisible() {
		return categories;

	}

	public void printWebElements() {
		for (WebElement categories : categories) {
			System.out.println(categories.getText());
		}
	}

	public List<WebElement> allMenuOptions() {
		return menuOptions;
	}
	
	public void printMenuWebElements() {
		for (WebElement menuOptions : menuOptions) {
			System.out.println(menuOptions.getText());
		}
	}

	public void isSiteLogoVisible() {
		boolean displayed = siteLogo.isDisplayed();
		System.out.println("Site LOGO is Visible" + displayed);

	}
	
	public void logOutFuntion() {
		logOut.click();

	}
}
