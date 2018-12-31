package com.qgintest.testutilities.io;


import java.io.File;
import java.util.Properties;

import org.junit.Test;

import com.qgintest.testutilities.file.FileUtil;
import com.qgintest.testutilities.io.ReadUtil;

public class testReadUtil {
	
	FileUtil fileUtil = new FileUtil();


	@Test
	public void testLoadPropertiesFile() throws Exception {
		Properties prop = new Properties();
		prop = ReadUtil.loadPropertiesFile(fileUtil.getWorkingDir() + File.separator + "config" + File.separator + "config2" + File.separator + "config.properties");
		System.out.println(prop.getProperty("key1"));
	}

}
