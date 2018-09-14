package gmailPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dummy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driverObj;
		System.setProperty("webdriver.chrome.driver", "D:\\shwetha\\selenium\\thirdpartyExe\\chromedriver.exe");
		driverObj = new ChromeDriver();
		driverObj.get("https://www.google.com");
		
		driverObj.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("hello");
		driverObj.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).click();
		
		driverObj.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("shwetha.ks7@gmail.com");
		
	}

}
