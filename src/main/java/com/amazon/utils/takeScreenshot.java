package com.amazon.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amazon.base.TestBase;

public class takeScreenshot extends TestBase {

	public static File takeSnapShot(String methodName) throws Exception {

		// Convert web driver object to TakeScreenshot

		Date d = new Date();

		String screenShotName = d.toString().replace(":", "_").replace(" ", "_");

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File createFolder = new File(
				System.getProperty("user.dir") + "\\TestResults\\" + d.toString().substring(4, 10) + "\\" + methodName);
		
		File DestFile = new File(createFolder + "\\" + screenShotName + ".jpg");

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
		return DestFile;

	}

}
