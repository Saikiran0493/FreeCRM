package com.freecrm.pages.TopMenu;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import com.amazon.qa.pages.*;

import com.amazon.base.TestBase;
import com.amazon.utils.reusableMethods;

public class TopMenuItems extends TestBase {

	@FindBy(xpath = "//a[text()='Home']")
	public WebElement Home;

	@FindBy(xpath = "//a[text()='Calendar']")
	public WebElement Calendar;

	// Calendar
	@FindBy(xpath = "//a[@title='Calendar']")
	public WebElement calender;

	@FindBy(xpath = "//a[text()='Companies']")
	public WebElement Companies;

	@FindBy(xpath = "//a[text()='Contacts']")
	public WebElement Contacts;

	// Calendar
	@FindBy(xpath = "//a[@title='Calendar']/parent::li/ul")
	public WebElement calenderlist;

	public TopMenuItems() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(driver, this);
	}

	public Calendar gotoCalendar() throws InterruptedException {

		reusableMethods.hoverOver(calender);

		return new Calendar();

		// action.moveToElement(calender).build().perform();

	}

	public void gotoCompanies() {

		action.moveToElement(Calendar).build().perform();
	}

	public void gotoContacts() {

		action.moveToElement(Calendar).build().perform();
	}

	public Hashtable<String, String> getData() {

		String sheetName = "HoverOverValues";// = m.getName();
		int rows = excel.getRowCount(sheetName);
		// int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String, String>();

			// data[0][0]
			table.put(excel.getCellData(sheetName, 0, 1), excel.getCellData(sheetName, 0, rowNum));
			// data[rowNum - 2][0] = table;

		}

		System.out.println(data);
		return table;

	}
}
