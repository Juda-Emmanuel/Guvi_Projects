package Heroku_App_Project.Heroku_App_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pageobjectmodel.AddContactPage;
import com.pageobjectmodel.DeleteContactPage;
import com.pageobjectmodel.DisplayContactPage;
import com.pageobjectmodel.EditContactPage;
import com.pageobjectmodel.HomePage;
import com.pageobjectmodel.LogOutPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SignUpPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contact_Test {

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private SignUpPage signupPage;
	private AddContactPage addContactPage;
	private EditContactPage editContactPage;
	private DisplayContactPage displayContactPage;
	private DeleteContactPage deleteContactPage;
	private LogOutPage LogOut;

	@BeforeSuite
	public void setup()  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		signupPage = new SignUpPage(driver);
		addContactPage = new AddContactPage(driver);
		editContactPage = new EditContactPage(driver);
		displayContactPage = new DisplayContactPage(driver);
		deleteContactPage = new DeleteContactPage(driver);
		LogOut = new LogOutPage(driver);
	}

	@Test
	public void testSignup() throws InterruptedException {
		signupPage.signUpButton();
		signupPage.enterFirstName("TestAutoUser");
		signupPage.enterLastName("Java");
		signupPage.enterEmail("TestAutoUser2025@example.com");
		signupPage.enterPassword("password123");
		signupPage.clickSubmit();
		Thread.sleep(3000);
		LogOut.clickLogout();
		Thread.sleep(3000);
		Assert.assertEquals(signupPage.isSignUpButtonVisible(), true, "Sign up button is not visible.");
		Assert.assertEquals(signupPage.isSignUpButtonClickable(), true, "Sign up button is not clickable.");
    }

	@Test(priority = 1)
	public void testLogin() throws InterruptedException {
		homePage.enterEmail("Juda@gmail.com");
		homePage.enterPassword("Apria@2020");
		homePage.clickLogin();
		String expectedPageTitle = "Contact List App"; 
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Login failed. Expected page title: " + expectedPageTitle + ", Actual page title: " + actualPageTitle);
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void testAddContact() throws InterruptedException {
		addContactPage.addContactButton();
		Thread.sleep(3000);
		addContactPage.enterFirstName("Juda");
		addContactPage.enterLastName("Emmanuel");
		addContactPage.enterBirthDate("1997-07-19");
		addContactPage.enterEmail("Juda007@example.com");
		addContactPage.enterPhone("9876543210");
		addContactPage.enterStreet1("Chennai Street");
		addContactPage.enterStreet2("Chennai Nagar");
		addContactPage.enterCity("Chennai");
		addContactPage.enterState("Tamilnadu");
		addContactPage.enterPostalCode("600001");
		addContactPage.enterCountry("India");
		addContactPage.clickSubmit();		
		Assert.assertEquals(driver.getCurrentUrl(), "https://thinking-tester-contact-list.herokuapp.com/addContact", "Page did not redirect to Add User Page.");
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void testEditContact() throws InterruptedException {
		editContactPage.selectContact();
		editContactPage.editContactButton();
		Thread.sleep(3000);
		editContactPage.editFirstName("Daniel");
		editContactPage.editLastName("Ebinazer");
		editContactPage.editBirthDate("1998-08-08");
		editContactPage.editEmail("Daniel@gmail.com");
		editContactPage.editPhone("1234567890");
		editContactPage.editStreet1("Coimbatore Street");
		editContactPage.editStreet2("Coimbatore Nagar");
		editContactPage.editCity("Coimbatore");
		editContactPage.editState("Tamilnadu");
		editContactPage.editPostalCode("641001");
		editContactPage.editCountry("India");
		Thread.sleep(3000);
		editContactPage.clickUpdate();
		Thread.sleep(3000);
		editContactPage.returntoContact();
		Thread.sleep(3000);
		Assert.assertEquals(displayContactPage.isContactDisplayed("contactName"), true, "Contact details are not displayed correctly.");
	}

	@Test(priority = 4)
	public void testDeleteContact() throws InterruptedException {
		Thread.sleep(3000);
		editContactPage.selectContact();
		Thread.sleep(3000);
		deleteContactPage.deleteContactButton();
		Thread.sleep(3000);
		deleteContactPage.confirmDelete();
		Thread.sleep(3000);
		editContactPage.selectContact();
		deleteContactPage.deleteContactButton();
		Thread.sleep(3000);
		deleteContactPage.cancelDelete();
		editContactPage.returntoContact();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void testLogout() throws InterruptedException {
		Assert.assertEquals(LogOut.isLogoutButtonVisible(), true, "Logout button is not visible.");
		Assert.assertEquals(driver.getCurrentUrl(), "https://thinking-tester-contact-list.herokuapp.com/contactList", "Page did not redirect to login page after logout.");
		LogOut.clickLogout();
	}

	@AfterSuite
	public void teardown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver closed.");
		} else {
			System.out.println("Driver is null. Skipping teardown.");
		}
	}
}
