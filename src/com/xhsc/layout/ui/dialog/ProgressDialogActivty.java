package com.xhsc.layout.ui.dialog;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class ProgressDialogActivty extends Activity {
	Button mProgressDialogBtn, mTimePickerBtn, mAlertDialogBtn, mSingleDialogBtn,mMySelfAlertDialogBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dailog_layout);

		mProgressDialogBtn = (Button) findViewById(R.id.progressdialog_progress_dialog_btn);
		mTimePickerBtn = (Button) findViewById(R.id.progressdialog_timepicker_dialog_btn);
		mAlertDialogBtn = (Button) findViewById(R.id.progressdialog_alert_dialog_btn);
		mSingleDialogBtn = (Button) findViewById(R.id.progressdialog_single_alert_dialog_btn);
		mMySelfAlertDialogBtn = (Button) findViewById(R.id.progressdialog_smyself_alert_dialog_btn);
		mProgressDialogBtnListener();
		mTimePickerBtnListener();
		mAlertDialogBtnListener();
		mSingleDialogBtnListener();
	}

	/**
	 * 进度条对话框
	 */
	public void mProgressDialogBtnListener() {
		mProgressDialogBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final ProgressDialog progressDialog = new ProgressDialog(ProgressDialogActivty.this);
				progressDialog.setIndeterminate(false);// 不确定进度大小模式
				progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 水平样式展示
				// 自定义样式进度条
				progressDialog.setProgressDrawable(getResources().getDrawable(R.drawable.seekbar_mystyle_selector));
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i <= 100; i++) {
							progressDialog.setProgress(i);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}

				}).start();
				progressDialog.show();
			}
		});
	}

	public void mTimePickerBtnListener() {
		mTimePickerBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(ProgressDialogActivty.this,
						new OnDateSetListener() {

					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
						Toast.makeText(ProgressDialogActivty.this, year + " " + monthOfYear + " " + dayOfMonth,
								Toast.LENGTH_SHORT).show();

					}
				}, 2015, 10, 11);
				datePickerDialog.setButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				datePickerDialog.show();
			}
		});
	}

	public void mAlertDialogBtnListener() {
		mAlertDialogBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(ProgressDialogActivty.this);
				builder.setIcon(R.drawable.m3);
				builder.setTitle("确认AlertDailog对话框");// 添加标题
				builder.setMessage("确认对话框学习");// 添加内容

				// 对话框中添加继续按钮
				builder.setNeutralButton("继续", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(ProgressDialogActivty.this, dialog + " " + which, Toast.LENGTH_SHORT).show();

					}
				});

				// 对话框中添加取消按钮
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						Toast.makeText(ProgressDialogActivty.this, dialog + " " + which, Toast.LENGTH_SHORT).show();
					}
				});
				// 对话框中添加确定按钮
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(ProgressDialogActivty.this, dialog + " " + which, Toast.LENGTH_SHORT).show();

					}
				});

				builder.setSingleChoiceItems(new String[] { "男", "女" }, 0, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});

	}

	public void mSingleDialogBtnListener() {
		mSingleDialogBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(ProgressDialogActivty.this);
				builder.setIcon(R.drawable.m3);
				builder.setTitle("确认AlertDailog对话框");
				builder.setSingleChoiceItems(new String[] { "男", "女" }, 0, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
	}

	/**
	 * 自定义布局对话框
	 */
	public void MySelfAlertDialogBtnListener(){
		
	}
}
