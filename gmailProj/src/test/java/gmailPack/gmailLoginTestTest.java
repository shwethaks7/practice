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
import org.openqa.selenium.By;
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


	public class gmailLoginTestTest extends base{
	//WebDriver driverObj;
	
	
	@Test(priority=1)
	public void googleLogin() throws IOException
	{
		
		System.out.println("googleLogin");
		driverObj.get("https://www.google.com");
		googleInitPage g1 = new googleInitPage(driverObj);
		g1.gmailLink().click();
		//driverObj.navigate().to("https://www.facebook.com");
		//driverObj.findElement(By.xpath("//*[@id='q']")).sendKeys("hello");
		//driverObj.findElement(By.xpath("//*[@id='gb']/div/div[1]/div[1]/a")).click();
		System.out.println("googleLogin end");
		
	}
	@Test(dependsOnMethods="googleLogin", dataProvider="dp")
	public void gmaillLgin(String UsrName, String Passwd) throws IOException
	{
		driverObj.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driverObj.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		gmailInitPage g2 = new gmailInitPage(driverObj);
		g2.signIn().click();
		
		g2.emailId().sendKeys(UsrName);
		g2.emailNxt().click();
		
		g2.password().sendKeys(Passwd);
		System.out.println(Passwd);
		WebDriverWait wait = new WebDriverWait(driverObj,3);
		wait.until(ExpectedConditions.elementToBeClickable(g2.passwdnext()));
		
		g2.passwdnext().click();
		getScreenShot();
		driverObj.navigate().back();
		driverObj.navigate().back();
		
	//Assert.assertEquals(false, g2.password().isDisplayed());
		
	System.out.println("success");
		
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
 public void beforeClass() throws IOException {
	  System.out.println("beforeClass");
	  
	//Set the browser 
		driverObj=  initializedriver();
 }

 @AfterClass
 public void afterClass() {
	  System.out.println("afterClass");
 }

 @BeforeTest
 public void beforeTest() throws IOException {
	  System.out.println("beforeTest");
	
 }

 @AfterTest
 public void afterTest() {
	  System.out.println("afterTest");
	  driverObj.quit();
 }

 @BeforeSuite
 @Parameters({"browser"})
 public void beforeSuite(String browser) throws IOException {
	  System.out.println("beforeSuite");
	 
	  
	  System.out.println("beforeSuite end");
 }

 @AfterSuite
 public void afterSuite() {
	  System.out.println("afterSuite");
	
	  System.out.println("afterSuite end");
 }

}
