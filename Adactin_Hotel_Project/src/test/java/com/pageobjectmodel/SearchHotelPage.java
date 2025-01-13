package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends BasePage{

	 @FindBy(id = "location")
	    private WebElement locationDropdown;

	    @FindBy(id = "hotels")
	    private WebElement hotelsDropdown;

	    @FindBy(id = "room_type")
	    private WebElement roomTypeDropdown;

	    @FindBy(id = "room_nos")
	    private WebElement roomNosDropdown;

	    @FindBy(id = "adult_room")
	    private WebElement adultsPerRoomDropdown;

	    @FindBy(id = "child_room")
	    private WebElement childrenPerRoomDropdown;

	    @FindBy(id = "datepick_in")
	    private WebElement checkInDate;

	    @FindBy(id = "datepick_out")
	    private WebElement checkOutDate;

	    @FindBy(id = "Submit")
	    private WebElement searchButton;

	    public SearchHotelPage(WebDriver driver) {
	        super(driver);
	    }

	    public void selectLocation(String location) {
	        Select selectLocation = new Select(locationDropdown);
	        selectLocation.selectByVisibleText(location);
	    }

	    public void selectHotel(String hotel) {
	        Select selectHotel = new Select(hotelsDropdown);
	        selectHotel.selectByVisibleText(hotel);
	    }

	    public void selectRoomType(String roomType) {
	        Select selectRoomType = new Select(roomTypeDropdown);
	        selectRoomType.selectByVisibleText(roomType);
	    }

	    public void selectRoomNos(String roomNos) {
	        Select selectRoomNos = new Select(roomNosDropdown);
	        selectRoomNos.selectByVisibleText(roomNos);
	    }

	    public void selectAdultsPerRoom(String adults) {
	        Select selectAdults = new Select(adultsPerRoomDropdown);
	        selectAdults.selectByVisibleText(adults);
	    }

	    public void selectChildrenPerRoom(String children) {
	        Select selectChildren = new Select(childrenPerRoomDropdown);
	        selectChildren.selectByVisibleText(children);
	    }

	    public void enterCheckInDate(String checkInDate) {
	        this.checkInDate.sendKeys(checkInDate);
	    }

	    public void enterCheckOutDate(String checkOutDate) {
	        this.checkOutDate.sendKeys(checkOutDate);
	    }

	    public SelectHotelPage clickSearch() {
	        searchButton.click();
	        return new SelectHotelPage(driver);
	    }
}
