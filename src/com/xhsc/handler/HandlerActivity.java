package com.xhsc.handler;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class HandlerActivity extends Activity {
	Button mhandlerButton, mhandlerPostButton;
	SeekBar mhandlerSeekBar, mhandlerPostSeekBar;
	Handler  mhandlerPost;
	private static final int TOAST_WHAT = 1;
	Handler mhandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			
			super.handleMessage(msg);
			switch (msg.what) {
			case TOAST_WHAT:
				String obj = (String)msg.obj;
				Toast.makeText(HandlerActivity.this, obj, Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.handler_send_message_layout);
		mhandlerButton = (Button) findViewById(R.id.handler_bar_seekbar_start_btn_one);
		mhandlerPostButton = (Button) findViewById(R.id.handler_bar_seekbar_start_btn_two);
		mhandlerSeekBar = (SeekBar) findViewById(R.id.handler_seekbar_bar_one);
		mhandlerPostSeekBar = (SeekBar) findViewById(R.id.handler_seekbar_bar_two);
		
		mhandlerButtonClickListener();
		
		
		mhandlerPost = new Handler();
		mhandlerPostButtonClickListener();
		
	}
/**
 * handler适用于处理当UI界面控件在子线程中刷新，及网络取数据等耗时子线程操作给界面带来的问题，因为控件只能在主线程刷新，而handler起到数据传输刷新的作用
 * 一是在主线程实例化handler，二在子线程实例化Message，两个参数what,obj;调用sendmessage()方法，但竟可能采用Message.obtain()取词，以免耗尽资源
 * 三、主线程用采用handler处理接收到的消息
 */
	public void mhandlerButtonClickListener() {
		mhandlerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 1; i <= mhandlerSeekBar.getMax(); i++) {
							mhandlerSeekBar.setProgress(i);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						Message msg = Message.obtain();
						msg.what = TOAST_WHAT;
						msg.obj ="加载完成";
						mhandler.sendMessage(msg);
					}
				}).start();

			}
		});
	}
	/**
	 * 在子线程中采用handler.post();方法节省代码，主线程，子线程都写
	 */
	public void mhandlerPostButtonClickListener(){
		mhandlerPostButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					public void run() {
						for (int i = 1; i <= mhandlerPostSeekBar.getMax(); i++) {
							mhandlerPostSeekBar.setProgress(i);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						mhandlerPost.post(new Runnable() {
							
							@Override
							public void run() {
								Toast.makeText(HandlerActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
								
							}
						});
					}
				}).start();
				
			}
		});
	}
}
