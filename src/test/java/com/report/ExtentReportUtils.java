package com.report;

import java.io.File;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangehrm.test.BaseTest;

public class ExtentReportUtils {
	
	//ExtentTest Object is required to create a test
	public static ExtentTest test;
	
	//ExtentReport Object is required to create a report
	public static ExtentReports report;
	
	//This method is invoked in @BegoreSuit method to initialize the report
	public static void setUpReport() {
		report = new ExtentReports();
		ExtentSparkReporter spark= new ExtentSparkReporter("report/execution.html");
		report.attachReporter(spark);
	}
	
	//Creates the test case, testName parameter accepts name of the @Test method
	public static void createTest(String testName) {
		test= report.createTest(testName);
	}
	
	//This method adds the step in each test case. In the parameter you can specify the message or step
	public static void addStep(String StepMessage) {
		test.info(StepMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build());
	}
    
	//This method captures the screenshot of application. It is invoked in addStep method of this class
	private static String captureScreenshot() {
		TakesScreenshot screenshot= (TakesScreenshot) BaseTest.driver;
		File file= screenshot.getScreenshotAs(OutputType.FILE);
		
		//convert actual image to base 64 image
		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(file);
		}
		catch(Exception e) {
			
		}
		
		String str= Base64.getEncoder().encodeToString(fileContent);
		System.out.println(str);
		
		return str;
	}
	
	//This method flushes the report. It is invoked at the end of execution
	public static void flushReport() {
		report.flush();
	}

}
