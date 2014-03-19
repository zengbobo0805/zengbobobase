package com.zengbobo.android.packageManager;

import android.content.pm.PackageStats;
import android.os.Parcel;

public class PackageSizeStats extends PackageStats{
	// 全局变量，保存当前查询包得信息
//	private long cachesize; // 缓存大小
//	private long datasize; // 数据大小
//	private long codesize; // 应用程序大小
	private long totalsize; // 总大小


	public PackageSizeStats(PackageStats pStats) {
		super(pStats);
	}

	public PackageSizeStats(Parcel source) {
		super(source);
	}

	public PackageSizeStats(String pkgName) {
		super(pkgName);
	}

	public long getTotalsize() {
		return cacheSize+dataSize+codeSize;
	}

	
	
}
