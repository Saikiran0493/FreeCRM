package com.amazon.qa.pages;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.amazon.base.TestBase;
import com.amazon.utils.Xls_Reader;
import com.amazon.utils.takeScreenshot;
import com.freecrm.pages.TopMenu.TopMenuItems;

public class LoginPage extends TestBase {

	/* WebElements */

	@FindBy(name = "username")
	public WebElement username;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	public WebElement Login;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public TopMenuItems login(String uname, String Pword) {

		username.sendKeys(uname);
		password.sendKeys(Pword);
		Login.click();
		return new TopMenuItems();
	}

	public boolean SignIn() {

		// driver.switchTo().frame("mainpanel");

		if (driver.getTitle().contentEquals("CRMPRO"))
			return true;
		else
			return false;

		// return Logout.isDisplayed();

	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		System.out.println(data);
		return data;

	}

	@DataProvider(name = "dp1")
	public Object[][] getData1(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		System.out.println(sheetName + " rows=" + rows + "\n" + "Cols=" + cols);

		Object[][] data = new Object[3][2];

		// Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			// table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols - 1; colNum++) {

				System.out.println(excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}

		}

		return data;

	}
}
