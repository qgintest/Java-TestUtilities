package com.qgintest.testutilities.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class contains methods to write content to files
 * 
 * @author Abe Endale
 *
 */
public class WriteUtil {

	/**
	 * This method will write any content to a File. Encoding is set to UTF-8
	 * 
	 * @param file
	 *            The full path of the file passed as a String
	 * @param content
	 *            The content to be written to the file as a String
	 */
	public static void writeToFile(String file, String content) {

		Path path = Paths.get(file);
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
			writer.write(content);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
