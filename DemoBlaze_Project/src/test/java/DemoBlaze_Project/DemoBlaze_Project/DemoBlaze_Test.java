package DemoBlaze_Project.DemoBlaze_Project;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.pageobjectmodel.CartPage;
import com.pageobjectmodel.HomePage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.PaymentPage;
import com.pageobjectmodel.PurchasePage;
import com.pageobjectmodel.SignUpPage;

public class DemoBlaze_Test extends Base_Test {

	private HomePage homePage;
	private CartPage cartPage;
	private PaymentPage paymentPage;
	private PurchasePage purchasePage;
	private SignUpPage signupPage;
	private LoginPage loginPage;

	@BeforeClass
	public void setUpPages() {
		signupPage = new SignUpPage(driver);
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		paymentPage = new PaymentPage(driver);
		purchasePage = new PurchasePage(driver);
	}

	@Test(priority = 1)
	public void testSignUpButtonVisibility() {
		System.out.println("Sign up button visible: " + homePage.isSignupButtonVisible());
	}

	@Test(priority = 2)
	public void testLoginButtonVisibility1() {
		System.out.println("Login button visible: " + homePage.isLoginButtonVisible());
	}

	@Test(priority = 3)
	public void testSiteLogoVisibility() {
		homePage.isSiteLogoVisible();
	}

	@Test(priority = 4)
	public void testSignupButtonVisibility() {
		driver.get("https://www.demoblaze.com/");
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isSignupButtonVisible(), "Signup button is not visible");
	}

	@Ignore
	@Test(priority = 5)
	public void testSignupFunctionality() {
		driver.get("https://www.demoblaze.com/");
		homePage = new HomePage(driver);
		homePage.clickSignup();
		signupPage = new SignUpPage(driver);
		signupPage.enterUsername("testuser1");
		signupPage.enterPassword("testpassword123");
		signupPage.clickSignup();
	}

	@Test(priority = 6)
	public void testLoginButtonVisibility() {
		driver.get("https://www.demoblaze.com/");
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isLoginButtonVisible(), "Login button is not visible");
	}

	@Test(priority = 7)
	public void testLoginFunctionality() throws InterruptedException {
		driver.get("https://www.demoblaze.com/");
		homePage = new HomePage(driver);
		homePage.clickLogin();
		loginPage = new LoginPage(driver);
		loginPage.enterUsername("testuserjan25");
		loginPage.enterPassword("password123");
		loginPage.clickLogin();
		Thread.sleep(3000);
		homePage.isWelcomeUserDisplayed();
		homePage.allCategoryVisible();
		homePage.printWebElements();
		homePage.printMenuWebElements();
	}

	@Test(priority = 8)
	public void testPlaceOrder() throws InterruptedException {

		purchasePage.selectProduct();
		purchasePage.addToCart();
		Thread.sleep(3000);

		cartPage.clickOnCart();
		Thread.sleep(3000);

		cartPage.deleteItem(1);
		Thread.sleep(3000);

		cartPage.placeOrder();

		paymentPage.fillOrderDetails("Juda", "India", "Chennai", "1234567890", "January", "2025");
		Thread.sleep(3000);

		paymentPage.clickPurchase();
		Thread.sleep(3000);

		paymentPage.clickOkBuuttron();
		Thread.sleep(3000);

		homePage.logOutFuntion();
	}
}
