package sample.bdd.framework.helperclasses;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cucumber.api.cli.Main;

public class App {
	public String getBuildNumberFromProps() throws IOException {
	    String propertiesName = "/build.properties";
	 
	    InputStream propertiesStream = Main.class
	            .getResourceAsStream(propertiesName);
	    if (propertiesStream != null) {
	        Properties pros = new Properties();
	        pros.load(propertiesStream);
	 
	        return pros.getProperty("buildNumber");
	    }
	    return null;
	}

}
