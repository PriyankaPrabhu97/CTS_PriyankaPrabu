package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class CartPage {

	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss; 
	
	public CartPage(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
	

	//function to verify the quantity of product
	public int Verifyquantity()
	{
		By by_ele = By.xpath("//table[@id='cart_summary']//tbody//tr//td[5]//input[2]");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		String s= we.getAttribute("value");
		int quantity = Integer.parseInt(s);
		return quantity;
	}
	
	//function to verify the Total Price
	public float VerifyTotalPrice()
	{
		By by_ele = By.xpath("//table[@id='cart_summary']//tfoot//tr[7]//td[2]");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		String s=we.getText();
		String s1 = s.substring(1);
		float price = Float.parseFloat(s1);
		return price;
	}
	
	
	//function to click on continue Shopping
	public void ContinueShopping()
	{
		By by_ele = By.xpath("//a[@title='Continue shopping']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
		log.Update_log("Clicked on continue shopping ");
	}
	
	//function to remove product
	public Boolean RemoveProduct()
	{
		By by_ele = By.xpath("//table[@id='cart_summary']//tbody//tr[2]//td[7]//a");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
		log.Update_log("Clicked on delete product");
		wt.Sleep(3000);
		Boolean s;
		try {
			s=	dr.findElement(By.partialLinkText("Blouse")).isDisplayed();
		}
		catch(Exception e)
		{
			s=false;
		}
		return s;
	}
	
}
