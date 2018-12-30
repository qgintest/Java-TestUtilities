package com.qgintest.testutilities.env;


import org.junit.Test;

public class EnvUtilTest {
	
	EnvUtil envUtil = new EnvUtil();

	@Test
	public void testGetRunTimeOS() throws Exception {
		System.out.println("Current Operating System is: " + envUtil.getRunTimeOsSimplified());		
	}
	
	@Test
	public void testGetSystemUserName() throws Exception {
		System.out.println("Current System User is: " + envUtil.getSystemUserName());		
	}
	
	@Test
	public void testGetHostName() throws Exception {
		System.out.println("Hostname of machine is: " + envUtil.getHostName());		
	}
}
