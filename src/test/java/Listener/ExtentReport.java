package Listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testing.BaseClass;

public class ExtentReport implements ITestListener{
	
	WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	 public ExtentReports extent;
	 public ExtentTest test;
	 String repName;
	 public void onStart(ITestContext context) {
		 
		 sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/TestNG-reports/myReport.html");
		 sparkReporter.config().setDocumentTitle("Automation Report");
		 sparkReporter.config().setReportName("Finding Hospitals");
		 sparkReporter.config().setTheme(Theme.DARK);
		 extent=new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 extent.setSystemInfo("Computer Name","HP");
		 extent.setSystemInfo("Environment","QEA");
		 extent.setSystemInfo("Tester Name","Nikhil Joshi");
		 extent.setSystemInfo("OS","Windows10");
		 extent.setSystemInfo("Browser name","Chrome");
	 }
	
	 
	 public void onTestSuccess(ITestResult result) {
		 test= extent.createTest(result.getName());
		 test.log(Status.PASS,"Test case PASSED is:"+result.getName());
		 String path = (System.getProperty("user.dir")+"/screenshots/Passed Test Cases/"+result.getName()+".png");
		 TakesScreenshot screenshot = (TakesScreenshot) BaseClass.driver;
	        try {
				FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE), new File(path));
			} catch (WebDriverException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    test.addScreenCaptureFromPath(path);
		    System.out.println("Test case passed and Screenshot Captured");
		 
		 
	 }
	 public void onTestFailure(ITestResult result) {
		 test = extent.createTest(result.getName());
		 test.log(Status.FAIL,"Test case FAILED is:" +result.getName());
		 test.log(Status.FAIL,"Test case FAILED cause is: "+result.getThrowable());
		 String path = (System.getProperty("user.dir")+"/screenshots/Failed Test Cases/"+result.getName()+".png");
		 TakesScreenshot screenshot = (TakesScreenshot) BaseClass.driver;
	        try {
				FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE), new File(path));
			} catch (WebDriverException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    test.addScreenCaptureFromPath(path);
		    System.out.println("Screenshot Captured");
	
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 test= extent.createTest(result.getName());
		 test.log(Status.SKIP,"Test case SKIPPED is :" + result.getName());
	}
	 
	 public void onFinish(ITestContext context) {
		 extent.flush();
	 }

}
