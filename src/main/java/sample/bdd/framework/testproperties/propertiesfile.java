package sample.bdd.framework.testproperties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesfile {

	public static String readProperty(String Key) {
		Properties prop = new Properties();
		FileInputStream input = null;
		String filename = "src/test/resources/testproperties.properties";
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
