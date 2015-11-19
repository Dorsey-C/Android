package com.xhsc.parameter;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ParameterStatusActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parameter_status_activity);
	}
	
	public void onJavaBaseStatusClicklistener(View v){
		Intent intent = new Intent(this, ParameterReceiveActivity.class);
		String str = "这是Java基本数据类型传输";
		intent.putExtra("BASESTATUS", str);
		startActivity(intent);
	}
	
	public void onBundleStatusClicklistener(View v){
		Intent intent = new Intent(this, ParameterReceiveActivity.class);
		startActivity(intent);
	}
	
	public void onSerializableStatusClicklistener(View v){
		Intent intent = new Intent(this, ParameterReceiveActivity.class);
		startActivity(intent);
	}
	
	public void onParcelableStatusClicklistener(View v){
		Intent intent = new Intent(this, ParameterReceiveActivity.class);
		startActivity(intent);
	}
}
