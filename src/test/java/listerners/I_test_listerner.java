package listerners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class I_test_listerner extends BaseClass implements ITestListener{
	ExtentSparkReporter extentSparkReporter;
	   ExtentReports extent;
	   ExtentTest test;
	@Override  
	public void onTestStart(ITestResult result) {  
		System.out.println("Starting Testcase : "+result.getName()); 
//		test = extent.createTest(result.getName());
		
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
		test = extent.createTest(result.getName()); 
		test.log(Status.PASS, MarkupHelper.createLabel("Name of Passed testcase is : "+result.getName() , ExtentColor.GREEN ));
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	System.out.println("Failure of test cases and its details are : "+result.getName()); 
	test = extent.createTest(result.getName()); 
	test.log(Status.FAIL, MarkupHelper.createLabel("Name of Failed testcase is : "+result.getName() , ExtentColor.RED ));
	
	try {
		File file = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\Screenshorts\\"+
				result.getName()+"_"+result.getEndMillis()+".png"));
		System.out.println("*******Screenshot captured********");
		} 
		catch(Exception e) {
		e.printStackTrace();
		}
//	WebDriver d = null;
//	try {
//		d= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("d").get(result.getInstance());
//	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//		e.printStackTrace();
//	}
//	File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
//    try {
//		FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"\\Screenshorts\\"+result.getName()+".png"));
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	}  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	test = extent.createTest(result.getName()); 
	test.log(Status.SKIP, MarkupHelper.createLabel("Name of Skiped testcase is : "+result.getName() , ExtentColor.YELLOW ));
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {
		extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport1234.html");
		extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);
	       
	 	   extent.setSystemInfo("Machine", "testpc1");
	 	   extent.setSystemInfo("OS", "Windows10");
	 	   extent.setSystemInfo("browser", "chrome");
	   	   extent.setSystemInfo("username", "Asif_Ali");
	 	 
	       //configuration items to change the look and feel
	       //add content, manage tests etc
	       extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
	       extentSparkReporter.config().setReportName("Test Report");
	       extentSparkReporter.config().setTheme(Theme.DARK);
	       extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
		extent.flush();
	}  
}
