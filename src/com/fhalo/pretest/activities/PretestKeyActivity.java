
 /**
 * @classDescription:按键测试类
 * @projectName: FhaloLauncher
 * @packageName: com.fhalo.pretest.activities
 * @className: PretestKeyActivity
 * @author: SouKou
 * @date: 2015年10月20日下午12:58:19
 * @copyright: 北京天与华符科技有限公司
 * @mail:songkangvip@163.com
 */

package com.fhalo.pretest.activities;

import java.util.HashMap;
import java.util.Map;
import com.fhalo.R;
import com.fhalo.log.FhaloLog;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * @title: PretestKeyActivity.java
 * @packageName: com.fhalo.pretest.activities
 * @description: TODO
 * @author: SouKou
 * @date: 2015年10月20日 下午12:58:19
 * @modifier: SouKou
 * @modifyTime: 2015年10月20日下午12:58:19
 * @modifyNote:
 * @version: v1.0
 */

public class PretestKeyActivity extends Activity {
	
	private Button backButton;
	private TextView infoView;
	
	@SuppressLint("UseSparseArrays")
	@SuppressWarnings("serial")
	private static final Map<Integer, String> keyMessage = new HashMap<Integer, String>(){
			{put(KeyEvent.KEYCODE_BACK, "返回按键被使用!"); put(KeyEvent.KEYCODE_UNKNOWN, "紧急按键被使用!"); 
			put(KeyEvent.KEYCODE_HOME, "锁屏按键被使用!");}};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pretest_activity_key);
		
		backButton = (Button) findViewById(R.id.stop_key_test_button);
		infoView = (TextView) findViewById(R.id.show_key_info);
		
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			infoView.setText(keyMessage.get(KeyEvent.KEYCODE_BACK));
		} else if (keyCode == KeyEvent.KEYCODE_UNKNOWN) {
			infoView.setText(keyMessage.get(KeyEvent.KEYCODE_UNKNOWN));
		} else if (keyCode == KeyEvent.KEYCODE_HOME) {
			infoView.setText(keyMessage.get(KeyEvent.KEYCODE_HOME));
		}
		return true;
	}
	
}
