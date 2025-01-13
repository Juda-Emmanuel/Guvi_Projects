package DemoBlaze_Project.DemoBlaze_Project;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Test {

	protected WebDriver driver;
	
	// Path for screenshots directory
    private static final String SCREENSHOTS_DIR = "C:\\Users\\lenovo\\eclipse-workspace\\DemoBlaze_Project\\ScreenShots";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {
    	if (result.getStatus() == ITestResult.FAILURE) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotPath = SCREENSHOTS_DIR + "/" + result.getName() + "_" + timestamp + ".png";
            try {
                // Take screenshot as a file
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                // Save the screenshot to the desired location
                FileUtils.copyFile(scrFile, new File(screenshotPath));
                System.out.println("Screenshot saved: " + screenshotPath);

                // Log screenshot path in TestNG Reporter
                Reporter.log("Screenshot saved at: <a href='" + screenshotPath + "'>" + screenshotPath + "</a>", true);
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
