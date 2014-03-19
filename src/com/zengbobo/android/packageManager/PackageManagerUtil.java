package com.zengbobo.android.packageManager;

import android.content.Context;
import android.content.pm.PackageManager;

public class PackageManagerUtil {
	public static PackageManager getPackageManager(Context mContext){
		return mContext.getPackageManager();
	}
}
