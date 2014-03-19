package com.zengbobo.android.packageManager;

import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageStats;
import android.os.RemoteException;

//aidl文件形成的Bindler机制服务类
public class PkgSizeObserver extends IPackageStatsObserver.Stub {

	private PackageStatsCallBack packageStatsCallBack;
	
	
	public void setPackageStatsCallBack(PackageStatsCallBack packageStatsCallBack) {
		this.packageStatsCallBack = packageStatsCallBack;
	}


	/***
	 * 回调函数，
	 * 
	 * @param pStatus
	 *            ,返回数据封装在PackageStats对象中
	 * @param succeeded
	 *            代表回调成功
	 */
	@Override
	public void onGetStatsCompleted(PackageStats pStats, boolean succeeded)
			throws RemoteException {
        long    cacheSize = pStats.cacheSize  ; //缓存大小
        long  dataSize = pStats.dataSize  ;  //数据大小 
        long  codeSize = pStats.codeSize  ;  //应用程序大小
        long   totalsize = cacheSize + dataSize + codeSize ;//应用程序总大小
        System.out.println("PkgSizeObserver:"+cacheSize+" "+codeSize+" "+dataSize+" "+totalsize);
        if(packageStatsCallBack!=null){
        	packageStatsCallBack.onCallBack(pStats);
        }
	}
	
}