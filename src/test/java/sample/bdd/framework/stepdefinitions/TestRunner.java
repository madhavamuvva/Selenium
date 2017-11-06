package sample.bdd.framework.stepdefinitions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "sample.bdd.framework.stepdefinitions", dryRun = false, plugin = {
		"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber/extentreport.html" })

public class TestRunner {

	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Mac OSX");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}

}
