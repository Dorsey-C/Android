package com.xhsc.layout.widget;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xhsc.layout.relativelayout.R;
public class ButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button_widget);
		Log.v("tag", "创建》》》》》》》");
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("tag", "启动》》》》》》》");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("tag", "运行》》》》》》》");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("tag", "暂停》》》》》》》");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("tag", "停止》》》》》》》");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("tag", "摧毁》》》》》》》");
	}
	
	public void goBackOnClick(View v){
		finish();
	}
}
