package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class gmailInitPage {

	WebDriver driverObj;
	public gmailInitPage(WebDriver obj)
	{
		driverObj= obj;
		PageFactory.initElements(driverObj, this);
	}
	
	@FindBy(xpath="/html/body/nav/div/a[2]")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id='identifierId']")
	WebElement emailId;
	
	@FindBy(xpath="//*[@id='identifierNext']/content/span")
	WebElement emailNxt;	
			
	@FindBy(xpath="//*[@id='password']/div[1]/div/div[1]/input")
	WebElement passwd;
	
	//*[@id="view_container"]/div/div/div[2]/div/div[2]/div
	
	@FindBy(xpath="//*[@id='passwordNext']/content/span")
	WebElement passwdnext;
	
	
	
	public WebElement emailNxt(){
		return emailNxt;
	}
	public WebElement signIn(){
		return signIn;
	}
	public WebElement emailId(){
		return emailId;
	}
	public WebElement password(){
		return passwd;
	}
	public WebElement passwdnext(){
		return passwdnext;
	}
}
