package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gmailUtilities.base;
import gmailUtilities.gmailInitCompose;

public class ComposeMailing extends base{
	WebDriverWait wait = new WebDriverWait(driverObj,5);
	gmailInitCompose g3 = new gmailInitCompose(driverObj);
	
	@Test(priority=1,dataProvider="getComposeDetails")
	public void compose(String to, String subjInp, String body) 
	{
		String toEmailId = to;
		String subject = subjInp;
		String mesgBody = body;
		
		System.out.println("compose start");
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(g3.getcomposeBtn()));
		g3.getcomposeBtn().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(g3.gettoEmailId()));
		
		g3.gettoEmailId().sendKeys(toEmailId);
		g3.getsubjBox().sendKeys(subject);
		g3.getmesgBody().sendKeys(mesgBody);
		g3.getsendBtn().click();
		
		if(toEmailId.isEmpty())
		{
			if(driverObj.findElements((By) g3.gettoIdErrTxt()).size() == 0)
			{
				Assert.assertFalse(true,"error message is not present for empty reciepient");
			}
			g3.gettoIdErrOk().click();
		}
		else
		{
			if((subject.isEmpty()) && (mesgBody.isEmpty())) {
				if(wait.until(ExpectedConditions.alertIsPresent()) == null) {
					Assert.assertFalse(true,"Alert is not present when subject and body is empty");
				}
				Assert.assertEquals(driverObj.switchTo().alert().getText(), "Send this message without a subject or text in the body?","incorrect alert message");
				
				
				//cancel and send again
				driverObj.switchTo().alert().dismiss();
				g3.getsendBtn().click();
				driverObj.switchTo().alert().accept();
			}
		}
		
		
		System.out.println("compose end");
		
	}
	
	@Test(priority=2)
	public void logout() 
	{
		//to logout
		g3.getlogoutImg().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) g3.getlogoutBtn()));
		g3.getlogoutBtn().click();
		
	}
 @DataProvider
 public Object[][] getComposeDetails() {
	  Object[][] data = {{"user1@gmail.com","Incubyte","Automation QA test for incubyte"},
	  		{"user1@gmail.com","",""},{"user1@gmail.com,user2@gmail.com","",""}};
   		  			     
     return data;
  
 }
 
 @AfterSuite
 public void afterSuite() {
	 driverObj.close();
 }


}
