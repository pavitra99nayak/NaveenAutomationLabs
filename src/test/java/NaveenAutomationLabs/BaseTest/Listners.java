package NaveenAutomationLabs.BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import NaveenAutomationLabs.AbstractMethods.ExtReports;

public class Listners extends BaseTest implements ITestListener {
	ExtentReports extent = ExtReports.XtentReports();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		thread.get().log(Status.PASS, result.getMethod().getMethodName()+" Test Case is Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		thread.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String filepath=null;
		try {
			filepath = TakeScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//thread.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		thread.get().fail(MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
