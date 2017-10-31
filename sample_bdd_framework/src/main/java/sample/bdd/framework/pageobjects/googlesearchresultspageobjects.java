package sample.bdd.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sample.bdd.framework.helperclasses.webdriverproperty;

public class googlesearchresultspageobjects {
	public googlesearchresultspageobjects()
	{
		PageFactory.initElements(webdriverproperty.getDriver(), this);		
	}
	
	@FindBy(linkText="Selenium - Web Browser Automation")
	public WebElement seleniumlink;
	
	@FindBy(linkText="Selenium WebDriver")
	public WebElement seleniumwebdriverlink;
	
	
}
