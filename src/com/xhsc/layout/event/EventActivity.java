package com.xhsc.layout.event;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.xhsc.layout.relativelayout.R;

public class EventActivity extends Activity implements OnClickListener {

	private TextView mMessageTxt;
	private Button mConfirmBtn, mHelloBtn, mInnerClassBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_layout);
//findViewById()获取实力对象
		mMessageTxt = (TextView) findViewById(R.id.event_message_txt);
		mConfirmBtn = (Button) findViewById(R.id.event_conform_btn);
		mHelloBtn = (Button) findViewById(R.id.event_hello_btn);
		mInnerClassBtn = (Button) findViewById(R.id.event_innerclass_btn);
		
		// 事件处理方式之一匿名内部类实现
		mConfirmBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mMessageTxt.setText("匿名内部类");

			}
		});

		mInnerClassBtn.setOnClickListener(new onButtonClickLisenter());
		mHelloBtn.setOnClickListener(this);// 事件处理方式之二 接口实现
	}

	@Override
	public void onClick(View v) {
		mMessageTxt.setText("接口实现方式");

	}

	// 内部类实现方式
	class onButtonClickLisenter implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mMessageTxt.setText("内部类实现方式");
		}

	}

	public void onAndroidClickListner(View v) {
		mMessageTxt.setText("android事件实现");
	}
}
