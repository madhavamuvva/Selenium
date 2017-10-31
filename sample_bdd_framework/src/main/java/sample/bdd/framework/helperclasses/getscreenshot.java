package sample.bdd.framework.helperclasses;

import java.io.File;
import java.io.IOException;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import sample.bdd.framework.testproperties.propertyvariable;

public class getscreenshot {
	/**
	 * get the screenshot of the page
	 * @throws InterruptedException 
	 */
	public static void takescreenshot(String filename) throws InterruptedException
	{
		File src = ((TakesScreenshot)webdriverproperty.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(src, new File(propertyvariable.screenshotpath+filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
