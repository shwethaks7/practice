package gmailPack;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.gmailInitPage;
import pageObject.googleInitPage;


	public class dummy {
	
	WebDriver driverObj;
	
	@Test(priority=1)
	public void googleLogin()
	{
		driverObj.get("https://www.google.com");
		googleInitPage g1 = new gmailInitPage(driverObj);
		g1.gmailLink().click();
		
	}
	@Test(dependsOnMethods="googleLogin", dataProvider="dp")
	public void gmaillLgin(String UsrName, String Passwd)
	{
		driverObj.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		gmailInitPage g1 = new gmailInitPage(driverObj);
		g1.password().sendKeys(Passwd);
		
		WebDriverWait wait = new WebDriverWait(driverObj,3);
		wait.until(ExpectedConditions.elementToBeClickable(g1.next()));
		
		g1.next().click();
		
		
	Assert.assertEquals(false, g1.password().isDisplayed());
	System.out.println("success");
		
	}
	
	public void getScreenShot() throws IOException
	{
		System.out.println("getScreenShot");
		File src =((TakesScreenshot)(driverObj)).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File("D:\\shwetha\\selenium\\logs\\scrr1.png"));
				
			
	}
 
 @BeforeMethod
 public void beforeMethod() {
	  System.out.println("beforeMethod");
 }

 @AfterMethod
 public void afterMethod() {
	  System.out.println("afterMethod");
 }


 @DataProvider
 public Object[][] dp() throws IOException {
	  Object[][] data;
   		Properties prop= new Properties();
   		FileInputStream fp = new FileInputStream("D:\\shwetha\\selenium\\gmailProj\\src\\main\\java\\pageObject\\data.properties");
   		prop.load(fp);
   		String excelFileName = prop.getProperty("excelFileName");
   		String sheetName = prop.getProperty("sheetName");
   		
   		XSSFWorkbook wb = new XSSFWorkbook(excelFileName);
   		XSSFSheet sh = wb.getSheet(sheetName);
   		XSSFRow rw;
   		XSSFCell cl;
   			int rowNum=	sh.getLastRowNum();
   			rw=sh.getRow(0);
   			int CellNum=rw.getLastCellNum();
   			
   			data = new Object[rowNum+1][CellNum];
   			
   		int i =0;
   		while(i<=rowNum)
   		{
   			rw= sh.getRow(i);
   			String usrName=rw.getCell(0).getStringCellValue();
   			String Passwd=rw.getCell(1).getStringCellValue();
   			
   			data[i][0]=usrName;
   			data[i][1]=Passwd;
   			
   			i++;
   			
   		}
   
     
     return data;
  
 }
 @BeforeClass
 public void beforeClass() {
	  System.out.println("beforeClass");
 }

 @AfterClass
 public void afterClass() {
	  System.out.println("afterClass");
 }

 @BeforeTest
 public void beforeTest() {
	  System.out.println("beforeTest");
 }

 @AfterTest
 public void afterTest() {
	  System.out.println("afterTest");
 }

 @BeforeSuite
 @Parameters({"browser"})
 public void beforeSuite(String browser) {
	  System.out.println("beforeSuite");
	  //Set the browser 
	  if(browser.equals("Chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "D:\\shwetha\\selenium\\thirdpartyExe\\chromedriver.exe");
		  driverObj = new ChromeDriver();
	  }
 }

 @AfterSuite
 public void afterSuite() {
	  System.out.println("afterSuite");
	  driverObj.quit();
 }

}
