package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;

public class SearchTest extends TestBase {

	@Test(priority = 1, enabled = true, testName = "To verify google search", description = "Google")
	public void googleSearch() throws Exception {

		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.GoogleSearchText();

	}

}