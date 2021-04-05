package com.amazon.qa.testcases;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.qa.pages.Calendar;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.userHomePage;
import com.amazon.utils.takeScreenshot;

public class userHomePageTest extends TestBase {
	LoginPage LoginPage;
	Calendar HomePage;
	userHomePage userHomePage;
	userHomePage userHomePage1;


	public userHomePageTest() {
		// TODO Auto-generated constructor stub
		super();

	}

	@BeforeClass
	public void setUp() throws MalformedURLException {
		initialization();
		LoginPage = new LoginPage();
		// HomePage = LoginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		userHomePage = new userHomePage();

	}

	@Test(priority = 5)
	public void validLogin() throws InterruptedException {

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
