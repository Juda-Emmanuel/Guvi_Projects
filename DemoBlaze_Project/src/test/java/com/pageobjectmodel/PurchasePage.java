package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {

	private WebDriver driver;

	@FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
	private WebElement productName;

	@FindBy(xpath = "//h5")
	private WebElement productPrice;
	
	@FindBy(xpath = "//button[normalize-space()='Place Order']")
	private WebElement placeOrder;

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	public void addToCart() throws InterruptedException {
		addToCartButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		addToCartButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	public String getProductName() {
		return productName.getText();
	}

	public double getProductPrice() {
		String priceStr = productPrice.getText().replace("$", "");
		return Double.parseDouble(priceStr);
	}

	public void selectProduct() {
		productName.click();
	}

}
