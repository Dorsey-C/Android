package com.xhsc.service;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;

public class TestServcieActivity extends Activity {

	private Button mStartBtn, mStopBtn, mPauseBtn;
	private static SeekBar mSeekBar;
	// 处理消息
	public static Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				int duration = msg.arg1;
				int currentPostion = msg.arg2;
				mSeekBar.setMax(duration);
				mSeekBar.setProgress(currentPostion);

				break;

			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service1_layout);
		mStartBtn = (Button) findViewById(R.id.service_start_btn);
		mStopBtn = (Button) findViewById(R.id.service_stop_btn);
		mPauseBtn = (Button) findViewById(R.id.service_pause_btn);
		mSeekBar = (SeekBar) findViewById(R.id.service_seekbar);

		mStartBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 播放音乐
				Intent intent = new Intent(TestServcieActivity.this, MyService.class);
				intent.putExtra("PLAYER", MyService.PLAYER_STATE);

				startService(intent);

			}
		});

		// 暂停音乐
		mPauseBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TestServcieActivity.this, MyService.class);
				intent.putExtra("PLAYER", MyService.PASUE_STATE);
				startService(intent);
			}
		});

		// 停止音乐
		mStopBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TestServcieActivity.this, MyService.class);
				stopService(intent);
			}
		});
	}
}
