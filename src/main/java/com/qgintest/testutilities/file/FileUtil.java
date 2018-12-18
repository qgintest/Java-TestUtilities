package com.qgintest.testutilities.file;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	
	//This is used as a sample. no value in abstracting this further. delete later
	public static void copyFileFromSourceToDestination(File source, File destination) throws Exception{
		FileUtils.copyFile(source, destination);	
	}

}
