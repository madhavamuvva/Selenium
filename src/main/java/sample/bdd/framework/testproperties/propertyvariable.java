package sample.bdd.framework.testproperties;
public class propertyvariable {	
		
		public static String siteUrl= propertiesfile.readProperty("siteUrl");
		public int timeout = Integer.parseInt(propertiesfile.readProperty("timeout"));
		public static String screenshotpath= propertiesfile.readProperty("screenshotpath");
		public static String expected_Registartion_Successful_Message= propertiesfile.readProperty("expected_Registartion_Successful_Message");
		public static String expectedpagetitle=propertiesfile.readProperty("expectedpagetitle");
				
}
