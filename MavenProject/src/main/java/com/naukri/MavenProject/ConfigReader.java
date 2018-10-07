package com.naukri.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;




public class ConfigReader {
	public static Properties prop;

		public ConfigReader() {
			try {
			File src = new File("F:\\Eclipse_Job\\MavenProject\\Configurations\\Config.property");
			FileInputStream fis= new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		//TO BE USED TO CALL CONFIGURATIONS DEFINED IN PROPERTIES FILE
		public static String loadproperty(String Propertyname) {
				return prop.getProperty(Propertyname);
		}
		
		
		
}
