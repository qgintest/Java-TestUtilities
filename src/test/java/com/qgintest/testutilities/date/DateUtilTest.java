package com.qgintest.testutilities.date;


import org.junit.Test;

public class DateUtilTest {

	@Test
	public void test() {

		System.out.println("Today's date is: " + DateUtil.returnDate("yyyyMMdd", 0, 0));

		System.out.println("Tommorrow's date will be: " + DateUtil.returnDate("yyyyMMdd", 1, 0));
		
		System.out.println("Yesterdays date was: " + DateUtil.returnDate("yyyyMMdd", -1, 0));
		
		System.out.println("Next Years Date will be: " + DateUtil.returnDate("yyyyMMdd", 0, 1));
		
		System.out.println("Last Years Date was: " + DateUtil.returnDate("yyyyMMdd", 0, -1));

	}

}
