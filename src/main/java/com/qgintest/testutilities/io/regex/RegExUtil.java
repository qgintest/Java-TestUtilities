package com.qgintest.testutilities.io.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {

	/**
	 * This method will validate most regular expressions including line
	 * terminators
	 * 
	 * @param expression
	 *            The regular expression that is used for validation
	 * @param content
	 *            The entire content that that the expression is validating
	 *            against
	 * @return The result of the match in the form of a boolean value
	 */
	public static boolean runRegEx(String expression, String content) {

		System.out.println("Regex Expression Being evaluated: " + expression);

		Pattern addressPattern = Pattern.compile(expression, Pattern.DOTALL);
		Matcher matcher = addressPattern.matcher(content);

		return matcher.find();
	}

}
