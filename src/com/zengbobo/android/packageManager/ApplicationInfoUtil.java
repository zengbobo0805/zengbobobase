package com.zengbobo.android.packageManager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageStats;
import android.graphics.drawable.Drawable;

public class ApplicationInfoUtil {
	
	public static ApplicationInfo getApplicationInfo(Context mContext,
			String packageName) {
		PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
		try {
			return pm.getApplicationInfo(packageName, 0);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<ApplicationInfo> getInstalledApplications(
			Context mContext) {
		PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
		return pm.getInstalledApplications(0);
	}

	// 列出普通应用程序
	public static List<ApplicationInfo> loadCustomApps(Context mContext) {
		ArrayList<ApplicationInfo> customApps = new ArrayList<ApplicationInfo>(); // 普通应用程序列表
		List<ApplicationInfo> packages = getInstalledApplications(mContext);
		for (ApplicationInfo pi : packages) {
			if ((pi.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
				customApps.add(pi);
			}
		}
		return customApps;
	}

	// 系统应用程序列表
	public static List<ApplicationInfo> loadSystemApps(Context mContext) {
		ArrayList<ApplicationInfo> systemApps = new ArrayList<ApplicationInfo>(); // 系统应用程序列表
		List<ApplicationInfo> packages = getInstalledApplications(mContext);
		for (ApplicationInfo pi : packages) {
			if ((pi.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
				systemApps.add(pi);
			}
		}
		return systemApps;
	}

	// SDcard应用程序列表
	public static List<ApplicationInfo> loadSDcardApps(Context mContext) {
		ArrayList<ApplicationInfo> sDcardApps = new ArrayList<ApplicationInfo>(); // 系统应用程序列表
		List<ApplicationInfo> packages = getInstalledApplications(mContext);
		for (ApplicationInfo pi : packages) {
			if ((pi.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) != 0) {
				sDcardApps.add(pi);
			}
		}
		return sDcardApps;
	}

	// 根据PackageName获取应用程序Icon,有重载方法
	public static Drawable loadAPPIcon(Context mContext, String packageName) {
		PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
		try {
			return pm.getApplicationIcon(packageName);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 根据ApplicationInfo获取应用程序Icon,有重载方法
	public static Drawable loadAPPIcon(Context mContext, ApplicationInfo info) {
		PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
//	return	info.loadIcon(pm);
		return pm.getApplicationIcon(info);
	}
//根据ApplicationInfo获取应用程序包名；
	public static String loadAPPPackageName(Context mContext, ApplicationInfo info) {
		PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
		return info.packageName;
	}

	//根据ApplicationInfo获取应用程序名；
	public static String loadAPPName(Context mContext, ApplicationInfo info) {
		PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
		return info.name;
	}

}
