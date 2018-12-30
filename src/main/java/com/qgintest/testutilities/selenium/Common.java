package com.qgintest.testutilities.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qgintest.testutilities.date.DateUtil;

public class Common {
	
	/**
	 * This method will take a screenshot using the Selenium WebDriver interface
	 * @param driver The WebDriver used to access the Screenshot library
	 * @param filename The filename as a String
	 */
    public static void takeScreenshot(WebDriver driver, String filename){

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(filename + "_" + DateUtil.returnTimestamp("yyyyMMdd.HHmmss.SSSXXX") +".png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
