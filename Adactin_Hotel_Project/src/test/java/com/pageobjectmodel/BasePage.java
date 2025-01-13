package com.pageobjectmodel;

import org.testng.annotations.AfterMethod;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo() {
        driver.get("https://adactinhotelapp.com/index.php");
    }

    @AfterMethod
	public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
