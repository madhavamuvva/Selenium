package sample.bdd.framework.helperclasses;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cucumber.api.cli.Main;

public class App {
	public String getBuildNumberFromProps(String key) throws IOException {
	    String propertiesName = "/build.properties";
	 
	    InputStream propertiesStream = Main.class
	            .getResourceAsStream(propertiesName);
	    if (propertiesStream != null) {
	        Properties pros = new Properties();
	        pros.load(propertiesStream);
	 
	        return pros.getProperty(key);
	    }
	    return null;
	}	
	
	public String readPropertybuildnumber(String Key) {
		Properties prop = new Properties();
		FileInputStream input = null;
		String filename = "buildNumber.properties";
		try {
			input = new FileInputStream(filename);
			// load a properties file
			prop.load(input);
			// get the property value
			return prop.getProperty(Key);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}
	

}
