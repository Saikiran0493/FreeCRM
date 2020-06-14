package com.amazon.qa.pages;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.amazon.base.TestBase;
import com.amazon.utils.reusableMethods;

public class Calendar extends TestBase {

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	public WebElement Logout;

	// Calendar
	@FindBy(xpath = "//a[@title='Calendar']")
	public WebElement calender;

	// NewEvent Title
	@FindBy(id = "title")
	public WebElement title;

	// Calendar
	@FindBy(xpath = "//a[@title='Calendar']/parent::li/ul")
	public WebElement calenderlist;

	@FindBy(xpath = "//*[text()='Event Information ']")
	public WebElement NewEventPage;

	@FindBy(xpath = "//*[text()='New Event']")
	public WebElement NewEvent;

	@FindBy(name = "assigned_to_user_id_src")
	public WebElement assignedtoSelect;

	@FindBy(xpath = "//input[@value='==ADD==>']")
	public WebElement add;

	@FindBy(xpath = "//input[@value='Save']")
	public WebElement save;

	@FindBy(xpath = "//*[contains(text(),'Email notifications were sent to all attendees.')]")
	public WebElement newEventsuccessful;

	// Initializing the Page Objects:
	public Calendar() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public boolean SignIn() {

		// driver.switchTo().frame("mainpanel");

		if (driver.getTitle().contentEquals("CRMPRO"))
			return true;
		else
			return false;

		// return Logout.isDisplayed();

	}

	public void hoverOverCalender() throws InterruptedException {

		reusableMethods.hoverOver(calender);
	}

	public Hashtable<String, String> getItems(String Element) {

		Hashtable<String, String> val = new Hashtable<String, String>();

		for (int j = 1; j <= calenderlist.findElements(By.tagName("a")).size(); j++) {

			val.put(Element, calenderlist.findElements(By.tagName("a")).get(j - 1).getText());
		}
		return val;

	}

	public void gotoNewEvent() {
		// TODO Auto-generated method stub
		NewEvent.click();

	}

	public boolean isDisplayed() {

		return NewEventPage.isDisplayed();

	}

	public void createEvent() {

		title.sendKeys("Meeting-1");

		select = new Select(assignedtoSelect);
		select.selectByVisibleText("Demo User");
		add.click();
		save.click();

	}

	public boolean newEventSuccessfull() {
		return newEventsuccessful.isDisplayed();
	}

}
