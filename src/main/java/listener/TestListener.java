package listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.TestBase;


public class TestListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("TestListener:"+result.getMethod().getMethodName()+"STARTED");
		logger=reports.startTest(result.getMethod().getMethodName()+"STARTED");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TestListener:"+result.getMethod().getMethodName() + " PASS");
		logger.log(LogStatus.PASS,result.getMethod().getMethodName() + " PASS");	
		

	}


	public void onTestFailure(ITestResult result) {
		System.out.println("TestListener:"+result.getMethod().getMethodName()+" FAIL");
		logger.log(LogStatus.FAIL,result.getMethod().getMethodName()+" FAIL" );	
		

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TestListener:"+ result.getMethod().getMethodName() +" Skipped");
		logger.log(LogStatus.INFO,result.getMethod().getMethodName() +" Skipped");
		

	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");

	}


	public void onStart(ITestContext context) {
		System.out.println("onStart");
		reportObj=new ExtentReport();
		reports=reportObj.reports;
		

	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		reports.endTest(logger);
		reports.flush();
	}



}
