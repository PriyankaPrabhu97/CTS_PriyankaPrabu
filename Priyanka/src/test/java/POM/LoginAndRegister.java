package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class LoginAndRegister {
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss ;MyAccountPage Ap; 
	
	public LoginAndRegister(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
		Ap = new MyAccountPage(dr);
	}
	
	public void EnterUserName(String username)
	{
		By by_ele = By.xpath("//h3[text()='Already registered?']//parent::form//div//input[@id='email']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.sendKeys(username);
	}
	
	public void EnterPassword(String password)
	{
		By by_ele = By.xpath("//h3[text()='Already registered?']//parent::form//div//input[@id='passwd']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.sendKeys(password);
	}
	
	public void ClickLoginBTn()
	{
		By by_ele = By.xpath("//button[@id='SubmitLogin']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
	}
	
	public String InvalidEmailError()
	{
		By by_ele = By.xpath("//p[contains(text(),'There is 1 error')]//parent::div//li");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		return we.getText();
	}
	
	public void DoLogin(String userName, String Password)
	{
		this.EnterUserName(userName);
		this.EnterPassword(Password);
		ss.ScreenShott("LoginCredentials.png");
		log.Update_log(" login checked for data "+userName+" "+Password);
		this.ClickLoginBTn();		
	}
}
