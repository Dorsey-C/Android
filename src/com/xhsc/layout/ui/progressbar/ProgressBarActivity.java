package com.xhsc.layout.ui.progressbar;

import java.security.PublicKey;

import com.xhsc.layout.relativelayout.R;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class ProgressBarActivity extends Activity {
	ProgressBar mProgressBarOne, mProgressBarTwo, mProgressBarThree;
	SeekBar mSeekBar;
	Button mProBarBtn, mSeekBarBtn;
	Handler mhandler,mposthangdler;
	private static final int TOAST_OBJ = 10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress_bar_layout);
		mProgressBarOne = (ProgressBar) findViewById(R.id.bar_progressbar1);
		mProgressBarTwo = (ProgressBar) findViewById(R.id.bar_progressbar2);
		mProgressBarThree = (ProgressBar) findViewById(R.id.bar_progressbar3);

		mSeekBar = (SeekBar) findViewById(R.id.seekbar_bar);
		mProBarBtn = (Button) findViewById(R.id.bar_probar_start_btn);
		mSeekBarBtn = (Button) findViewById(R.id.bar_seekbar_start_btn);
		progressListener();
		seekBarListener();
		seekBarOnSeekBarChangeListener();
		mhandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				
				super.handleMessage(msg);
				switch (msg.what) {
				case TOAST_OBJ:
					CharSequence obj = (CharSequence)msg.obj;
					Toast.makeText(ProgressBarActivity.this, obj, Toast.LENGTH_SHORT).show();
					break;

				default:
					break;
				}
			}
		};

	}

	public void progressListener() {
		mProBarBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i < 100; i++) {
							mProgressBarThree.setProgress(i);
							int a = 1;
							int b = 1;
							a = a + i;
							b = b * a;
							mProgressBarThree.setSecondaryProgress(b);
							Log.v("tag", "1加载 :  " + mProgressBarThree.getProgress());
							Log.i("tag", "1加载 :  " + mProgressBarThree.getSecondaryProgress());
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {

								e.printStackTrace();
							}
						}
						Log.v("tag", "1加载完成");
						
					}
				}).start();

			}
		});
	}

	public void seekBarListener() {
		mSeekBarBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 1; i <= mSeekBar.getMax(); i++) {
							mSeekBar.setProgress(i);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						Log.i("tag", "seekbar加载完成");
//						Message msg = new Message();减少Message的实例化，一条消息对应一个message好资源，从消息池取词obtain
						Message msg = Message.obtain();
						msg.what = TOAST_OBJ;
						msg.obj ="加载完成";

						mhandler.sendMessage(msg);
						/*mhandler.post(new Runnable() {
							
							@Override
							public void run() {
								
								Toast.makeText(ProgressBarActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
							}
						});*/
					}
				}).start();

			}
		});
	}

	public void seekBarOnSeekBarChangeListener() {
		/**
		 * SeekBar与ProgressBar不同，可以拖拽进度，自定义中有两个属性一个是设置按钮的thumb属性
		 * 还有一个自定义进度条背景的progressDrawable，需要采用drawable下
		 * <layer-list> <item android:id="@android:id/background"
		 * android:drawable="@drawable/progress_bar_n"> </item>
		 * <item android:id="@android:id/progress"> <clip> <nine-patch
		 * android:src="@drawable/progress_bar_p" /> </clip> </item>
		 * </layer-list>
		 */
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				Log.d("tag", "onStopTrackingTouch   ");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

				Log.d("tag", "onStartTrackingTouch   ");
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Log.d("tag", "onProgressChanged  progress " + progress);

			}
		});
	}
}
