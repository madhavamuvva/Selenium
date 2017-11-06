package sample.bdd.framework.helperclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class webdriverproperty {
		
		//ThreadLocal will keep local copy of driver
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
		 public static WebDriver getDriver() {
		        return driver.get();
		    }
	
}

