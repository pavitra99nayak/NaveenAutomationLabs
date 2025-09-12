package NaveenAutomationLabs.AbstractMethods;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtReports {
	
	public static ExtentReports XtentReports()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
		reporter.config().setDocumentTitle("Web Automation");
		reporter.config().setReportName("Naveen Automation Test");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
