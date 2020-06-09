package com.amazon.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon.base.TestBase;


public class ExtentReportManager extends TestBase implements ITestListener {
	String messageBody;
	

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {

		// TODO Auto-generated method stub
		System.out.println(arg0.getMethod().getMethodName()); 
		test = extent.startTest(arg0.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

		System.out.println(arg0.getMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
