package sample.bdd.framework.helperclasses;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.listener.Reporter;

import sample.bdd.framework.testproperties.propertyvariable;

public class helpermethods {
	public static String winHandleBefore;
	public static RemoteWebDriver driver;

	/**
	 * Explicitly wait for the condition to happen
	 */
	public static void Navigate_to_HomePage(int timeout) {
		// Navigate to the url of the website
		webdriverproperty.getDriver().get(propertyvariable.siteUrl);
		// Maximise the window
		webdriverproperty.getDriver().manage().window().setSize(new Dimension(1920, 1080));
		// Implicitly Wait for the page to load
		helpermethods.ImplicitPageLoad(timeout);
	}

	/**
	 * Explicitly wait for the condition to happen
	 */
	public static void ExplicitPageLoad_Until_ElementToBeClickable(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(webdriverproperty.getDriver(), timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Implicitly wait for the page to load
	 */
	public static void ImplicitPageLoad(int timeout) {
		webdriverproperty.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	/**
	 * Verify if the element present or not
	 */
	public static boolean isElementPresnt(WebElement element) {
		helpermethods.ImplicitPageLoad(0);
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException nsee) {
			// TODO: handle exception
			System.err.println(nsee);
			return false;
		} finally {
			helpermethods.ImplicitPageLoad(0);
		}
	}

	/**
	 * Click on the buttons
	 */
	public static void Click_button_Chrome(WebElement element) {

		Actions action = new Actions(webdriverproperty.getDriver());
		action.moveToElement(element).click().build().perform();

	}

	/**
	 * get the title of an element
	 */
	public static String getPageTitle() {
		return webdriverproperty.getDriver().getTitle();
	}

	/**
	 * get the text of an element
	 */
	public static String getPageText(WebElement element) {
		return element.getText().trim();
	}

	/**
	 * get the text of an element
	 */
	public static String getPageTextattribute(WebElement element) {
		return element.getAttribute("textContent").trim();
	}

	/**
	 * add screenshot of step add screenshot to extent report add a step log message
	 */
	public static void add_StepMessage_TakeScreenshot_Attach_to_Extent_Report(String message,
			String Screenshotfilename) {
		try {
			getscreenshot.takescreenshot(Screenshotfilename);
			Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") + "/" + propertyvariable.screenshotpath
					+ Screenshotfilename + ".png");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addStepLog(message);
	}

	/**
	 * Store the current window
	 */
	public static void Store_Current_Window() {
		// Store the current window handle
		winHandleBefore = webdriverproperty.getDriver().getWindowHandle();
	}

	/**
	 * Switch to a new window or pop up
	 */
	public static void Switch_to_NewWindow() {

		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : webdriverproperty.getDriver().getWindowHandles()) {
			webdriverproperty.getDriver().switchTo().window(winHandle);
		}

	}

	/**
	 * Switch back to current window
	 */
	public static void Switch_back_to_CurrentWindow() {
		// Switch back to original browser (first window)
		webdriverproperty.getDriver().switchTo().window(winHandleBefore);
	}

	/**
	 * Get the date and time
	 */
	public static String Get_Today_Date_and_Time() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * generating a random number
	 */
	public static String generaterandonnumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

}
