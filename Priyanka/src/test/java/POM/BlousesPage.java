package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class BlousesPage {
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss; 
	
	public BlousesPage(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
	
	// function to add a product to the cart
	public void BlousesAddtoCart()
	{
		Actions aa = new Actions(dr);
		By by_ele = By.xpath("//ul[@class='product_list grid row']//li[1]");
		WebElement we = wt.WaitForElement(by_ele, 10);
		aa.moveToElement(we).build().perform();
		by_ele = By.xpath("//a[@title='Add to cart']");
		we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
		log.Update_log("Clicked Add to cart button ");
	}
	
	
	//function to checkout
	public void Checkout()
	{
		By by_ele = By.xpath("//a[@title='Proceed to checkout']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
		log.Update_log("Clicked checkout");
	}
	
}
