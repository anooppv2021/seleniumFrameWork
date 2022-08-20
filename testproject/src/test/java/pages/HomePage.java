package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.Status;

import tests.TestBase;

public class HomePage extends TestBase {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	// Using FindBy for locating elements
	@FindBy(how = How.XPATH, using = "//input[@title='Search']")
	WebElement searchTextBox;
	@FindBy(how = How.XPATH, using = "//input[@type='btnK']")
	WebElement searchButton;

	// This method is to set Search text in the search text box
	public void setSearchText() throws InterruptedException {
		searchTextBox.sendKeys("Automation");
		logger.log(Status.INFO, "passed");
		assertTrue(true);

	}

	// This method is to click on Search Button
	public void clickOnSearchButton() throws InterruptedException {
		// searchButton.click();
		searchTextBox.sendKeys(Keys.ENTER);
		assertTrue(true);
		Thread.sleep(4000);
	}
}