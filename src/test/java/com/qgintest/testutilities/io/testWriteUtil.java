package com.qgintest.testutilities.io;


import java.io.File;

import com.qgintest.testutilities.file.FileUtil;
import com.qgintest.testutilities.io.WriteUtil;

import org.junit.Test;

public class testWriteUtil {
	
	FileUtil fileUtil = new FileUtil();

	@Test
	public void testWriteToFile() {
		File file = new File(fileUtil.getWorkingDir() + File.separator + "config" + File.separator + "config2" + File.separator + "config.properties");
		
		WriteUtil.writeToFile(file.toString(), "dbpassword=password\ndatabase=localhost\ndbuser=user");
	}

}
