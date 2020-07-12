package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.amazon.utils.Xls_Reader;
import com.relevantcodes.extentreports.*;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;
	public static Select select;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentReports extent;
	public static Method M;
	public static Xls_Reader excel = new Xls_Reader(
			System.getProperty("user.dir") + "\\src\\main\\java\\com\\amazon\\TestData\\Data.xlsx");
	public static ExtentTest test;

	@BeforeSuite
	public void initExtentReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "//target//surefire-reports//extentnew.html");
	}

	@AfterSuite
	public void generateExtentReport() {

		extent.endTest(test);
		extent.flush();
		driver.quit();
	}

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\amazon\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() throws MalformedURLException {
		String browserName = prop.getProperty("browser");

		/*
		 * if (System.getenv("browser") != null && !System.getenv("browser").isEmpty())
		 * {
		 * 
		 * browserName = System.getenv("browser"); } else {
		 * 
		 * browserName = prop.getProperty("browser");
		 * 
		 * }
		 * 
		 * prop.setProperty("browser", browserName);
		 */

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\CHITTI\\Desktop\\chromedriver_win32\\chromedriver.exe");

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName(browserName);
			System.out.println(cap.getCapability(browserName));
			cap.setPlatform(Platform.ANY);

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

			// driver = new ChromeDriver();
			// action = new Actions(driver);
		} else if (prop.getProperty("browser").equals("ie")) {

			// System.setProperty("webdriver.gecko.driver", "gecko.exe");
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\CHITTI\\eclipse-workspace\\FreeCRM\\src\\test\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			action = new Actions(driver);
		}

		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		// driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
