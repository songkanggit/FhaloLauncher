
 /**
 * @classDescription:
 * @projectName: FhaloLauncher
 * @packageName: com.fhalo.pretest.activities
 * @className: PretestLedActivity
 * @author: SouKou
 * @date: 2015年10月20日下午3:10:31
 * @copyright: 北京天与华符科技有限公司
 * @mail:
 */

package com.fhalo.pretest.activities;

import com.fhalo.R;
import com.fhalo.hardware.helper.LEDeviceHandler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * @title: PretestLedActivity.java
 * @packageName: com.fhalo.pretest.activities
 * @description: TODO
 * @author: SouKou
 * @date: 2015年10月20日 下午3:10:31
 * @modifier: SouKou
 * @modifyTime: 2015年10月20日下午3:10:31
 * @modifyNote:
 * @version: v1.0
 */

public class PretestLedActivity extends Activity {
	
	private Button bmpButton, spo2Button;
	private TextView showInfo;
	
	private LEDeviceHandler mDeviceHandler = null;
	
	private  static String msg = "";

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pretest_activity_led);
		
		bmpButton = (Button) findViewById(R.id.open_bpm_test_button);
		spo2Button = (Button) findViewById(R.id.open_spo2_test_button);
		showInfo = (TextView) findViewById(R.id.show_led_result_info);
		
		mDeviceHandler = new LEDeviceHandler();
		mDeviceHandler.setDeviceListener(new LEDeviceHandler.DeviceStateListener() {
			
			@Override
			public void onStopDevice() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStarDevice() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onResult(int arg0) {
				// TODO Auto-generated method stub
				if(mDeviceHandler != null && mDeviceHandler.getDeviceType() == LEDeviceHandler.HRMDEVICE) {
					msg = "心率数据:" + arg0;
				} else if (mDeviceHandler != null && mDeviceHandler.getDeviceType() == LEDeviceHandler.SPO2DEVICE) {
					msg = "血氧数据:" + arg0;
				}
				refreshUI();
			}
		});
		
		bmpButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (mDeviceHandler != null) {
					if(mDeviceHandler.getDeviceState() == LEDeviceHandler.DEVICE_STATE_DEFAULT ||
						mDeviceHandler.getDeviceState() == LEDeviceHandler.DEVICE_STATE_DEFAULT) {
						mDeviceHandler.setDeviceType(LEDeviceHandler.HRMDEVICE);
						mDeviceHandler.openDevice();
					} else {
						mDeviceHandler.closeDevice();
						mDeviceHandler.setDeviceType(LEDeviceHandler.HRMDEVICE);
						mDeviceHandler.openDevice();
					}
				} else {
					msg = "设备初始化失败，请返回重试!";
				}
			}
		});
		
		spo2Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (mDeviceHandler != null) {
					if(mDeviceHandler.getDeviceState() == LEDeviceHandler.DEVICE_STATE_DEFAULT ||
						mDeviceHandler.getDeviceState() == LEDeviceHandler.DEVICE_STATE_DEFAULT) {
						mDeviceHandler.setDeviceType(LEDeviceHandler.SPO2DEVICE);
						mDeviceHandler.openDevice();
					} else {
						mDeviceHandler.closeDevice();
						mDeviceHandler.setDeviceType(LEDeviceHandler.SPO2DEVICE);
						mDeviceHandler.openDevice();
					}
				} else {
					msg = "设备初始化失败，请返回重试!";
				}
			}
		});
	}
	
	private final void refreshUI() {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				showInfo.setText(msg);
			}
		});
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if(mDeviceHandler != null && mDeviceHandler.getDeviceState() != LEDeviceHandler.DEVICE_STATE_CLOSED) {
			mDeviceHandler.closeDevice();
		}
		super.onDestroy();
	}
	
	

}
