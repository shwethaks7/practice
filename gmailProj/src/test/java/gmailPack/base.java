package gmailPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

public class base {

	
	public static WebDriver driverObj;//another class cannot modify the driver obj. so this ll b modified only after null assignment.
	public Properties prop;
	public WebDriver initializedriver() throws IOException{
		//public void initializedriver() throws IOException{
		prop= new Properties();
   		FileInputStream fp = new FileInputStream("D:\\shwetha\\selenium\\gmailProj\\src\\main\\java\\pageObject\\data.properties");
   		prop.load(fp);
   		String browser = prop.getProperty("browser");
   		if(browser.equals("chrome"))
   		{
			System.setProperty("webdriver.chrome.driver", "D:\\shwetha\\selenium\\thirdpartyExe\\chromedriver.exe");
			driverObj = new ChromeDriver();
   		
			driverObj.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
   		}
		return driverObj;
		
	}
	
	public static void getScreenShot() throws IOException
	{
		
		System.out.println("getScreenShot");
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

		 //get current date time with Date()
		 Date date = new Date();

		 // Now format the date
		 String date1= dateFormat.format(date);
		 date1=date1.replace(" ", "");
		 date1=date1.replace(":", "");

		 // Print the Date
		 System.out.println(date1);
		 String fileName = "D:\\shwetha\\selenium\\logs\\scrr1_"+date1+".png";
		 System.out.println(fileName);
		File src =((TakesScreenshot)(driverObj)).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File(fileName));
			
	}
}
