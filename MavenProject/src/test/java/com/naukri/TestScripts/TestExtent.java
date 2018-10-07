package com.naukri.TestScripts;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestExtent {
	ExtentHtmlReporter htmlReport;
	ExtentReports report;
	ExtentTest logger;
	String filename = System.getProperty("user.dir")+"/Reports/ExtentRreportinHTM.html";
	//String configfile= System.getProperty(("user.dir")+"/extent-config.xml");
	
	
	@BeforeTest
	public void Setup() {
		htmlReport = new ExtentHtmlReporter (filename);
		report = new ExtentReports();
		report.attachReporter(htmlReport);
	//	htmlReport.loadXMLConfig(new File(configfile));
		
	
//		htmlReport.config().setDocumentTitle("Sample Test Report");
//		htmlReport.config().setReportName("Test Sampler");
//		report.setSystemInfo("Username", "Kuchbhi");
//		report.setSystemInfo("OS", "Windows 7");

	}
	
	@Test(priority =0)
	public void test1() {
		logger = report.createTest("Test acse 1");
		logger.log(Status.INFO,"Test started");
		System.out.println("Hello world");
		logger.log(Status.PASS, "Test acse passed");
	}
	
	@Test(priority = 1)
	public void test2() {
		logger = report.createTest("Test acse 2");
		logger.log(Status.INFO,"Test started");
		assertTrue(("Hello").equals("World"));
		//logger.log(Status.PASS, "Test acse passed");
	}
	
	@Test(priority = 2)
	public void test3() {
		logger = report.createTest("Test acse 3");
		logger.log(Status.INFO,"Test started");
		System.out.println("Hello world1");
		logger.log(Status.INFO,"Test Completed");
	}
	
	@AfterTest
	public void teardown() {
		report.flush();
	}
	
	@AfterMethod
	public void LogResult(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "TC Failed becuase of");
			logger.log(Status.FAIL, result.getThrowable());
		}
		else if((result.getStatus() == ITestResult.SUCCESS)) {
			logger.log(Status.PASS, "TC passed");
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "TC Skipped");
			logger.log(Status.SKIP, result.getThrowable());
		}
	}

}
