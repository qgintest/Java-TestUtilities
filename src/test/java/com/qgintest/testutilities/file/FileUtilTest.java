package com.qgintest.testutilities.file;


import java.io.File;

import org.junit.Test;

import com.qgintest.testutilities.resource.ResourceUtil;

public class FileUtilTest {
	
	ResourceUtil resourceUtil = new ResourceUtil();


	@Test
	public void test() throws Exception {
		
		File outputFile = new File("testOuput.txt");
		
		FileUtil.copyFileFromSourceToDestination(resourceUtil.getFileFromResources("testinput.txt"), outputFile);
	}

}
