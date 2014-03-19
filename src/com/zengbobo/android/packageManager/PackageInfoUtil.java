package com.zengbobo.android.packageManager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.zengbobo.android.utils.StringUtil;

public class PackageInfoUtil {

	// 列出所有应用程序
	public static List<PackageInfo> loadAllPackages(Context mContext) {
		ArrayList<PackageInfo> allApps = new ArrayList<PackageInfo>(); // 普通应用程序列表
		// 得到PackageManager对象
		PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
		// 得到系统安装的所有程序包的PackageInfo对象
		List<PackageInfo> packages = pm.getInstalledPackages(0);
		for (PackageInfo pi : packages) {
			allApps.add(pi);
		}
		return allApps;
	}

	// 列出普通应用程序
	public static List<PackageInfo> loadCustomPackages(Context mContext) {
		ArrayList<PackageInfo> customApps = new ArrayList<PackageInfo>(); // 普通应用程序列表
		List<PackageInfo> packages = loadAllPackages(mContext);
		for (PackageInfo pi : packages) {
			if ((pi.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
				customApps.add(pi);
			}
		}
		return customApps;
	}

	// 系统应用程序列表
	public static List<PackageInfo> loadSystemPackages(Context mContext) {
		ArrayList<PackageInfo> systemApps = new ArrayList<PackageInfo>(); // 系统应用程序列表
		List<PackageInfo> packages = loadAllPackages(mContext);
		for (PackageInfo pi : packages) {
			if ((pi.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
				systemApps.add(pi);
			}
		}
		return systemApps;
	}

	// SDcard应用程序列表
	public static List<PackageInfo> loadSDcardPackages(Context mContext) {
		ArrayList<PackageInfo> sDcardApps = new ArrayList<PackageInfo>(); // 系统应用程序列表
		List<PackageInfo> packages = loadAllPackages(mContext);
		for (PackageInfo pi : packages) {
			if ((pi.applicationInfo.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) != 0) {
				sDcardApps.add(pi);
			}
		}
		return sDcardApps;
	}

	public static PackageInfo getPackageInfo(Context mContext,
			String packageName) {
		List<PackageInfo> packages = loadAllPackages(mContext);
		for (PackageInfo pi : packages) {
			if (!StringUtil.equalsNullOrEmpty(packageName)
					&& pi.packageName.equals(packageName)) {
				return pi;
			}
		}
		return null;
	}

	public static PackageInfo getPackageInfo(Context mContext,
			String packageName, int flag) {
		PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
		try {
			return pm
					.getPackageInfo(packageName, flag);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void queryPacakgeSize(Context mContext, String pkgName,
			PackageStatsCallBack callBack) {
		if (pkgName != null) {
			// 使用放射机制得到PackageManager类的隐藏函数getPackageSizeInfo
			PackageManager pm = PackageManagerUtil.getPackageManager(mContext);
			try {
				// 通过反射机制获得该隐藏函数
				Method getPackageSizeInfo = pm.getClass().getDeclaredMethod(
						"getPackageSizeInfo", String.class,
						IPackageStatsObserver.class);
				PkgSizeObserver pkgSizeObserver = new PkgSizeObserver();
				pkgSizeObserver.setPackageStatsCallBack(callBack);
				// 调用该函数，并且给其分配参数 ，待调用流程完成后会回调PkgSizeObserver类的函数
				getPackageSizeInfo.invoke(pm, pkgName, pkgSizeObserver);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// 根据PackageInfo获取应用程序包名；
	public static String loadAPPPackage(PackageInfo info) {
		return info.packageName;
	}

	// 根据PackageInfo获取应用程序版本；
	public static String loadAPPVersionName(PackageInfo info) {
		return info.versionName;
	}

	// 根据PackageInfo获取应用程序版本号；
	public static int loadAPPVersionCode(PackageInfo info) {
		return info.versionCode;
	}

}
