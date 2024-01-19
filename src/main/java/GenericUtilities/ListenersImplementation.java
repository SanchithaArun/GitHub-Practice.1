package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides Implementation for ITestListener Interface of TestNG
 * @author asanchitha
 *
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//start of@Test-->Test Method-->Method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-----Test Execution Started------");
	   
		//For Extent Reports to recognize the @Test
		test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-----Test Pass------");
		
		//For logging the status of Test in extent reports
		test.log(Status.PASS, methodName+"------Test Pass----");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-----Test Failed------");
		System.out.println(result.getThrowable());//print the exception
		 
		//For logging the status of Test in extent reports
		test.log(Status.FAIL, methodName+"-----Test Fail----");
		test.log(Status.INFO,result.getTestName());
		//capture screen shot
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j= new JavaUtility();
		String screenShotName=methodName+"-"+j.getSystemDate();
        try {
			String path = s.captureScreenShot(BaseClass.sDriver, screenShotName);
		    test.addScreenCaptureFromPath(path);
			
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-----Test skipped------");
		System.out.println(result.getThrowable());//print the exception
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-----Suite Execution Started-----");
	
		//Extent Report Configuration
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\Extent Reports\\Report-"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Execution Report");
		esr.config().setReportName("Vtiger Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base Url", "http://localhost:8888");
		report.setSystemInfo("Reporter","Sanchitha");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-----Suite Execution Finished-----");
		
		//Extent Report generation
		report.flush();
		
	}

}
