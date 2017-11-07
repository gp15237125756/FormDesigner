/*******************************************************************************
 * BeanUtils.java 01-00
 *
 * Copyright 2014 by LD, Ltd. All right reserved.
 *
 *	2014/08/07 01-00 wangmb
 *******************************************************************************/
package com.ld.codeGenerate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Bean工具方法类
 * @version 01-00
 */
public class DateUtil {

	/**
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		if (date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date StringConvertDate(String date, String format)  {
		if (date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
	}
	
	/**
	 * 默认转换yyyy-MM-dd
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date StringToDate(String date){
		if (date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 默认转换yyyy-MM-dd
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date StringToDate(String date, String format){
		if (date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 时间类型比较
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static int compare_date(Date dt1, Date dt2) {
		try {
			if(dt1==null||dt2==null){
				return 0;
			}
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * @return Date => day of week
	 * 1:Sunday
	 * 2:Monday
	 * ..
	 * ..
	 * 7:Sunday
	 * @param date
	 * @return {code Date}
	 */
	public static int retriveWeekDay(final Date date){
		Objects.requireNonNull(date, "the input date must not be null!");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
}
