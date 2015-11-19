package com.xhsc.parameter;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ParameterReceiveActivity extends Activity {
	private TextView mParameteReceiveTxtView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parameter_receive_activity);
		mParameteReceiveTxtView = (TextView)findViewById(R.id.parameter_receive_textveiw);
		Intent intent = getIntent();
		String str = (String) intent.getCharSequenceExtra("BASESTATUS");
		mParameteReceiveTxtView.setText(str);
		
	}
}
