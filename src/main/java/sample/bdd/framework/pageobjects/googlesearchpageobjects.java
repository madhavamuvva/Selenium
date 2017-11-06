package sample.bdd.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sample.bdd.framework.helperclasses.helpermethods;
import sample.bdd.framework.helperclasses.webdriverproperty;

public class googlesearchpageobjects {	
	String browser ;
	public googlesearchpageobjects()
	{
		PageFactory.initElements(webdriverproperty.getDriver(), this);		
	}
	
	@FindBy(id = "lst-ib")
	public WebElement googlesearchtextbox;
	
	@FindBy(name="btnK")
	public WebElement googlesearchbutton;
	
	@FindBy(xpath="//DIV[@id='sb_ifc0']")
	public WebElement pagebodyelement;
	/*
	 * clear search text box
	 */
	public void clear_searchtextbox()
	{
		googlesearchtextbox.clear();
	}
	
	/*
	 * Enter Keyword in the search textbox
	 */
	public void enter_keyword_in_searchtextbox(String keyword)
	{
		googlesearchtextbox.sendKeys(keyword);
		pagebodyelement.click();
	}
	
	/*
	 * click google search button
	 */
	public googlesearchresultspageobjects click_googlesearchbutton()
	{
	    helpermethods.Click_button_Chrome(googlesearchbutton);		
		return new googlesearchresultspageobjects();
	}
	/*
	 * click google search button
	 */
	public void Enter_keyword_and_click_googlesearchbutton(String keyword,WebElement element, int timeout)
	{
		clear_searchtextbox();
		enter_keyword_in_searchtextbox(keyword);
		click_googlesearchbutton();
		helpermethods.ExplicitPageLoad_Until_ElementToBeClickable(element, timeout);
	}
}
