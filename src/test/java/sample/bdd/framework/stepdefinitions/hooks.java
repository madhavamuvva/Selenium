package sample.bdd.framework.stepdefinitions;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import sample.bdd.framework.helperclasses.getscreenshot;
import sample.bdd.framework.helperclasses.webdriverproperty;
import sample.bdd.framework.testproperties.propertiesfile;
import sample.bdd.framework.testproperties.propertyvariable;

public class hooks {
		
	
	/**
	 * Open the browser based on the env variable
	 * 
	 */    
	
	@Before
	public void OpenBrowser() {
		
		String	browser = System.getProperty("BROWSER");
		if (browser == null) {
			browser = System.getenv("BROWSER");
			if (browser == null) {
				browser = "dockerchrome";
			}
		}
			switch (browser) {

			case "dockerfirefox":			
				Reporter.setSystemInfo("Test Started in ", "Firefox browser");
				DesiredCapabilities firefoxcapability = DesiredCapabilities.firefox();
				firefoxcapability.setBrowserName("firefox");
				//firefoxcapability.setVersion("55.0");
	            firefoxcapability.setPlatform(Platform.LINUX);
	            try {
	            webdriverproperty.driver.set(new RemoteWebDriver(new URL(propertiesfile.readProperty("seleniumhuburl")), firefoxcapability));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "dockerchrome":
				Reporter.setSystemInfo("Test Started in ", "Chrome browser");
				 DesiredCapabilities chromecapability = DesiredCapabilities.chrome();
				 chromecapability.setBrowserName("chrome");
				 chromecapability.setPlatform(Platform.LINUX);
				try {
					webdriverproperty.driver.set(new RemoteWebDriver(new URL(propertiesfile.readProperty("seleniumhuburl")), chromecapability));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "dockeredge":
				Reporter.setSystemInfo("Test Started in ", "Edge browser");
				 DesiredCapabilities edgecapability = DesiredCapabilities.edge();
				 edgecapability.setBrowserName("MicrosoftEdge");
				 edgecapability.setPlatform(Platform.LINUX);
				try {
					webdriverproperty.driver.set(new RemoteWebDriver(new URL(propertiesfile.readProperty("seleniumhuburl")), edgecapability));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println(
						"browser: " + browser + " is invalid, launching chrome browser as default browser choice");
				 DesiredCapabilities chromecapabilitydefault = DesiredCapabilities.chrome();
				 chromecapabilitydefault.setBrowserName("chrome");
				 chromecapabilitydefault.setPlatform(Platform.LINUX);
				try {
					webdriverproperty.driver.set(new RemoteWebDriver(new URL(propertiesfile.readProperty("seleniumhuburl")), chromecapabilitydefault));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
			
	}
	
	/**
	 * Take the screen shot when the test failed Close the browser on test finished
	 * 
	 * @param scenario
	 * @throws InterruptedException
	 */

	@After
	public void CloseBrowser(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			try {
				scenario.write("Test failed on the current url " + webdriverproperty.getDriver().getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot)webdriverproperty.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				try {
					Reporter.addScenarioLog("Test Scenario Failed");
					Reporter.assignAuthor("Madhava Rao Muvva");
					getscreenshot.takescreenshot(scenario.getName() + "FailedTest");
					Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") + "/"
							+ propertyvariable.screenshotpath + scenario.getName() + "FailedTest.png");
				} catch (IOException e) {

					e.printStackTrace();
				}
			} catch (WebDriverException e) {
				System.err.println(e.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			} finally {
				webdriverproperty.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			}
		}
		if (!(scenario.isFailed())) {
			try {
				scenario.write("Test case passed");
				byte[] screenshot = ((TakesScreenshot) webdriverproperty.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				try {
					Reporter.addScenarioLog("Test Scenario Passed");
					Reporter.assignAuthor("Madhava Rao Muvva");
					getscreenshot.takescreenshot(scenario.getName() + "PassedTest");
					Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") + "/"
							+ propertyvariable.screenshotpath + scenario.getName() + "PassedTest.png");
				} catch (IOException e) {

					e.printStackTrace();
				}
			} catch (WebDriverException e) {
				System.err.println(e.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			} finally {
				webdriverproperty.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			}
		}

		webdriverproperty.getDriver().quit();

	}

}
