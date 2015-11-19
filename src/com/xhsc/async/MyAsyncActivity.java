package com.xhsc.async;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author AsyncTask异步任务加载进度条
 *
 */
public class MyAsyncActivity extends Activity implements OnClickListener {

	TextView mTextView;
	SeekBar mSeekBar;
	Button mHandlerBtn, mAsyncBtn, mStopAsyncProBtn;
	MyAsyncTask myAsyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.async_layout);
		mTextView = (TextView) findViewById(R.id.async_textview);
		mSeekBar = (SeekBar) findViewById(R.id.async_seekbar_bar);
		mHandlerBtn = (Button) findViewById(R.id.handler_seekbar_btn);
		mAsyncBtn = (Button) findViewById(R.id.async_seekbar_btn);
		mStopAsyncProBtn = (Button) findViewById(R.id.async_stop_seekbar_progress_btn);
		mHandlerBtn.setOnClickListener(this);
		mAsyncBtn.setOnClickListener(this);
		mStopAsyncProBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.handler_seekbar_btn:
			handleSeekbar();
			break;
		case R.id.async_seekbar_btn:

			myAsyncTask = new MyAsyncTask();
			myAsyncTask.execute();
			break;
		case R.id.async_stop_seekbar_progress_btn:
			Log.v("tag", "myAsyncTask.isCancelled(): " + myAsyncTask.isCancelled());
			if (!myAsyncTask.isCancelled()) {
				Log.v("tag", "停止异步进程");
				myAsyncTask.cancel(true);//终止异步任务
			}
			break;

		default:
			break;
		}
	}

	public void handleSeekbar() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					mSeekBar.setProgress(i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public class MyAsyncTask extends AsyncTask<Void, Integer, String> {

		@Override
		protected String doInBackground(Void... params) {
			for (int i = 0; i < 100; i++) {

				publishProgress(i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			String result = "下载完成";
			return result;

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			int progress = values[0];
			mTextView.setText("" + progress);
			mSeekBar.setProgress(progress);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Toast.makeText(MyAsyncActivity.this, result, Toast.LENGTH_SHORT).show();
		}
	}

}