package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {

	public static WebDriver driver = null;
	ExtentReports extent;
	ExtentTest logger;
	ExtentHtmlReporter htmlReporter;

	@BeforeSuite
	public void initialize() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// To maximize browser
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// To open google
		driver.get("https://www.google.com/");

		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\Extentreport.html");
		htmlReporter.loadConfig("D:\\WorkSpace\\testproject\\test-output\\extent-config.xml");
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host Name", "TestMachine");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Anoop");
		

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test Case Failed is " + result.getName());
			logger.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "Test Case Skipped is " + result.getName());
		}
		// ending test
		// endTest(logger) : It ends the current test and prepares to create HTML report
		extent.flush();
	}

	@AfterSuite
	// Test cleanup
	public void TeardownTest() {
		// TestBase.driver.quit();
	}

}
