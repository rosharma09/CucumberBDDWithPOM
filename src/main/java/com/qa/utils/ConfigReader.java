package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties propObj;

	/**
	 * This method is used to load the properties from the config.properties file
	 * 
	 * @return This return the Properties instance object with the loaded
	 *         config.properties file
	 */

	public Properties init_prop() {

		propObj = new Properties();
		try {
			FileInputStream fileInputObj = new FileInputStream("./src/test/resources/com/qa/config/config.properties");
			propObj.load(fileInputObj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not Found at the Specified path :");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Exception Occured :");
		}

		return propObj;
	}

}
