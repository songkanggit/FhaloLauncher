
 /**
 * @classDescription:网络测试类
 * @projectName: FhaloLauncher
 * @packageName: com.fhalo.activities
 * @className: NetTestActivity
 * @author: SouKou
 * @date: 2015年10月20日上午11:09:13
 * @copyright: 北京天与华符科技有限公司
 * @mail:songkangvip@163.com
 */

package com.fhalo.pretest.activities;

import com.fhalo.R;
import com.fhalo.hardware.helper.Mc800aDeviceHandler;
import com.fhalo.hardware.helper.exception.TelephonyManagerNullPointerException;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * @title: NetTestActivity.java
 * @packageName: com.fhalo.activities
 * @description: TODO
 * @author: SouKou
 * @date: 2015年10月20日 上午11:09:13
 * @modifier: SouKou
 * @modifyTime: 2015年10月20日上午11:09:13
 * @modifyNote:
 * @version: v1.0
 */

public class PretestNetActivity extends Activity {
	
	private Button openNet, closeNet, getInfo;
	private TextView info;
	
	private Mc800aDeviceHandler mc800aHandler;
	private TelephonyManager tm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pretest_activity_net);
		
		openNet = (Button) findViewById(R.id.open_net_test_button);
		closeNet = (Button) findViewById(R.id.close_net_test_button);
		getInfo = (Button) findViewById(R.id.get_info_test_button);
		info = (TextView) findViewById(R.id.show_net_info);
		
		tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
		
		mc800aHandler = new Mc800aDeviceHandler(tm);
		
		openNet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					if (mc800aHandler != null) {
						mc800aHandler.openDevice();
						mc800aHandler.connectNetwork();
					}
				} catch (TelephonyManagerNullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		closeNet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mc800aHandler != null) {
					mc800aHandler.closeDevice();
				}
			}
		});
		
		getInfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String msg = "SoftwareVersion:"+tm.getDeviceSoftwareVersion()+"\n"
						+"Line1Number:"+tm.getLine1Number()+"\n"
						+"NetworkOperator:"+tm.getNetworkOperator()+"\n"
						+"NetworkOperatorName:"+tm.getNetworkOperatorName()+"\n"
						+"SubscriberId:"+tm.getSubscriberId()+"\n";
				if (tm.isNetworkRoaming()) {
					msg = msg + "NetworkRoaming!\n";
				} else {
					msg = msg + "Network is not available!\n";
				}
				msg = msg +"CellLocation:"+ tm.getCellLocation() +"\n";
				msg = msg +"DataState:"+ tm.getDataState() +"\n";
				
				info.setText(msg);
			}
		});
	}

	
}
