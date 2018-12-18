package com.qgintest.testutilities.resource;

import java.io.File;

public class ResourceUtil {
	
	public File getFileFromResources(String fileName){
		ClassLoader classloader = getClass().getClassLoader();
		return new File(classloader.getResource(fileName).getFile());
	}
}
