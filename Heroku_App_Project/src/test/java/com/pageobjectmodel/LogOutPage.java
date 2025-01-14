package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

	private WebDriver driver;

	@FindBy(xpath = "//button[@id='logout']")
	private WebElement logoutButton;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLogout() {
		logoutButton.click();
	}

	public Boolean isLogoutButtonVisible() {
		return logoutButton.isDisplayed();
	}
}
