package com.pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteContactPage {

	private WebDriver driver;

    @FindBy(xpath = "//button[@id='delete']")
    private WebElement deleteContactButton;

    @FindBy(id = "cancel-delete-button")
    private WebElement cancelDeleteButton;

    public DeleteContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isConfirmationDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        return wait.until(ExpectedConditions.visibilityOf(deleteContactButton)).isDisplayed();
    }
    
    public void deleteContactButton() {
    	deleteContactButton.click();
	}

    public void confirmDelete() {
    	driver.switchTo().alert().accept();
    }

    public void cancelDelete() {
        driver.switchTo().alert().dismiss();
    }

	public Boolean isDeleteAlertDisplayed() {
		deleteContactButton.click();
		deleteContactButton.isDisplayed();
		return null;
	}
}
