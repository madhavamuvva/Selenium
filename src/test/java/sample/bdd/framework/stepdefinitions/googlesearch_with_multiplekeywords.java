package sample.bdd.framework.stepdefinitions;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sample.bdd.framework.exceptions.wrongpageexception;
import sample.bdd.framework.helperclasses.helpermethods;
import sample.bdd.framework.helperclasses.webdriverproperty;
import sample.bdd.framework.pageobjects.googlesearchpageobjects;
import sample.bdd.framework.pageobjects.googlesearchresultspageobjects;
import sample.bdd.framework.testproperties.propertiesfile;

public class googlesearch_with_multiplekeywords {

	googlesearchpageobjects googlesearch = new googlesearchpageobjects();
	private int timeout = Integer.parseInt(propertiesfile.readProperty("timeout"));

	@Given("^user in the google home page$")
	public void user_in_the_google_home_page() throws Throwable {
		helpermethods.Navigate_to_HomePage(timeout);
		if(!helpermethods.getPageTitle().contains("Google"))
	    {
	    		throw new wrongpageexception("webdriver is in the wrong page : " + webdriverproperty.getDriver().getCurrentUrl());
	    }
		helpermethods.add_StepMessage_TakeScreenshot_Attach_to_Extent_Report("User Sucessfully Navigated to the Google Home Page", getClass().getName()+"Given");
	}

	@When("^user search with \"([^\"]*)\" in google search text box$")
	public void user_search_with_in_google_search_text_box(String keyword) throws Throwable {
		googlesearch.enter_keyword_in_searchtextbox(keyword);		
		helpermethods.add_StepMessage_TakeScreenshot_Attach_to_Extent_Report("User Sucessfully Entered the keyword", getClass().getName()+"When");
	}

	@When("^user clicked on the google search button1$")
	public void user_clicked_on_the_google_search_button() throws Throwable {
		googlesearch.click_googlesearchbutton();
		helpermethods.ExplicitPageLoad_Until_ElementToBeClickable(new googlesearchresultspageobjects().seleniumwebdriverlink, timeout);
		helpermethods.add_StepMessage_TakeScreenshot_Attach_to_Extent_Report("User Sucessfully clicked on the google search button", getClass().getName()+"When1");
	}

	@Then("^user should navigate to the search results page with title \"([^\"]*)\"$")
	public void user_should_navigate_to_the_search_results_page_with_title(String expectedtitle) throws Throwable {
		String actualtitle = helpermethods.getPageTitle();
		assertEquals(expectedtitle, actualtitle);		
	}
}
