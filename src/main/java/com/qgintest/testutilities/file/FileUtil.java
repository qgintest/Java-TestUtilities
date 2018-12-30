package com.qgintest.testutilities.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import com.qgintest.testutilities.App;
import com.qgintest.testutilities.date.DateUtil;

/**
 * This class has all utility methods to work with Files and Folders independent
 * of the operating system.
 * 
 * @author Abe Endale
 *
 */
public class FileUtil {

	public static String fileName = null;

	/**
	 * This method returns the runtime directory of where the program is
	 * executed. This is also known as the workspace.
	 * 
	 * @return the path of the working directory as a String.
	 */
	public String getWorkingDir() {
		return System.getProperty("user.dir");
	}

	/**
	 * This method will return the runtime path of a file that is located under
	 * a resources folder
	 * 
	 * @param filename
	 *            The filename is name of the file located in the resources
	 *            folder.
	 * @return The File path as a String.
	 */
	public String getFileFromResource(String filename) {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(filename).getFile()).toString();
	}

	/**
	 * This method will return a file from a list of files using a wildcard
	 * expression
	 * 
	 * @param folder
	 *            This is the folder that contains the files being searched.
	 *            Sub-folders not included
	 * @param fileLike
	 *            The expression to search for. e.g., *linux* will search for
	 *            the keyword 'linux' anywhere in the file name
	 * @return The matched filename as a string.
	 * @throws Exception
	 *             If no matches or more than one match is found, an exception
	 *             is thrown
	 */
	public static String returnFileUsingWildcard(String folder, String fileLike) throws Exception {

		File dir = new File(folder);
		FileFilter fileFilter = new WildcardFileFilter(fileLike);
		File[] files = dir.listFiles(fileFilter);
		String fileFound = null;

		if (files.length > 1) {
			throw new Exception("Found more than one match for expression: " + fileLike);
		} else if (files.length == 0) {
			throw new Exception("No files were found for expression: " + fileLike);
		} else {
			System.out.println("Found matching file");
			fileFound = files[0].toString();
		}
		return fileFound;
	}

	/**
	 * This method will return the runtime path of a folder that is located
	 * under a resources folder
	 * 
	 * @param folder
	 *            The folder is name of the folder located in the resources
	 *            folder.
	 * @return The Folder path as a String.
	 */
	public String getPathFromResource(String folder) {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(folder).getPath()).toString();
	}

	/**
	 * This method will create the file and its corresponding Parent folders if
	 * they do not exist
	 * 
	 * @param folderPath
	 *            The root folder where the file is located
	 * @param filename
	 *            The name of the file to be created
	 * @return The File object will be returned
	 * @throws Exception
	 *             A general exception will be thrown if a file cannot be
	 *             created.
	 */
	public File createFileWithParentFolders(String folderPath, String filename) throws Exception {
		File folder = new File(folderPath);
		folder.mkdirs();

		File file = new File(folder + File.separator + filename);

		boolean fileCreated = file.createNewFile();
		System.out.println("File: <" + file + "> :Created?: " + fileCreated);

		return file;
	}
}
