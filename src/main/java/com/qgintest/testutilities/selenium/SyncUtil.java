package com.qgintest.testutilities.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qgintest.testutilities.io.regex.RegExUtil;

/**
 * This class contains methods that that work with Selenium Webdriver related
 * synchornization classes. They help interacting with WebElements and help
 * mitigate exceptions such as NoSuchElementFound
 * 
 * @author Abe Endale
 *
 */
public class SyncUtil {

	/**
	 * This method will attempt to click on a WebElement only after it is
	 * visible and clickable on the DOM
	 * 
	 * @param driver
	 *            The WebDriver interface
	 * @param wait
	 *            The WebDriver wait class
	 * @param CustomLocator
	 *            The type of locator being used to interact with the
	 *            WebElement. possible types include; id, linkText, Xpath, and
	 *            CSS.
	 * @param CustomWait
	 *            he amount of time user will wait until the element becomes
	 *            visible. Polls every 500 milliseconds.
	 */
	public static void waitForElementToBeClickable(WebDriver driver, WebDriverWait wait, WebElement CustomLocator,
			int CustomWait) {
		wait = new WebDriverWait(driver, CustomWait);
		wait.until(ExpectedConditions.elementToBeClickable(CustomLocator));
	}

	/**
	 * This method will attempt to find a WebElement only after it is visible on
	 * the DOM.
	 * 
	 * @param driver
	 *            The WebDriver interface
	 * @param wait
	 *            The WebDriver wait class
	 * @param CustomLocator
	 *            The type of locator being used to interact with the
	 *            WebElement. possible types include; id, linkText, Xpath, and
	 *            CSS.
	 * @param CustomWait
	 *            he amount of time user will wait until the element becomes
	 *            visible. Polls every 500 milliseconds.
	 */
	public static void waitForElementToBeVisible(WebDriver driver, WebDriverWait wait, WebElement CustomLocator,
			int CustomWait) {
		wait = new WebDriverWait(driver, CustomWait);
		wait.until(ExpectedConditions.visibilityOf(CustomLocator));
	}

	/**
	 * This method will attempt to find a WebElement only after it is visible on
	 * the DOM.
	 * 
	 * @param driver
	 *            The WebDriver interface
	 * @param wait
	 *            The WebDriver wait class
	 * @param CustomLocator
	 *            The type of locator being used to interact with the
	 *            WebElement. possible types include; id, linkText, Xpath, and
	 *            CSS.
	 * @param CustomWait
	 *            he amount of time user will wait until the element becomes
	 *            visible. Polls every 500 milliseconds.
	 */
	public static void waitForElementToBeInVisible(WebDriver driver, WebDriverWait wait, WebElement CustomLocator,
			int CustomWait) {
		wait = new WebDriverWait(driver, CustomWait);
		wait.until(ExpectedConditions.invisibilityOf(CustomLocator));
	}

	/**
	 * This method will attempt to find a WebElement only after it is invisible
	 * on the DOM. Useful for negative testing
	 * 
	 * @param driver
	 *            The WebDriver interface
	 * @param wait
	 *            The WebDriver wait class
	 * @param CustomLocator
	 *            The type of locator being used to interact with the
	 *            WebElement. possible types include; id, linkText, Xpath, and
	 *            CSS.
	 * @param CustomWait
	 *            he amount of time user will wait until the element becomes
	 *            visible. Polls every 500 milliseconds.
	 */
	public static void waitForElementToBeStaleness(WebDriver driver, WebDriverWait wait, WebElement CustomLocator,
			int CustomWait) {
		wait = new WebDriverWait(driver, CustomWait);
		wait.until(ExpectedConditions.stalenessOf(CustomLocator));
	}

	/**
	 * This method will perform a page check to ensure the loaded page passed by
	 * Selenium WebDriver matches the expected page
	 * 
	 * @param driver
	 *            This is the WebDriver object passed
	 * @param titleCheck
	 *            This is the boolean indicator if a title page check will be
	 *            used
	 * @param pageSourceCheck
	 *            This is the boolean indicator if a page source check will be
	 *            used
	 * @param expectedValues
	 *            These are the expected values for title page and keyword(s)
	 *            that should exist within the loaded page source
	 * @return A statement of true or false will return whether or not the
	 *         checks passed.
	 */
	public static boolean pageCheck(WebDriver driver, boolean titleCheck, boolean pageSourceCheck,
			String... expectedValues) {

		if (expectedValues.length == 1) {
			String pageTitle = driver.getTitle();
			if (pageTitle.equals(expectedValues[0])) {
				System.out.println("Expected page: " + expectedValues[0] + " matches actual page: " + pageTitle);
				return true;
			} else {
				System.out.println("Expected page: " + expectedValues[0] + " does NOT match actual page: " + pageTitle);
				return false;
			}
		} else if (expectedValues.length == 2) {
			String pageTitle = driver.getTitle();
			String pageSource = driver.getPageSource();

			if (pageTitle.equals(expectedValues[0])
					&& RegExUtil.runRegEx("(?i)" + expectedValues[0], pageSource) == true) {
				System.out.println("Expected page: " + expectedValues[0] + " matches actual page: " + pageTitle);
				return true;
			} else {
				System.out
						.println("Expected page: " + expectedValues[0] + " does NOT matche actual page: " + pageTitle);
				return false;
			}
		} else {
			System.out.println("Invalid number or arguments.");
			return false;
		}
	}

}
