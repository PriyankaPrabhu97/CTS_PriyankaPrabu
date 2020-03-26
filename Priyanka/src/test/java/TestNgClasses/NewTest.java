package TestNgClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasicUtilities.Browsers;
import BasicUtilities.ScreenShotss;
import ExcelDataUtils.ReadExcel;
import POM.BlousesPage;
import POM.CartPage;
import POM.Home;
import POM.LoginAndRegister;
import POM.MyAccountPage;
import POM.TshirtsPage;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;

public class NewTest {
	WebDriver dr;
	Browsers br;Home hm; LoginAndRegister lg; ReadExcel re;
	MyAccountPage ma;TshirtsPage tsp; CartPage cp; BlousesPage bl;ScreenShotss ss;
	
  @Test(dataProvider = "InvalidData")
  
  public void InvalidLogin(String username, String password, String Exp_res) {
	  
	  br = new Browsers();
	  dr = br.launchBrowser(br.Chrome,"http://automationpractice.com/index.php");
	  ss = new ScreenShotss(dr);
	  hm = new Home(dr);
	  hm.ClickOnLoginLink();
	  lg = new LoginAndRegister(dr);
	  lg.DoLogin(username, password);
	  String err =lg.InvalidEmailError();
	  ss.ScreenShott("error_msg.png");
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(err, Exp_res);
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider
  public String[][] InvalidData() {
	  re = new ReadExcel();
	  re.get_data("Login Invalid Credentials",2,3);
	  return re.testdata;
  }
  
  @Test(dataProvider = "validData")
  public void validLogin(String username, String password, String Exp_res) {
	  br = new Browsers();
	  dr = br.launchBrowser(br.Chrome,"http://automationpractice.com/index.php");
	  ss = new ScreenShotss(dr);
	  hm = new Home(dr);
	  hm.ClickOnLoginLink();
	  lg = new LoginAndRegister(dr);
	  lg.DoLogin(username, password);
	  ma= new MyAccountPage(dr);
	  String uname =ma.VerifyLogin();
	  ss.ScreenShott("AccountName.png");
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(uname, Exp_res);
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider
  public String[][] validData() {
	  re = new ReadExcel();
	  re.get_data("Valid Credentials",2,3);
	  return re.testdata;
  }

  @Test(dataProvider = "AddToCart")
  public void AddToCart(String username, String password) {
	  br = new Browsers();
	  dr = br.launchBrowser(br.Chrome,"http://automationpractice.com/index.php");
	  ss = new ScreenShotss(dr);
	  hm = new Home(dr);
	  hm.ClickOnLoginLink();
	  lg = new LoginAndRegister(dr);
	  lg.DoLogin(username, password);
	  ma= new MyAccountPage(dr);
	  ma.TShirts();
	  tsp =new TshirtsPage(dr);
	  tsp.TShirtsAddtoCart();
	  float price = tsp.VerifyPrice();
	  System.out.println(price);
	  tsp.Checkout();
	  cp =new CartPage(dr);
	  int quantity= cp.Verifyquantity();
	  System.out.println(quantity);
	  float Excpected_total = (price*quantity)+2;
	  float Actual_total = cp.VerifyTotalPrice();
	  ss.ScreenShott("Cart.png");
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(Actual_total, Excpected_total);
	  sa.assertAll(); 
	  dr.quit();
  }
  @DataProvider
  public String[][] AddToCart() {
	  re = new ReadExcel();
	  re.get_data("Valid Credentials",1,2);
	  return re.testdata;
  }
 
  @Test(dataProvider = "LoginData")
  public void ProductRemoval(String username, String password) {
	  br = new Browsers();
	  dr = br.launchBrowser(br.Chrome,"http://automationpractice.com/index.php");
	  ss = new ScreenShotss(dr);
	  hm = new Home(dr);
	  hm.ClickOnLoginLink();
	  lg = new LoginAndRegister(dr);
	  lg.DoLogin(username, password);
	  ma= new MyAccountPage(dr);
	  ma.TShirts();
	  tsp =new TshirtsPage(dr);
	  tsp.TShirtsAddtoCart();
	  tsp.Checkout();
	  cp =new CartPage(dr);
	  cp.ContinueShopping();
	  ma.Blouses();
	  bl = new BlousesPage(dr);
	  bl.BlousesAddtoCart();
	  ss.ScreenShott("CheckAdded.png");
	  bl.Checkout();
	  
	  boolean b=cp.RemoveProduct();
	  ss.ScreenShott("Removed.png");
	  SoftAssert sa = new SoftAssert();
	  sa.assertFalse(b);	  
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider
  public String[][] LoginData() {
	  re = new ReadExcel();
	  re.get_data("Valid Credentials",1,2);
	  return re.testdata;
  }
  
  
  
}
