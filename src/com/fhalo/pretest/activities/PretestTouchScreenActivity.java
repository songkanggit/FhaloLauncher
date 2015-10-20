
 /**
 * @classDescription:
 * @projectName: FhaloLauncher
 * @packageName: com.fhalo.pretest.activities
 * @className: PretestTouchScreenActivity
 * @author: SouKou
 * @date: 2015年10月20日下午1:57:45
 * @copyright: 北京天与华符科技有限公司
 * @mail:
 */

package com.fhalo.pretest.activities;

import com.fhalo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * @title: PretestTouchScreenActivity.java
 * @packageName: com.fhalo.pretest.activities
 * @description: TODO
 * @author: SouKou
 * @date: 2015年10月20日 下午1:57:45
 * @modifier: SouKou
 * @modifyTime: 2015年10月20日下午1:57:45
 * @modifyNote:
 * @version: v1.0
 */

public class PretestTouchScreenActivity extends Activity {
	
	private Button bt1, bt2, bt3, bt4;
	private TextView infoView;
	private static boolean p1, p2, p3, p4;
	private String showMessage="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pretest_activity_touchscreen);
		
		bt1 = (Button) findViewById(R.id.touchscreen_test_button1);
		bt2 = (Button) findViewById(R.id.touchscreen_test_button2);
		bt3 = (Button) findViewById(R.id.touchscreen_test_button3);
		bt4 = (Button) findViewById(R.id.touchscreen_test_button4);
		
		infoView = (TextView) findViewById(R.id.show_touchscreen_info);
		p1=p2=p3=p4=false;
		
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				p1 = true;
				if(p1 && p2 && p3 && p4) {
					showMessage = "所有点均测试完毕!";
				}
				infoView.setText("触摸1点，OK!\n" + showMessage);
			}
		});
		
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				p2 = true;
				if(p1 && p2 && p3 && p4) {
					showMessage = "所有点均测试完毕!";
				}
				infoView.setText("触摸2点，OK!\n" + showMessage);
			}
		});
		
		bt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				p3 = true;
				if(p1 && p2 && p3 && p4) {
					showMessage = "所有点均测试完毕!";
				}
				infoView.setText("触摸3点，OK!\n" + showMessage);
			}
		});
		
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				p4 = true;
				if(p1 && p2 && p3 && p4) {
					showMessage = "所有点均测试完毕!";
				}
				infoView.setText("触摸4点，OK!\n" + showMessage);
			}
		});
	}
	
	

}
