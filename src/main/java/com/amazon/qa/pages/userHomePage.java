package com.amazon.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.TestBase;
import com.amazon.utils.reusableMethods;

public class userHomePage extends TestBase {

	// companies
	@FindBy(xpath = "//a[@title='Companies']")
	WebElement Companies;

	// Calendar
	@FindBy(xpath = "//a[@title='Companies']/parent::li/ul")
	WebElement Companieslist;

	// Initializing the Page Objects:
	public userHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void hoverOverCompanies() throws InterruptedException {

		reusableMethods.hoverOver(Companies);

	}

	public ArrayList<String> getItems() {

		ArrayList<String> val = new ArrayList<String>();

		for (int j = 1; j <= Companieslist.findElements(By.tagName("a")).size(); j++) {

			val.add(driver.findElement(By.xpath("//a[@title='Companies']/parent::li/ul/li[" + j + "]/a")).getText());
		}
		return val;

	}
}
