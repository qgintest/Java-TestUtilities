package com.qgintest.testutilities.date;


import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testReturnDate() {

		System.out.println("Today's date is: " + DateUtil.returnDate("yyyyMMdd", 0, 0));

		System.out.println("Tommorrow's date will be: " + DateUtil.returnDate("yyyyMMdd", 1, 0));
		
		System.out.println("Yesterdays date was: " + DateUtil.returnDate("yyyyMMdd", -1, 0));
		
		System.out.println("Next Years Date will be: " + DateUtil.returnDate("yyyyMMdd", 0, 1));
		
		System.out.println("Last Years Date was: " + DateUtil.returnDate("yyyyMMdd", 0, -1));

	}
	
	@Test
	public void testReturnTimestamp() throws Exception{
		
		String timestamp1 = null;
		String timestamp2 = null;
		
		timestamp1 = DateUtil.returnTimestamp("yyyy-MM-dd'T'HH:mm:ss.SSSZ").toString(); 
		Thread.sleep(5);
		timestamp2 = DateUtil.returnTimestamp("yyyy-MM-dd'T'HH:mm:ss.SSSZ").toString(); 
		
		Assert.assertNotEquals("timestamps are not unique", timestamp1, timestamp2);
		
	}

}
