package com.zengbobo.android.packageManager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


public class ActivityInfoUtil {
	
	public static List<ActivityInfo> getPackageActivityInfo(Context mContext,String packageName){
		List<ActivityInfo> packageActivityList = new ArrayList<ActivityInfo>();
		PackageInfo info = PackageInfoUtil.getPackageInfo(mContext, packageName,PackageManager.GET_ACTIVITIES);
		if(info!=null &&info.activities !=null){
			for(ActivityInfo af:info.activities){
				packageActivityList.add(af);
			}
		}
		
		return packageActivityList;
		
	}
	
}
