package com.naukri.TestScripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExceptionTestContextImpl;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.SessionStatusStats;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.SystemAttributeContext;
import com.aventstack.extentreports.TestAttributeTestContextProvider;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.naukri.Pages.nLogin;

public class NaukriLoginTest {
	
	@BeforeTest
	public static void RunBrowser() {
		nLogin.preCondition();
	}

	@Test
	public static void login() {
		nLogin.loginApplication();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/testReport.html");
		ExtentReports extent = new ExtentReports();
		ExtentTest logger = extent.createTest("App login");
		logger.log(Status.INFO,"Test case Started");
		logger.log(Status.PASS, "Test Step passed");
		logger.log(Status.FAIL,"Test Step failed");
		System.out.println("Hello Sir");
		extent.flush();
		
		ExtentTest logger1 = extent.createTest("syso test");
		logger1.log(Status.FAIL, "Test Step failed");
	//	logger1.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());
		System.out.println("Hello Test");
	
	


	}
}
