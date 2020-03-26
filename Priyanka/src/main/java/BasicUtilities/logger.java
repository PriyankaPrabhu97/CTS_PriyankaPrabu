package BasicUtilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class logger {
	WebDriver dr;
	Logger Log;
	public logger(WebDriver dr)
	{
		this.dr =dr;
		Log = Logger.getLogger("devpinoyLogger");
	}
	
	//function to update a log message
	public void Update_log(String Message)
	{
		
		Log.debug(Message);
	}

}
