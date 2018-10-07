package com.naukri.TestScripts;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class tester {
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	String filename = System.getProperty("user.dir")+"/Reports/TestResult.html";
	
	
	@BeforeTest
	public void Setup() {
		reporter = new ExtentHtmlReporter(filename);
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		
//		reporter.config().setReportName("Basic Test Report");
//		reporter.config().setTheme(Theme.STANDARD);
//		reporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//		reporter.config().setDocumentTitle("HelloTests");
//		extent.setSystemInfo("Username", "Dip");
//		extent.setSystemInfo("OS", "Windows10");
		
	}

	@Test(priority=0)
	public void test1() {
		logger=	extent.createTest("Basic Hello Test");
		logger.log(Status.INFO,"Test Case started");
		System.out.println("Hello Test");
		logger.log(Status.PASS, "TC passed");
	}
	
	@Test(priority=1)
	public void test2() {
		logger= extent.createTest("Basic Hello World");
		logger.log(Status.INFO,"Test Case started");
		System.out.println("Hello World");
		logger.log(Status.PASS, "TC passed");
		
	}
	
	@Test(priority=2)
	public void test3() {
		logger= extent.createTest("Basic Java Test");
		logger.log(Status.INFO,"Test Case started");
		System.out.println("Hello Java User");
		//Assert.assertEquals("TBD", "Hello");
		assertTrue("TBD".equals("Hello"));
		//logger.log(Status.FAIL, "TC Failed");
		
	}
	
	@AfterTest
	public void teardown() {
		extent.flush();
	}
	
	@AfterMethod
	public void resultChecker(ITestResult TestResult) {
		if(TestResult.getStatus()==ITestResult.FAILURE) {
		logger.log(Status.FAIL,"Test case failed because of " +TestResult.getThrowable()); 
	//	logger.log(Status.FAIL, TestResult.getThrowable());
		}
		else if(TestResult.getStatus()==ITestResult.SUCCESS){
			logger.log(Status.PASS, "Test case passed");
			}
		else if (TestResult.getStatus()==ITestResult.SKIP){
			logger.log(Status.SKIP, "Test case Skipped because " +TestResult.getThrowable());
		}
	}
}
