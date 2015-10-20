
 /**
 * @classDescription:
 * @projectName: FhaloLauncher
 * @packageName: com.fhalo.activities
 * @className: MainActivity
 * @author: SouKou
 * @date: 2015年10月16日下午2:03:26
 * @copyright: 北京天与华符科技有限公司
 * @mail:
 */

package com.fhalo.activities;

import com.fhalo.R;
import com.fhalo.hardware.aidl.IRemoteService;
import com.fhalo.hardware.helper.Mc800aDeviceHandler;
import com.fhalo.hardware.helper.exception.TelephonyManagerNullPointerException;
import com.fhalo.log.FhaloLog;
import com.fhalo.pretest.activities.PretestGsensorActivity;
import com.fhalo.pretest.activities.PretestKeyActivity;
import com.fhalo.pretest.activities.PretestLedActivity;
import com.fhalo.pretest.activities.PretestNetActivity;
import com.fhalo.pretest.activities.PretestTouchScreenActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * @title: MainActivity.java
 * @packageName: com.fhalo.activities
 * @description: TODO
 * @author: SouKou
 * @date: 2015年10月16日 下午2:03:26
 * @modifier: SouKou
 * @modifyTime: 2015年10月16日下午2:03:26
 * @modifyNote:
 * @version: v1.0
 */

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";

	/**
	 * All Mechine Test Items Button
	 */
	private Button vibrator_test_button, led_test_button, gsensor_test_button, key_test_button,
		touchscreen_test_button, net_test_button;
	
	/**
	 * 马达测试
	 */
	private Vibrator mVibrator;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		vibrator_test_button = (Button) findViewById(R.id.vibrator_test_button);
		led_test_button = (Button) findViewById(R.id.led_test_button);
		gsensor_test_button = (Button) findViewById(R.id.gsensor_test_button);
		key_test_button = (Button) findViewById(R.id.key_test_button);
		touchscreen_test_button = (Button) findViewById(R.id.touchscreen_test_button);
		net_test_button = (Button) findViewById(R.id.net_test_button);
		
		vibrator_test_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				mVibrator.vibrate(2000);
			}
		});
		
		led_test_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PretestLedActivity.class));
			}
		});
		
		gsensor_test_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PretestGsensorActivity.class));
			}
		});
		
		key_test_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PretestKeyActivity.class));
			}
		});
		
		touchscreen_test_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PretestTouchScreenActivity.class));
			}
		});
		
		net_test_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PretestNetActivity.class));
			}
		});
		
	}
}
