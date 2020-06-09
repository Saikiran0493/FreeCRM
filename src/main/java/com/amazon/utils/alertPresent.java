package com.amazon.utils;

import org.openqa.selenium.WebElement;

public class alertPresent {

	public static boolean checkIfAlertPresent(WebElement alert) {
		// TODO Auto-generated method stub

		if (alert.isDisplayed()) {

			return true;
		} else {
			return false;
		}

	}

}
