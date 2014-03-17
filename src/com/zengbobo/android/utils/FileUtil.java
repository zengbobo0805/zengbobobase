package com.zengbobo.android.utils;

import java.io.File;

import android.content.Context;
import android.os.Environment;

public class FileUtil {
	public static boolean isExternalStorageState() {
		return Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
	}

	public static File externalStorageDirectory() {
		return Environment.getExternalStorageDirectory();
	}
	
	public static String externalStorageDirectoryPath() {
		return externalStorageDirectory().getPath()
				+ File.separator;
	}

	// 注： 在Activity中有 getFileDir() 和 getCacheDir(); 方法可以获得当前的手机自带的存储空间中的当前包文件的路径
	// getFileDir() ----- /data/data/cn.xxx.xxx(当前包)/files
	// getCacheDir() ----- /data/data/cn.xxx.xxx（当前包）/cache
	public static File getFileDir(Context mContext) {
		return mContext.getFilesDir();
	}

	public static File getCacheDir(Context mContext) {
		return mContext.getCacheDir();
	}
}
