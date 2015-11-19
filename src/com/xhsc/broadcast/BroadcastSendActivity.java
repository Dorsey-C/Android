package com.xhsc.broadcast;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.drm.DrmStore.Action;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BroadcastSendActivity extends Activity {

	Button mButtonone, mButtonTwo;
	MyCastReceiver mReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcast_receiver_layout);
		mButtonone = (Button) findViewById(R.id.broadcast_btn);
		mButtonTwo = (Button) findViewById(R.id.broadcast_sendmessage_btn);
		mButtonone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MyBroadcastReceiver.ACTION_SMS_RECEIVER);
				sendBroadcast(intent);
			}
		});
		mButtonTwo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MyCastReceiver.ACTION_ONE);
				sendBroadcast(intent);
			}
		});

	}

	

	/**
	 * 动态广播注册
	 */
	public void registerReceiver() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(MyCastReceiver.ACTION_ONE);
		mReceiver = new MyCastReceiver();
		registerReceiver(mReceiver, filter);
	}

	/**
	 * 
	 * @author 定义广播接收者
	 *
	 */

	public class MyCastReceiver extends BroadcastReceiver {

		public static final String ACTION_ONE = "com.xhsc.broadcast.ACTION_ONE";

		@Override // 接收
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			// 过滤广播
			if (action.equals(ACTION_ONE)) {
				Toast.makeText(context, "动态自定义广播", Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * BroadcastResveiver注册注销最好在Activity前置生命周期当中绑定onResume()和onStop()方法中
	 */
	@Override
	protected void onResume() {
		super.onResume();
		registerReceiver();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		if (mReceiver != null) {
			unregisterReceiver(mReceiver);
		}
	}
}
