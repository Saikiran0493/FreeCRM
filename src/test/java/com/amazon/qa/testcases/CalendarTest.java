package com.amazon.qa.testcases;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.base.TestBase;
import com.amazon.qa.pages.Calendar;
import com.amazon.qa.pages.LoginPage;
import com.amazon.utils.takeScreenshot;
import com.freecrm.pages.TopMenu.TopMenuItems;
import com.relevantcodes.extentreports.LogStatus;

public class CalendarTest extends TestBase {

	LoginPage LoginPage;
	TopMenuItems topItems;
	Calendar calendar;
	SoftAssert softAssert = new SoftAssert();

	public CalendarTest() {
		super();
	}

	public enum example {
		winter;
	}

	@BeforeClass
	public void setUp() throws MalformedURLException {

		initialization();
	

		LoginPage = new LoginPage();
		topItems = LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 3)
	public void Calendar() throws Exception {
		System.out.println("Calendar Test Begins------" + System.currentTimeMillis());
		calendar = topItems.gotoCalendar();

		Hashtable<String, String> Actual = calendar.getItems("Calendar");

		Hashtable<String, String> expected = topItems.getData();

		Assert.assertEquals(Actual, expected);

		test.log(LogStatus.PASS, test.addScreenCapture(
				takeScreenshot.takeSnapShot(new Throwable().getStackTrace()[0].getMethodName()).toString()));
		test.log(LogStatus.PASS, "All Items Available");

	}

	@Test(priority = 4, enabled = false)
	public void calenderNewItem() {

		calendar.gotoNewEvent();
		Assert.assertEquals(calendar.isDisplayed(), true);

	}

	@Test(priority = 5, enabled = false)
	public void newEventInformation() {
		calendar.createEvent();
		Assert.assertEquals(calendar.newEventSuccessfull(), true);

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
