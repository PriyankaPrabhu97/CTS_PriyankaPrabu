package BasicUtilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotss {
	
	static int counter =0;
	 WebDriver dr;
	logger log;
	
	public ScreenShotss(WebDriver dr)
	{
		this.dr =dr;
		log =new logger(dr);
	}
	
	 // function to take a screenshot
	public void ScreenShott(String FileName)
	{
		String	path="src\\test\\resources\\Screenshots\\";
		File f1 = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		File f2 = new File(path+FileName);
		try {
			FileUtils.copyFile(f1, f2);
			log.Update_log("ScreenShot taken in name of "+FileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.Update_log("Error in taking ScreenShots");
		}
				
		counter++;
	}
}

