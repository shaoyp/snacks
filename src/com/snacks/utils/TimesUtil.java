package com.snacks.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimesUtil {
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String getTimes(){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");//璁剧疆鏃ユ湡鏍煎紡
		String time = df.format(new Date());// new Date()涓鸿幏鍙栧綋鍓嶇郴缁熸椂闂�
		return time;
	}
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static Long getNowtime(){
		Date dt= new Date();
		return dt.getTime();
	}
	
	public static Long turnLongTime(Date date){
		
		long millionSeconds = 0;
		try {
			millionSeconds = date.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return millionSeconds;
	}
	public static String getDate(){
		SimpleDateFormat df = new SimpleDateFormat("M鏈坉d鏃�");//璁剧疆鏃ユ湡鏍煎紡
		String time = df.format(new Date());// new Date()涓鸿幏鍙栧綋鍓嶇郴缁熸椂闂�
		return time;
	}
	public static String getWeek(){
		String[] weekDays = {"鏄熸湡鏃�", "鏄熸湡涓�", "鏄熸湡浜�", "鏄熸湡涓�", "鏄熸湡鍥�", "鏄熸湡浜�", "鏄熸湡鍏�"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
	}
	public static String dirFileByDay(){
		String fileFolder = new SimpleDateFormat("yyyyMMdd").format(new Date());
		return fileFolder;
	}
	public static void main(String[] args) {
		System.out.println(TimesUtil.getDate());
		System.out.println(TimesUtil.getTimes());
		System.out.println(TimesUtil.getWeek());
	}
	
	
}
