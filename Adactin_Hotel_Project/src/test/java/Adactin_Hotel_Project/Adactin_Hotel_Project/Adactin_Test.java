package Adactin_Hotel_Project.Adactin_Hotel_Project;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.pageobjectmodel.BookingPage;
import com.pageobjectmodel.HomePage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchHotelPage;
import com.pageobjectmodel.SelectHotelPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin_Test {

	private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchHotelPage searchHotelPage;
    private SelectHotelPage selectHotelPage;
    private BookingPage bookingPage;

    @BeforeSuite
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUpPageObjects() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchHotelPage = new SearchHotelPage(driver);
        selectHotelPage = new SelectHotelPage(driver);
        bookingPage = new BookingPage(driver);
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, boolean expectedResult) {
        homePage.navigateTo(); 
        homePage.enterUsername(username);
        homePage.enterPassword(password);
        loginPage = homePage.clickLogin();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
            {"JudaEmmanuel", "Apria@2020", true},
            {"invalidUser", "Apria@2020", false},
            {"JudaEmmanuel", "invalidPassword", false},
            {"", "Apria@2020", false},
            {"JudaEmmanuel", "", false},
            {"", "", false},
        };
    }

    @Test(dependsOnMethods = "loginTest")
    public void searchHotelTest() {
    	loginPage.enterUsername("JudaEmmanuel");
    	loginPage.enterPassword("Apria@2020");
    	homePage.clickLogin();
        searchHotelPage.selectLocation("London");
        searchHotelPage.selectHotel("Hotel Hervey");
        searchHotelPage.selectRoomType("Standard");
        searchHotelPage.selectRoomNos("2 - Two");
        searchHotelPage.selectAdultsPerRoom("2 - Two");
        searchHotelPage.selectChildrenPerRoom("1 - One");
        searchHotelPage.enterCheckInDate("2024-12-10"); 
        searchHotelPage.enterCheckOutDate("2024-12-15"); 
        selectHotelPage = searchHotelPage.clickSearch(); 
    }

    @Test(dependsOnMethods = "searchHotelTest")
    public void selectHotelTest() {
        selectHotelPage.selectHotel();
        bookingPage = selectHotelPage.clickContinue(); 
    }

    @Test(dependsOnMethods = "selectHotelTest", dataProvider = "bookingData")
    public void bookHotelTest(String firstName, String lastName, String billingAddress, 
                              String ccNumber, String ccType, String expMonth, String expYear, 
                              String cvv, boolean expectedResult) {

        bookingPage.enterGuestDetails(firstName, lastName, billingAddress, ccNumber, ccType, expMonth, expYear, cvv);
        bookingPage.clickBookNow();
    }

    @DataProvider
    public Object[][] bookingData() {
        return new Object[][] {
            {"Juda", "Emmanuel", "Chennai St", "1234567890123456", "VISA", "January", "2025", "123", true}, // Valid data
        };
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	@AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
