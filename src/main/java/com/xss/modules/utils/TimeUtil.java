package com.xss.modules.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	public TimeUtil() {
	}

	public static long getNumericDatePeriod(Date nowDate, Date lastDate) {
		long longReturn = 0;
		try {
			long thevalue = (long) ((lastDate.getTime() - nowDate.getTime()) / (1000 * 60 * 60 * 24) + 0.5);
			longReturn = thevalue;
		} catch (Exception ex) {
		}
		return longReturn;
	}

	// 返回格式化的日期
	public static String getFullDate() {
		String formater = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	/*
	 * state 1 前一个小时，-1 后一个小时
	 */
	@SuppressWarnings("deprecation")
	public static String getFullDate(int state) {
		String formater = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		if (state == 1)
			myDate.setHours(myDate.getHours() + 1);
		else if (state == -1)
			myDate.setHours(myDate.getHours() - 1);
		return format.format(myDate);
	}

	public static String getSomeFullDate(String sDate, int iDay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(sDate);
			long Time = date.getTime() / 1000L + 86400 * iDay;
			date.setTime(Time * 1000L);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	@SuppressWarnings("deprecation")
	public static String getDateTimeH(int state) {
		String formater = "yyyy-MM-ddHH";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		if (state == 1)
			myDate.setHours(myDate.getHours() + 1);
		else
			myDate.setHours(myDate.getHours() - 1);
		// myDate.
		return format.format(myDate);
	}

	public static String getDateTimeH() {
		String formater = "yyyy-MM-ddHH";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	// 返回格式化的日期
	public static String getFullDate(String sDate) {
		try {
			String formater = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(formater);
			Date date = format.parse(sDate);
			formater = "yyyy-MM-dd";
			format = new SimpleDateFormat(formater);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	// 返回格式化的日期
	public static String getCurDateTime() {
		String formater = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	// 返回格式化的日期
	public static String getFullDateTime(String sDate) {
		try {
			String formater = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(formater);
			Date date = format.parse(sDate);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	// 返回格式化的日期
	public static String getSimpleDate() {
		String formater = "yyyy-M-d";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	// 返回格式化的日期
	public static String getFullYear() {
		String formater = "yyyy";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	// 返回格式化的日期

	public static String getSomeDate(String sDate, int iDay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(sDate);
			long Time = (date.getTime() / 1000) + 60 * 60 * 24 * iDay;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 返回修改后的
	 * 
	 * @param sTime
	 * @param iTime
	 * @return
	 */
	public static String getSomeTime(String sTime, int iTime) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
			Date date = format.parse(sTime);
			long Time = (date.getTime() / 1000) + iTime;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	// 返回格式化的日期
	public static String getSomeHour(String sDate, int hour) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(sDate);
			long Time = (date.getTime() / 1000) + 60 * 60 * hour;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	// 返回日期的差值

	public static int getNumericDatePeriod(String sDate) {
		int iTime = 0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(sDate);
			Date date1 = new Date();
			iTime = (int) ((date.getTime() - date1.getTime()) / 1000L);
		} catch (Exception ex) {
		}
		return iTime;
	}

	// 判断日期的前后
	public static boolean isDateLater(String sDate, String sDate1) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(sDate);
			Date date1 = format.parse(sDate1);
			if (date.after(date1))
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}

	// 判断时间的前后
	public static boolean isTimeLater(String sDate, String sDate1) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date = format.parse(sDate);
			Date date1 = format.parse(sDate1);
			if (date.after(date1))
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}

	public static Date Format(String s) {
		Date lastdt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			lastdt = sdf.parse(s);
		} catch (Exception e) {
		}
		return lastdt;
	}

	public static Date FullFormat(String s) {
		Date lastdt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			lastdt = sdf.parse(s);
		} catch (Exception e) {
		}
		return lastdt;
	}

	public static String getCurTime() {
		String formater = "HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	public static String getSomeDatesmall(String sDate, int iDay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(sDate);
			long Time = (date.getTime() / 1000) + 60 * 60 * 24 * iDay;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 返回格式化的间隔iDay天的日期
	 * 
	 * @param sDate
	 *            时间
	 * @param iDay
	 *            间隔天数
	 * @param formter
	 *            时间格式："yyyy-MM-dd"或"yyyy-M-d"
	 * @return
	 */
	public static String getSomeDate(String sDate, int iDay, String formter) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(formter);
			Date date = format.parse(sDate);
			long Time = (date.getTime() / 1000) + 60 * 60 * 24 * iDay;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	public static String getFullDate(long l) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(l);
		try {
			String formater = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(formater);
			return format.format(c.getTime());
		} catch (Exception ex) {
			return "";
		}
	}

	public static String getNumberDate() {
		String timeNumber = "";
		try {
			String time = TimeUtil.getCurDateTime();
			timeNumber = time.substring(0, 4) + time.substring(5, 7) + time.substring(8, 10);
		} catch (Exception e) {
			return "";
		}
		return timeNumber;
	}

	public static void main(String[] args) {
	}
}
