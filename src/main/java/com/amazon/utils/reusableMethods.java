package com.amazon.utils;

import org.openqa.selenium.WebElement;
import com.amazon.base.TestBase;

public class reusableMethods extends TestBase {

	public static void hoverOver(WebElement element) {
		driver.switchTo().frame("mainpanel");
		action.moveToElement(element).build().perform();

	}

}
