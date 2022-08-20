package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;

public class SearchTest extends TestBase {

	@Test
	public void init() throws Exception {

		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.setSearchText();
		homepage.clickOnSearchButton();

	}

}