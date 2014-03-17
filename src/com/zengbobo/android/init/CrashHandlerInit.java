package com.zengbobo.android.init;

import com.zengbobo.android.CrashHandler;

import android.content.Context;

public class CrashHandlerInit implements Init {
	private static CrashHandlerInit mCrashHandlerInit = new CrashHandlerInit();
	private CrashHandlerInit(){
		
	}
	
	public static CrashHandlerInit getInstance(){
		return mCrashHandlerInit;
	}
	
	@Override
	public void init(Context context) {
		CrashHandler.getInstance().init(context);
	}

}
