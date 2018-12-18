package com.qgintest.testutilities.resource;


import org.junit.Test;

public class ResourceUtilTest {
	
	ResourceUtil resourceUtil = new ResourceUtil();

	
	@Test
	public void test() {		
		System.out.println("File returned is: " + resourceUtil.getFileFromResources("testinput.txt"));
	}

}
