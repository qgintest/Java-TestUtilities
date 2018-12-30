package com.qgintest.testutilities.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class contains all utility methods for Dates and Times
 * 
 * @author Abe Endale
 *
 */
public class DateUtil {

	/**
	 * This method returns a date format such as yyyMMdd. It also allows to add
	 * or subtract days/years within the returned date.
	 * 
	 * @param dateFormat
	 *            such as yyyyMMdd. A complete list of valid types are found
	 *            here
	 *            https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	 * @param days
	 *            the number of days to add or subtract within the returned date
	 * @param years
	 *            the number of years to add or subtract within the returned
	 *            date
	 * @return the date as an object
	 */
	public static Object returnDate(String dateFormat, int days, int years) {

		String dateToStr = null;

		try {

			Date curDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			dateToStr = format.format(curDate);

			Calendar cal = Calendar.getInstance();
			cal.setTime(format.parse(dateToStr));

			if (days != 0)
				cal.add(Calendar.DATE, days);
			if (years != 0)
				cal.add(Calendar.YEAR, years);

			dateToStr = format.format(cal.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateToStr;
	}

	/**
	 * This method returns a timestamp date based on a certain format.
	 * valid formats are found here https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	 * @param format The format the timestamp should display as. example, yyyyMMdd.HHmmss
	 * @return the timestamp as an object
	 */
	public static Object returnTimestamp(String format){
		return new SimpleDateFormat(format).format(new Date());
	}
	
	/**
	 * This method returns a timestamp date based on a certain format as Epoch Time
	 * valid formats are found here https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	 * @param format The format the timestamp should display as. example, yyyyMMdd.HHmmss
	 * @param epochTime The epochTimestamp as a string value
	 * @return the timestamp as an object
	 */
    public static Object returnTimestampAsEpochTime(String format, String epochTime) {

        //Convert epochMili to standard time
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Long value = Long.valueOf(epochTime);
        return sdf.format(new Date(value));
    }
}
