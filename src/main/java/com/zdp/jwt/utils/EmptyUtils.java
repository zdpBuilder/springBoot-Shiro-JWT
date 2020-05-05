package com.zdp.jwt.utils;

import java.util.List;
import java.util.Map;


/**
 * @author zdp
 * @description: 判空工具类
 */
public class EmptyUtils {
	
	/**
	 * 
	 * @Description: string是否为空
	 * @param str
	 * @return
	 */
	public static boolean stringIsEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}
	
	/**
	 * 
	 * @Description: string是否不为空
	 * @param str
	 * @return
	 */
	public static boolean stringIsNotEmpty(String str) {
		return !stringIsEmpty(str);
	}
	
	/**
	 * 
	 * @Description: Integer是否为空
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static boolean intIsEmpty(Integer number) {
		return  null == number || "".equals(number);
	}
	
	/**
	 * 
	 * @Description: Integer是否不为空
	 * @param number
	 * @return
	 */
	public static boolean intIsNotEmpty(Integer number) {
		return !intIsEmpty(number);
	}
	
	/**
	 * 
	 * @Description: list是否为空
	 * @param list
	 * @return
	 */
	public static <T> boolean listIsEmpty(List<T> list) {
		return list == null || list.isEmpty();
	}
	
	/**
	 * 
	 * @Description: list是否不为空
	 * @param list
	 * @return
	 */
	public static <T> boolean listIsNotEmpty(List<T> list) {
		return !listIsEmpty(list);
	}
	
	/**
	 * 
	 * @Description: map是否为空
	 * @param map
	 * @return
	 */
	public static <K, V> boolean mapIsEmpty(Map<K, V> map) {
		return map == null || map.isEmpty();
	}
	
	/**
	 * 
	 * @Description: map是否不为空
	 * @param map
	 * @return
	 */
	public static <K, V> boolean mapIsNotEmpty(Map<K, V> map) {
		return !mapIsEmpty(map);
	}

	/**
	 *
	 * @Description: 数组是否为空
	 * @param array
	 * @return
	 */
	public static boolean arrayIsEmpty(Object[] array){
		return array == null || array.length == 0;
	}

	/**
	 *
	 * @Description: 对象是否为空
	 * @param object
	 * @return
	 */
	public  static  boolean objectIsEmpty(Object object){return object==null;}
}
