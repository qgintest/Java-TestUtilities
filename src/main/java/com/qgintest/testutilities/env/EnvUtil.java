package com.qgintest.testutilities.env;

import java.net.InetAddress;

/**
 * This class contains methods that work with environment variables such as
 * getting runtime OS, logged in user, and other functions related to
 * Environment.
 * 
 * @author Abe Endale
 *
 */
public class EnvUtil {

	/**
	 * This method will return the OS that the JVM is currently running on. An
	 * uppercase version will be returned to simplify further conditions
	 * 
	 * @return The runtime OS (Operating system)
	 * @throws Exception An exception is thrown if an unknown OS type is found. Valid types are \n WINDOWS, MACOS, and LINUX
	 */
	public String getRunTimeOsSimplified() throws Exception {
		String OS = System.getProperty("os.name").toLowerCase();

		if (OS.contains("win")) {
			return "WINDOWS";
		} else if (OS.contains("mac")) {
			return "MACOS";
		} else if (OS.contains("nux")) {
			return "LINUX";
		} else {
			throw new Exception("Unknown Operating System: " + OS);
		}
	}

	/**
	 * This method returns the Operating System the JVM is currently running on
	 * 
	 * @return The Operating System as a String.
	 */
	public String getRunTimeOS() {
		return System.getProperty("os.name");
	}

	/**
	 * The method returns the logged in username where JVM is running.
	 * 
	 * @return The username as a String.
	 */
	public String getSystemUserName() {
		return System.getProperty("user.name");
	}

	/**
	 * This method returns the hostname of the machine where JVM is running on.
	 * 
	 * @return The hostname as a String
	 * @throws Exception
	 *             if the hostname is unknown
	 */
	public String getHostName() throws Exception {
		return InetAddress.getLocalHost().getHostName();
	}
}
