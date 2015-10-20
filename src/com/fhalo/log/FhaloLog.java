
 /**
 * @classDescription:
 * @projectName: FhaloLauncher
 * @packageName: com.fhalo.log
 * @className: FhaloLog
 * @author: SouKou
 * @date: 2015年10月16日下午3:30:57
 * @copyright: 北京天与华符科技有限公司
 * @mail:
 */

package com.fhalo.log;

import com.fhalo.BuildConfig;


/**
 * @title: FhaloLog.java
 * @packageName: com.fhalo.log
 * @description: TODO
 * @author: SouKou
 * @date: 2015年10月16日 下午3:30:57
 * @modifier: SouKou
 * @modifyTime: 2015年10月16日下午3:30:57
 * @modifyNote:
 * @version: v1.0
 */

public class FhaloLog {
	public static final void i(String tag, String msg) {
		if(BuildConfig.DEBUG) {
			android.util.Log.i(tag, msg);
		}
	}
	
	public static final void e(String tag, String msg) {
		if(BuildConfig.DEBUG) {
			android.util.Log.e(tag, msg);
		}
	}
	
	public static final void d(String tag, String msg) {
		if(BuildConfig.DEBUG) {
			android.util.Log.d(tag, msg);
		}
	}
	
	public static final void w(String tag, String msg) {
		if(BuildConfig.DEBUG) {
			android.util.Log.w(tag, msg);
		}
	}
	
	public static final void v(String tag, String msg) {
		if(BuildConfig.DEBUG) {
			android.util.Log.v(tag, msg);
		}
	}
}
