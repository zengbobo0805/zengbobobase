package com.zengbobo.android.utils;

public class StringUtil {
	public static boolean equalsNullOrEmpty(String buf){
		if(buf ==null|| buf.equals("")){
			return true;
		}else{
			return false;
		}
	}
}
