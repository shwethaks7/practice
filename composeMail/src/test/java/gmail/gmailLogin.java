package gmail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import gmailUtilities.base;
import gmailUtilities.gmailInitPage;
import gmailUtilities.gmailInitPswdPage;


public class gmailLogin extends base{
	WebDriverWait wait = new WebDriverWait(driverObj,5);
	@Test(priority=1)
	public void fnGmailUsrLogin()
	{
		System.out.println("gmail user login start");
		driverObj.get("https://www.gmail.com");
		driverObj.manage().window().maximize();
		Assert.assertEquals(driverObj.getTitle(), "Gmail");
		
		//for already exisiting user id, gmail is restricting for automated scripts.
		//hence create a dummy user id to test the same.
		gmailInitPage g1 = new gmailInitPage(driverObj);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) g1.getidentifier()));
		g1.getidentifier().sendKeys(userId);
		g1.getUsrClickNxt().click();
		Assert.assertFalse(g1.getUserInvalid().isDisplayed(),"incorrect user id");
		
		
		System.out.println("gmail user login end");
		
	}
	
	@Test(priority=2)
	public void fnGmailPaswdLogin()
	{
		System.out.println("gmail paswd login start");
		
		gmailInitPswdPage g2 = new gmailInitPswdPage(driverObj);
		
		wait.until(ExpectedConditions.elementToBeClickable(g2.getpassword()));
		g2.getpassword().sendKeys(paswd);
		g2.getPaswdClickNxt().click();
		if(driverObj.findElements((By) g2.getPaswdInvalid()).size()>0)
		{
			Assert.assertFalse(true,"incorrect password");
		}
		
		System.out.println("gmail paswd login end");
		
	}
	@BeforeClass
	 public void beforeClass() throws IOException {
		  System.out.println("beforeClass");
		  
		//Set the browser 
			driverObj=  initializedriver();
	 }
	
	
}
