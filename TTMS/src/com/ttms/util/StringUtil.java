package com.ttms.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String �й���
 * @author hu
 *
 */
public class StringUtil {
	
	/**
	 * ����ת�ַ���
	 * @param date
	 * @param formate
	 * @return
	 */
	public static String dateToString(Date date,String formate)
	{
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(formate);
		if(date!=null)
		{
			result=sdf.format(date);
		}
		return result;
	}
	/**
	 * �ַ���ת����
	 * @param date
	 * @param formate
	 * @return
	 */
	public static Date stringToDate(String date,String formate)
	{
		Date result=null;
		if(date==null&&"".equals(date))
		{
			return null;
		}
		else{
			DateFormat sdf=new SimpleDateFormat(formate);
			try{
				result=sdf.parse(date);
			}catch(ParseException e)
			{
				e.printStackTrace();
			}
			
		}
		return result;
	}
	public static boolean isEmpty(String string){
		if(string==null||"".equals(string))
		{
			return true;
		}
		return false;
	}
	public static boolean isNotEmpty(String string)
	{
		if((string!=null)&&(!"".equals(string)))
		{
			return true;
		}
		return false;
	}
	
}
