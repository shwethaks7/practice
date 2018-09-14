package pageObject;


import gmailPack.base;
import gmailPack.gmailLoginTestTest;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class gmailListener extends base implements ITestListener{

	//base ob = new base();
	//WebDriver drv;
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("onFinish");
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("onStart");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage");
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailure");

		try {
			
			getScreenShot();
			//this.driverObj = ((base)arg0.getInstance()).driverObj;
			//File src =((TakesScreenshot)(driverObj)).getScreenshotAs(OutputType.FILE);
			//this.drv=base.driverObj;
			//File src =((TakesScreenshot) (drv)).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(src,new File("D:\\shwetha\\selenium\\logs\\scrr1.png"));
			//base.getScreenShot();
			/* String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
	            WebDriver driver = (WebDriver) arg0.getTestContext().getAttribute("WebDriver");
	            TakesScreenshot ts = (TakesScreenshot)driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            String dest="./screenshot/"+ fileName;
	            File snapshotDest =new File(dest);
	            FileUtils.copyFile(source, snapshotDest);*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped");
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("onTestStart");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess");
	}
	

}
