package com.zengbobo.android.init;

import android.content.Context;

public class LVMMApplicationInit {
	private static final boolean isInitCrashHandler = true;
	
	
	public static void init(Context context){
		if(isInitCrashHandler){
			CrashHandlerInit.getInstance().init(context);
		}
	}
	
	
}
