package com.zengbobo.android.packageManager;

import android.content.pm.PackageItemInfo;

public class MyPackageItemInfo extends PackageItemInfo {
//	Field	Detail
//	public int icon	获得该资源图片在R文件中的值 (对应于android:icon属性)
//	public int labelRes	获得该label在R文件中的值(对应于android:label属性)
//	public String name	获得该节点的name值 (对应于android:name属性)
//	public String packagename	获得该应用程序的包名 (对应于android:packagename属性)

//	Method	Detail
//	Drawable loadIcon(PackageManager pm)	获得当前应用程序的图像
//	CharSequence  loadLabel(PackageManager pm)	获得当前应用程序的label
	 
	// 全局变量，保存当前查询包得信息
	private long cachesize; // 缓存大小
	private long datasize; // 数据大小
	private long codesize; // 应用程序大小
	private long totalsize; // 总大小
	public long getCachesize() {
		return cachesize;
	}
	public void setCachesize(long cachesize) {
		this.cachesize = cachesize;
	}
	public long getDatasize() {
		return datasize;
	}
	public void setDatasize(long datasize) {
		this.datasize = datasize;
	}
	public long getCodesize() {
		return codesize;
	}
	public void setCodesize(long codesize) {
		this.codesize = codesize;
	}
	public long getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(long totalsize) {
		this.totalsize = totalsize;
	}
	 
}
