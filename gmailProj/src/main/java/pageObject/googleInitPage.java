package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleInitPage {
	
	WebDriver driverObj1;
	
	public googleInitPage(WebDriver obj){
		driverObj1=obj;
		PageFactory.initElements(driverObj1,this);
	}
	
	@FindBy(xpath="//*[@id='gbw']/div/div/div[1]/div[1]/a")
	WebElement gmailLink;
	
	public WebElement gmailLink()
	{
		return gmailLink;
	}
	
}


