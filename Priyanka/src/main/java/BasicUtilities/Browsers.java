package BasicUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
	
	public String Chrome ="CHROME";
	public String FireFox="Firefox";
	WebDriver dr;
	logger log;
	
	
	//Function to Launch the Browser
	public WebDriver launchBrowser(String BrowserType, String Url)
	{
		
		switch(BrowserType)
		{
		// to launch Chrome
		case"CHROME":
		{
			String DriverPath ="src\\test\\resources\\DRIVER\\chromedriver_v80.exe";
			System.setProperty("webdriver.chrome.driver", DriverPath);
			 dr = new ChromeDriver(); 										
			 dr.manage().window().maximize();								//maximize window
			 dr.get(Url);
			 dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	//implicit wait
			 log=new logger(dr);
			 log.Update_log("chrome browser Successfully Launched!!");
	
			 break;
		}
		
		// to launch FireFox
		case "Firefox":
		{
			String DriverPath ="src\\test\\resources\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", DriverPath);
			 dr = new FirefoxDriver(); 
			 dr.get(Url);
			 dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	//implicit wait
			 log=new logger(dr);
			 log.Update_log("FiREfox  browser Successfully Launched!!");
			 
			 break;
		}
		default:
			System.out.println("Available browsers are "+Chrome+ " and "+FireFox);
		}
		return dr;
	}


}
