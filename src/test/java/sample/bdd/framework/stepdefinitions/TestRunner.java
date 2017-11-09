package sample.bdd.framework.stepdefinitions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import sample.bdd.framework.helperclasses.App;
import sample.bdd.framework.testproperties.propertiesfile;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "sample.bdd.framework.stepdefinitions", dryRun = false, plugin = {
		"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:" })

public class TestRunner {
		
	@BeforeClass
	public static void setup() {
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("target/cucumber/extentreport.html");
	    extentProperties.setExtentXServerUrl(propertiesfile.readProperty("extentserverurl"));
	    extentProperties.setProjectName("sampleproject");	 
	}

	@AfterClass
	public static void teardown() throws Exception {
		Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "LINUX");
		Reporter.setTestRunnerOutput("Sample test runner output message");			
		Reporter.setSystemInfo("buildno",new App().getBuildNumberFromProps("versionNumber") +" - "+new App().readPropertybuildnumber("buildNumber"));
	}

}
