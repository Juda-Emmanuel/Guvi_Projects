package com.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	private WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Cart']")
	WebElement cart;
	
    @FindBy(xpath = "//a[@id='cartur']") 
    private List<WebElement> cartItems;

    @FindBy(xpath = "//h3[@id='totalp']")
    private WebElement totalPrice;

    @FindBy(xpath = "//a[normalize-space()='Delete']") 
    private List<WebElement> deleteButtons;
    
    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    private WebElement placeOrder;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
    
    public void clickOnCart() {
    	cart.click();
	}

    public void deleteItem(int index) {
        deleteButtons.get(index).click();
    }
    
    public void placeOrder() {
    	placeOrder.click();
	}

    public int getCartItemCount() {
        return cartItems.size();
    }


}
