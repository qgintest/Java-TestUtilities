package com.qgintest.testutilities.file;

import java.io.File;
import org.junit.Test;

public class FileUtilTest {

	FileUtil fileUtil = new FileUtil();

	@Test
	public void testgetWorkingDir() throws Exception {

		String dir = fileUtil.getWorkingDir();
		File file = new File(dir);

		if (!file.isDirectory()) {
			throw new Exception(file + " is not a valid directory");
		} else {
			System.out.println(file + " is a valid directory");
		}
	}

	@Test
	public void testGetFileFromResource() {
		System.out.println("resource file on root level is: " + fileUtil.getFileFromResource("root.txt"));
		System.out.println("resource file on level2 folder is: "
				+ fileUtil.getFileFromResource("level1" + File.separator + "level2" + File.separator + "level2.txt"));
	}

	@Test
	public void testReturnFileUsingWildcard() throws Exception {
		String filename = FileUtil.returnFileUsingWildcard(fileUtil.getWorkingDir() + File.separator + "src"
				+ File.separator + "test" + File.separator + "resources" + File.separator + "list",
				"*linux*");
		
		System.out.println("found file: " + filename);

	}
	
	@Test
	public void testGetPathFromResources(){
		System.out.println("PATH of resource folder: " + fileUtil.getPathFromResource("list"));
		System.out.println("PATH of resource folder: " + fileUtil.getPathFromResource("level1") + File.separator + "level2");
	}
	
	@Test
	public void testCreateFileWithParentFolders() throws Exception{
		fileUtil.createFileWithParentFolders(fileUtil.getWorkingDir() + File.separator + "config" + File.separator + "config2" + File.separator, "config.properties");
	}

}
