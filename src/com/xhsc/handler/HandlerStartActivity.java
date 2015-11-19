package com.xhsc.handler;

import com.xhsc.layout.relativelayout.R;
import com.xhsc.learn.main.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class HandlerStartActivity extends Activity {
	Handler mhandler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handler_start_activity_layout);
		startMainActivity();
		
	}
	
	public void startMainActivity(){
		mhandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				startActivity(new Intent(HandlerStartActivity.this, MainActivity.class));
				finish();
			}
		}, 2000);
	}
}
