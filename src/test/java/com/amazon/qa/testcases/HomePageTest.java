package com.amazon.qa.testcases;

import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.utils.reusableMethods;
import com.amazon.utils.takeScreenshot;
import com.relevantcodes.extentreports.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.base.TestBase;

public class HomePageTest extends TestBase {
	HomePage HomePage;
	LoginPage LoginPage;
	SoftAssert softAssert = new SoftAssert();

	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();

		LoginPage = new LoginPage();
		LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage = new HomePage();
	}

	@Test(priority = 3)
	public void calItems() throws Exception {

		HomePage.hoverOverCalender();
		log.debug("started");
		test.log(LogStatus.INFO, "Hover Overed on Calender");
		ArrayList<String> Actual = new ArrayList<String>();
		Actual.add("New Event");
		Actual.add("View Today");
		Actual.add("Week View");
		Actual.add("Month View");

		System.out.println("git check");
		System.out.println("git check");

		System.out.println("git check");

		System.out.println("git check");

		ArrayList<String> items = HomePage.getItems();
		Assert.assertEquals(Actual, items);
		test.log(LogStatus.PASS,
				test.addScreenCapture(takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));
		test.log(LogStatus.PASS, "All Items Available");

	}

	@Test(priority = 4)
	public void calenderNewItem() {

		try {
			test.log(LogStatus.PASS, test.addScreenCapture(
					takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePage.clickNewEvent();

		try {

			test.log(LogStatus.PASS, "SCreenshot", test.addScreenCapture(
					takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));
			test.log(LogStatus.PASS, test.addScreenCapture(
					takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(HomePage.isDisplayed(), true);

	}

	@Test(priority = 5)
	public void newEventInformation() {
		HomePage.enterEventInformation();
		Assert.assertEquals(HomePage.newEventSuccessfull(), true);

		try {
			test.log(LogStatus.PASS, "New Event Added Successfully", test.addScreenCapture(
					takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {

		// assertsoft.assertAll();
		driver.close();
	}

}
