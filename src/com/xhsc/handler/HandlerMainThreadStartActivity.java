package com.xhsc.handler;



import org.apache.http.impl.conn.LoggingSessionInputBuffer;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HandlerMainThreadStartActivity extends Activity {
	Handler mMainHandler,handler;
	TextView mTextView;
	Button mMainThreadBtn,mChildThreadBtn;
	MyLooperThread mylooper;
	private int count = 1;
	public Handler mHandler3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handler_looper_childthread_layout);
		mTextView = (TextView)findViewById(R.id.looper_child_thread_textview);
		mMainThreadBtn =(Button)findViewById(R.id.main_thread_button) ;
		mChildThreadBtn = (Button)findViewById(R.id.child_thread_button);
		mylooper = new MyLooperThread();
		mylooper.start();
		mMainThreadBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Message msg = Message.obtain();
				msg.what = 11;
				msg.arg1 = count++;
				mylooper.mHandler1.sendMessage(msg);
				
			}
		});
		
		mChildThreadBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Message msg = Message.obtain();
				msg.what = 12;
				msg.arg1 = count++;
				mylooper.mHandler2.sendMessage(msg);
				
				
			}
		});
		
		mHandler3 = new Handler(getMainLooper(),new Callback() {
			
			@Override
			public boolean handleMessage(Message msg) {
				String obj = (String)msg.obj;
				mTextView.setText("子线程发送到主线程执行 : " + obj);
				return true;
			}
		});
	}
	
	public class MyLooperThread  extends Thread{
		Handler childHandler;
		public Handler mHandler1;
		public Handler mHandler2;
		
		@Override
		public void run() {
			
			super.run();
			Looper.prepare();
			mHandler1 = new Handler(getMainLooper(), new Callback() {
				
				@Override
				public boolean handleMessage(Message msg) {
					int arg1 = msg.arg1;
					Log.v("tag", "消息在主线程执行的情况 :  消息 " + arg1);
					mTextView.setText("主线程执行 :  消息 " + arg1);
					return true;
				}
			});
			
			mHandler2 = new Handler(Looper.myLooper(), new Callback() {
				
				@Override
				public boolean handleMessage(Message msg) {
					int arg1 = msg.arg1;
					Log.v("tag", "消息在子线程执行的情况 :  消息 " + arg1);
					
//					mTextView.setText("子线程执行 :  消息 " + arg1);这里会报错控件刷新是在主线程进行的，修改如下再套一个handler
					
					Message msg1 = Message.obtain();
					msg1.obj = "消息"+arg1;
					mHandler3.sendMessage(msg1);
					return true;
				}
			});
			Looper.loop();
		}
		
		
		
}
}