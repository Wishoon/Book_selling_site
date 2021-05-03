package com.sales.book.common;

import java.text.DecimalFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class CalcSearchPeriod {
	
	public String calcSearchPeriod(String year, String month, String day, String fixedSearchPeriod) {
		
		String beginDate = null;
		String endDate = null;
		String endYear = null;
		String endMonth = null;
		String endDay = null;
		String beginYear = null;
		String beginMonth = null;
		String beginDay = null;
		
		DecimalFormat df = new DecimalFormat("00");
		Calendar cal = Calendar.getInstance();
		
		endYear = Integer.toString(cal.get(Calendar.YEAR));
		endMonth = Integer.toString(cal.get(Calendar.MONTH)+1);
		endDay = Integer.toString(cal.get(Calendar.DATE));
		endDate = endYear + "-" + endMonth + "-" + endDay; 
		
		if(fixedSearchPeriod == null) {
			cal.add(cal.MONTH, -4);
		} else if(fixedSearchPeriod.equals("one_week")) {
			cal.add(Calendar.DAY_OF_YEAR, -7);
		} else if(fixedSearchPeriod.equals("two_week")) {
			cal.add(Calendar.DAY_OF_YEAR, -14);
		} else if(fixedSearchPeriod.equals("one_month")) {
			cal.add(cal.MONTH,-1);
		} else if(fixedSearchPeriod.equals("two_month")) { 
			cal.add(cal.MONTH,-2);
		} else if(fixedSearchPeriod.equals("three_month")) {
			cal.add(cal.MONTH,-3);
		} else if(fixedSearchPeriod.equals("four_month")) {
			cal.add(cal.MONTH,-4);
		}
		
		if(year == null && month == null && day == null) {
			beginYear   = Integer.toString(cal.get(Calendar.YEAR));
			beginMonth  = df.format(cal.get(Calendar.MONTH) + 1);
			beginDay   = df.format(cal.get(Calendar.DATE));
		} else {
			beginYear = year;
			beginMonth = month;
			beginDay = day;
		}
		
		beginDate = beginYear +"-"+ beginMonth +"-"+beginDay;
		
		return beginDate+","+endDate;
	}
	
}
