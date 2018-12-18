package com.qgintest.testutilities.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String returnDate(String dateFormat, int days, int years){

		String dateToStr = null;

		try{

			Date curDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			dateToStr = format.format(curDate);

			Calendar cal = Calendar.getInstance();
			cal.setTime(format.parse(dateToStr));

			if(days !=0) cal.add(Calendar.DATE, days);
			if(years !=0) cal.add(Calendar.YEAR, years);

			dateToStr = format.format(cal.getTime());

		}catch(Exception e){
			e.printStackTrace();
		}

		return dateToStr;
	}

}
