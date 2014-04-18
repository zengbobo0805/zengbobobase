package com.zengbobo.android.packageManager;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

public class ServiceInfoUtil {
	public static List<ServiceInfo> getPackageServiceInfo(Context mContext,
			String packageName) {
		List<ServiceInfo> packageActivityList = new ArrayList<ServiceInfo>();
		PackageInfo info = PackageInfoUtil.getPackageInfo(mContext,
				packageName, PackageManager.GET_ACTIVITIES);
		if (info != null && info.services != null) {
			for (ServiceInfo sf : info.services) {
				packageActivityList.add(sf);
			}
		}

		return packageActivityList;

	}

	public static boolean isServiceRunning(Context mContext, String className) {
		boolean isRunning = false;
		ActivityManager activityManager = (ActivityManager) mContext
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningServiceInfo> serviceList = activityManager
				.getRunningServices(30);
		if (!(serviceList.size() > 0)) {
			return false;
		}
		for (int i = 0; i < serviceList.size(); i++) {
			if (serviceList.get(i).service.getClassName().equals(className) == true) {
				isRunning = true;
				break;
			}
		}
		return isRunning;
	}

}
