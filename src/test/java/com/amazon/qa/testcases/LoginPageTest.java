package com.amazon.qa.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.amazon.base.TestBase;
import com.amazon.qa.pages.Calendar;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.userHomePage;
import com.amazon.utils.reusableMethods;

public class LoginPageTest extends TestBase {

	LoginPage Login;
	int rowCounter = 2;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		Login = new LoginPage();

	}
	/*
	 * @Test(priority = 1) public void ValidateTitle() {
	 * Assert.assertEquals(Login.username.isDisplayed(), true); }
	 */

	@Test(priority = 2, dataProviderClass = LoginPage.class, dataProvider = "dp")
	public void Login(Hashtable<String, String> data) {

		Login.login(data.get("username"), data.get("password"));
		if (Login.SignIn() == true) {
			// Assert.assertTrue(true);
			LoginPage.excel.setCellData("Login", "Result", rowCounter, "PASS");
		} else {
			LoginPage.excel.setCellData("Login", "Result", rowCounter, "FAIL");

			Assert.assertEquals(Login.username.isDisplayed(), true, " Invalid Credentials");

		}
		rowCounter = rowCounter + 1;
	}

	@AfterMethod
	public void tearDown() {

		// assertsoft.assertAll();
		driver.close();
	}

}
