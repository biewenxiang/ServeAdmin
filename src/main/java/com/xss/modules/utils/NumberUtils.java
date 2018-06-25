package com.xss.modules.utils;

import org.apache.commons.lang3.StringUtils;

public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

	/**
	 * 设置其值不为空<br />
	 * notNull(null) = 0<br />
	 * notNull(5) = 5
	 * 
	 * @param l
	 * @return
	 */
	public static Long notNull(Long l) {
		return notNull(l, 0);
	}

	/**
	 * 设置其值不为空<br />
	 * notNull(null,5) = 5<br />
	 * notNull(1,5) = 1
	 * 
	 * @param l
	 * @param defalutValue
	 * @return
	 */
	public static Long notNull(Long l, long defalutValue) {
		return l == null ? defalutValue : l;
	}

	/**
	 * 设置其值不为空<br />
	 * notNull(null) = 0<br />
	 * notNull(5) = 5
	 * 
	 * @param i
	 * @return
	 */
	public static int notNull(Integer i) {
		return notNull(i, 0);
	}

	/**
	 * 设置其值不为空<br />
	 * notNull(null,5) = 5<br />
	 * notNull(1,5) = 1
	 * 
	 * @param i
	 * @param defalutValue
	 * @return
	 */
	public static int notNull(Integer i, int defalutValue) {
		return i == null ? defalutValue : i;
	}

	/**
	 * 将Integer转换成字符串<br />
	 * toString(null) = "0" <br />
	 * toString(0) = "0" <br />
	 * toString(1) = "1" <br />
	 * 
	 * @param i
	 * @return
	 */
	public static String toString(Integer i) {
		return toString(i, "0");
	}

	/**
	 * 判断两个非空的整型是否相等<br />
	 * notNullEquals(null,2) = false<br />
	 * notNullEquals(3,null) = false<br />
	 * notNullEquals(null,null) = false<br />
	 * notNullEquals(3,3) = true
	 * 
	 * @param i1
	 * @param i2
	 * @return
	 */
	public static boolean notNullEquals(Integer i1, Integer i2) {
		if (i1 == null || i2 == null) {
			return false;
		}
		return i1.intValue() == i2.intValue();
	}

	/**
	 * 将Integer转换成字符串<br />
	 * toString(null,null) = null <br />
	 * toString(null,"0") = "0" <br />
	 * toString(null,"2") = "2" <br />
	 * toString(0,"1") = "0" <br />
	 * toString(1,"0") = "1" <br />
	 * 
	 * @param i
	 * @param defaultString
	 * @return
	 */
	public static String toString(Integer i, String defaultString) {
		return i == null ? defaultString : String.valueOf(i);
	}

	public static int toInt(Object str, int defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(str.toString());
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	public static long toLong(Object str, long defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Long.parseLong(str.toString());
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	/**
	 * 检查字符串是否为纯数字组成
	 * 
	 * @author 高阳
	 * @data 2015-02-03
	 * @param strcheck
	 * @return boolean
	 */
	public static boolean checkStringIsNum(String str) {
		String s = StringUtils.trimToEmpty(str);
		boolean isNum = s.matches("[0-9]+");
		return isNum;
	}
}
