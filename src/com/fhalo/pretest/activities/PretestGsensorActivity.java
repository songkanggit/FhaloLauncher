
 /**
 * @classDescription:加速度传感器测试类
 * @projectName: FhaloLauncher
 * @packageName: com.fhalo.pretest.activities
 * @className: PretestGsensorActivity
 * @author: SouKou
 * @date: 2015年10月20日上午11:46:46
 * @copyright: 北京天与华符科技有限公司
 * @mail:
 */

package com.fhalo.pretest.activities;

import com.fhalo.R;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


/**
 * @title: PretestGsensorActivity.java
 * @packageName: com.fhalo.pretest.activities
 * @description: TODO
 * @author: SouKou
 * @date: 2015年10月20日 上午11:46:46
 * @modifier: SouKou
 * @modifyTime: 2015年10月20日上午11:46:46
 * @modifyNote:
 * @version: v1.0
 */

public class PretestGsensorActivity extends Activity {

	/**
	 * Define sensorManager
	 */
	private SensorManager mSensorManager;
	private PretestEventLisener mEventLisener;
	
	private TextView showInfo;
	
	private float xAxis, yAxis, zAxis;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pretest_activity_gsensor);
		
		showInfo = (TextView)findViewById(R.id.show_gsensor_info);
		
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mEventLisener = new PretestEventLisener();
	}
	
	private class PretestEventLisener implements SensorEventListener {

		/* (non-Javadoc)
		 * @see android.hardware.SensorEventListener#onSensorChanged(android.hardware.SensorEvent)
		 */
		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			xAxis = event.values[0];
			yAxis = event.values[1];
			zAxis = event.values[2];
			refreshUI();
		}

		/* (non-Javadoc)
		 * @see android.hardware.SensorEventListener#onAccuracyChanged(android.hardware.Sensor, int)
		 */
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private final void refreshUI() {
		showInfo.setText("获取加速度传感器数据如下:\n"
				+"X-AXIS:" + xAxis + "\n"
				+"Y-AXIS:" + yAxis + "\n"
				+"Z-AXIS:" + zAxis + "\n");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//Sensor accelerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		Sensor accelerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mSensorManager.registerListener(mEventLisener, accelerSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		mSensorManager.unregisterListener(mEventLisener);
	}

}
