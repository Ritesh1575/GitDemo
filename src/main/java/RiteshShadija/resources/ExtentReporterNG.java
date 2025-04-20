package RiteshShadija.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports e1=new ExtentReports();
		e1.attachReporter(reporter);
		e1.setSystemInfo("Tester", "Ritesh Shadija");
		return e1;
	}

}
