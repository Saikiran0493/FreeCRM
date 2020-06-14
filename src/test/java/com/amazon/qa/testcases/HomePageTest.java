package com.amazon.qa.testcases;

import com.amazon.qa.pages.Calendar;
import com.amazon.qa.pages.LoginPage;
import com.amazon.utils.reusableMethods;
import com.amazon.utils.takeScreenshot;
import com.freecrm.pages.TopMenu.TopMenuItems;
import com.relevantcodes.extentreports.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
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
	Calendar HomePage;
	LoginPage LoginPage;
	TopMenuItems topItems;
	Calendar calendar;
	SoftAssert softAssert = new SoftAssert();

	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws MalformedURLException {
		initialization();

		LoginPage = new LoginPage();
		topItems = LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 3, enabled = false)
	public void calItems() throws Exception {

		topItems.gotoCalendar();
		log.debug("started");
		test.log(LogStatus.INFO, "Hover Overed on Calender");
		ArrayList<String> Actual = new ArrayList<String>();
		Actual.add("New Event");
		Actual.add("View Today");
		Actual.add("Week View");
		Actual.add("Month View");
		/*
		 * ArrayList<String> items = topItems.getItems(""); Assert.assertEquals(true,
		 * items.containsAll(Actual));
		 */
		test.log(LogStatus.PASS, test.addScreenCapture(
				takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));
		test.log(LogStatus.PASS, "All Items Available");

	}

	@Test(priority = 3)
	public void Calendar() throws Exception {

		topItems.gotoCalendar();
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		Hashtable<String, String> Actual = calendar.getItems("");

		Hashtable<String, String> expected = topItems.getData();

		Assert.assertEquals(Actual, expected);

		test.log(LogStatus.PASS, test.addScreenCapture(
				takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));
		test.log(LogStatus.PASS, "All Items Available");

	}

	@Test(priority = 4, enabled = false)
	public void calenderNewItem() {

		try {
			test.log(LogStatus.PASS, test.addScreenCapture(
					takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePage.gotoNewEvent();

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

	@Test(priority = 5, enabled = false)
	public void newEventInformation() {
		HomePage.gotoNewEvent();
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
