package com.zengbobo.android;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {

	ArrayList<Activity> list = new ArrayList<Activity>();

	private static MyApplication mMyApplication = new MyApplication();

	public static MyApplication getInstance() {
		return mMyApplication;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		CrashHandler.getInstance().init(getApplicationContext());
	}

	/**
	 * Activity关闭时，删除Activity列表中的Activity对象
	 */
	public void removeActivity(Activity a) {
		list.remove(a);
	}

	/**
	 * 向Activity列表中添加Activity对象
	 */
	public void addActivity(Activity a) {
		list.add(a);
	}

	/**
	 * 关闭Activity列表中的所有Activity
	 */
	public void finishActivity() {
		for (Activity activity : list) {
			if (null != activity) {
				activity.finish();
			}
		}
		// 杀死该应用进程
		android.os.Process.killProcess(android.os.Process.myPid());
	}

}
