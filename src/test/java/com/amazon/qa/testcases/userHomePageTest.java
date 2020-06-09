package com.amazon.qa.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.userHomePage;
import com.amazon.utils.takeScreenshot;

public class userHomePageTest extends TestBase {
	LoginPage LoginPage;
	HomePage HomePage;
	userHomePage userHomePage;

	public userHomePageTest() {
		// TODO Auto-generated constructor stub
		super();

	}

	@BeforeClass
	public void setUp() {
		initialization();
		LoginPage = new LoginPage();
		//HomePage = LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		userHomePage = new userHomePage();

	}

	@Test(priority = 5)
	public void validLogin() {

		userHomePage.hoverOverCompanies();
		ArrayList<String> Actual = new ArrayList<String>();
		Actual.add("New Company");
		Actual.add("Combined Form");
		Actual.add("Full Search Form");
		ArrayList<String> items = userHomePage.getItems();
		Assert.assertEquals(Actual, items);

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}