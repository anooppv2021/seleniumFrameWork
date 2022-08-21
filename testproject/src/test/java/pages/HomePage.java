package pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import tests.TestBase;

public class HomePage extends TestBase {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	// Using FindBy for locating elements
	@FindBy(how = How.XPATH, using = "//input[@title='Search']")
	WebElement searchTextBox;
	@FindBy(how = How.XPATH, using = "//input[@type='btnK']")
	WebElement searchButton;

	// This method is to do google Search
	public void GoogleSearchText() throws InterruptedException {
		searchTextBox.sendKeys("Automation");

		searchTextBox.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.titleContains("Automation"));

		String title = driver.getTitle();

		if (title.contains("Automation")) {

			logger.log(Status.INFO, "Test Passed");
			assertTrue(true);

		} else {

			logger.log(Status.INFO, "Test Failed");
			assertTrue(false);

		}
	}

}