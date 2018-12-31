package com.qgintest.testutilities.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class has utilities to read and parse text
 * 
 * @author abeinatorair
 *
 */
public class ReadUtil {

	/**
	 * This method loads a Properties object
	 * 
	 * @param propFile
	 *            The fullpath of the properties file as a String
	 * @return The loaded Properties object
	 * @throws Exception
	 *             General Exception will be thrown if any errors occur
	 */
	public static Properties loadPropertiesFile(String propFile) throws Exception {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(propFile);

		prop.load(input);
		return prop;
	}

}
