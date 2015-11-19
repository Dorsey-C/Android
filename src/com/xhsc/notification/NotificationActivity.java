package com.xhsc.notification;

import javax.net.ssl.ManagerFactoryParameters;

import com.xhsc.layout.relativelayout.R;
import com.xhsc.layout.ui.meituan.MeiTuanMyBaseAdapterActivity;
import com.xhsc.layout.ui.meituan.MeiTuanSimpleAdapterActivity;
import com.xhsc.learn.main.MainActivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity implements OnClickListener {

	Button mNotificationBtn, mUpdatenoNotificationBtn, mClearNotificationBtn, mNavigationNotificationBtn;
	Button mNtificationDownloadProgress, mdownLoadindeterminProgress, mNotificationBigViewBtn,
			mNotificationmydefinitionbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_layout);
		mNotificationBtn = (Button) findViewById(R.id.notification_send_btn);
		mUpdatenoNotificationBtn = (Button) findViewById(R.id.notification_update_btn);
		mClearNotificationBtn = (Button) findViewById(R.id.notification_clear_btn);
		mNavigationNotificationBtn = (Button) findViewById(R.id.notification_navigation_btn);
		mNtificationDownloadProgress = (Button) findViewById(R.id.notification_downloadprogress_btn);
		mdownLoadindeterminProgress = (Button) findViewById(R.id.notification_downLoadindetermin_btn);
		mNotificationBigViewBtn = (Button) findViewById(R.id.notification_bigview_btn);
		mNotificationmydefinitionbtn = (Button) findViewById(R.id.notification_mydefinition_btn);
		mNotificationBtn.setOnClickListener(this);
		mUpdatenoNotificationBtn.setOnClickListener(this);
		mClearNotificationBtn.setOnClickListener(this);
		mNavigationNotificationBtn.setOnClickListener(this);
		mNtificationDownloadProgress.setOnClickListener(this);
		mdownLoadindeterminProgress.setOnClickListener(this);
		mNotificationBigViewBtn.setOnClickListener(this);
		mNotificationmydefinitionbtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.notification_send_btn:
			sendNotification();
			break;
		case R.id.notification_update_btn:
			updateNotification();
			break;
		case R.id.notification_clear_btn:
			clearNotification();
			break;
		case R.id.notification_navigation_btn:
			gpsNotification();
			break;
		case R.id.notification_downloadprogress_btn:
			downloadProgressNotification();
			break;
		case R.id.notification_downLoadindetermin_btn:
			downLoadindetermin();
			break;
		case R.id.notification_bigview_btn:
			bigViewNotification();
			break;

		case R.id.notification_mydefinition_btn:

			break;

		default:
			break;
		}

	}

	public void sendNotification() {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.meinv2);
		builder.setContentTitle(getString(R.string.notification_title));
		builder.setContentText(getString(R.string.notification_content));
		builder.setTicker(getString(R.string.notification_content));
		builder.setAutoCancel(true);
		/**
		 * 通知行为设置 获取PendingIntent
		 */
		Intent intents = new Intent(this, MeiTuanMyBaseAdapterActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intents, PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(pendingIntent);

		/**
		 * 发布通知 获取
		 */
		NotificationManager maneger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		int notificationId = 11;
		Notification notification = builder.build();
		maneger.notify(notificationId, notification);
	}

	/**
	 * 更新通知
	 */
	public void updateNotification() {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.a24);
		builder.setContentTitle("相亲会");
		builder.setContentText("成都相亲会，今天软件园");
		builder.setTicker("成都相亲会，今天软件园");
		builder.setAutoCancel(true);
		/**
		 * maneger是可以共用的，通过ID是识别更新通知，ID相同则会更新，不同会出现新的通知
		 */
		NotificationManager maneger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		int notificationId = 11;
		Notification notification = builder.build();
		maneger.notify(notificationId, notification);
	}

	/**
	 * 清除通知
	 */
	public void clearNotification() {
		NotificationManager maneger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		int notificationId = 11;
		maneger.cancel(notificationId);
		maneger.cancelAll();// 清除所有，不需要识别id
	}

	/**
	 * 通知导航
	 */

	public void gpsNotification() {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.meituan_image2);
		builder.setContentTitle("导航通知");
		builder.setContentText("进入一个Activity，停留返回");
		builder.setTicker("进入一个Activity，停留返回");
		builder.setAutoCancel(true);

		Intent intent = new Intent(this, MeiTuanSimpleAdapterActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		Log.v("tag", "" + stackBuilder);
		stackBuilder.addParentStack(MeiTuanSimpleAdapterActivity.class);//
		stackBuilder.addNextIntent(intent);
		PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(pendingIntent);
		/**
		 * 发布通知 获取
		 */
		NotificationManager maneger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		int notificationId = 13;
		Notification notification = builder.build();
		maneger.notify(notificationId, notification);
	}

	public void downloadProgressNotification() {
		final NotificationManager maneger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		final int notificationId = 14;
		final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.meituan_image8);
		builder.setContentTitle("进度下载通知");
		builder.setContentText("正在下载当中");
		builder.setTicker("正在下载当中");
		builder.setAutoCancel(true);

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					builder.setProgress(100, i, false);
					maneger.notify(notificationId, builder.build());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				builder.setContentText("下载完毕");
				builder.setProgress(0, 0, false);
				maneger.notify(notificationId, builder.build());
			}
		}).start();

	}

	public void downLoadindetermin() {
		final NotificationManager maneger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		final int notificationId = 15;
		final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.meituan_image8);
		builder.setContentTitle("下载文件");
		builder.setContentText("文件下载开始");
		builder.setTicker("文件下载开始");
		builder.setAutoCancel(true);
		Intent intent = new Intent();
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(pendingIntent);
		builder.setProgress(0, 0, true);
		builder.setContentText("文件下载当中");
		maneger.notify(notificationId, builder.build());
	}

	public void bigViewNotification() {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.meituan_image3);
		builder.setContentTitle("大视图通知");
		builder.setContentText("起床了懒虫");
		builder.setTicker("起床了懒虫");
		builder.setAutoCancel(true);
		builder.setStyle(new NotificationCompat.BigTextStyle().bigText("起床了懒虫"));
		/**
		 * Intent这里必须设置与Service相关的Action以便找到服务 1：表示播放音乐 0：表示停止音乐
		 */
		Intent playerIntent = new Intent(this, MusicService.class);
		playerIntent.setAction(MusicService.ACTION_PALYER);
		playerIntent.putExtra("PALY_STATE", 1);
		playerIntent.putExtra("MUSIC_PATH", "file://"+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath()+"/lianggerencaiyan.mp3");
		PendingIntent pendingPlayerIntent = PendingIntent.getService(this, 0, playerIntent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		// 停止音乐
		Intent pauseIntent = new Intent(this, MusicService.class);
		pauseIntent.setAction(MusicService.ACTION_PAUSE);
		pauseIntent.putExtra("PALY_STATE", 0);
		pauseIntent.putExtra("MUSIC_PATH", "file://"+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath()+"/lianggerencaiyan.mp3");
		PendingIntent pendingPauseIntent = PendingIntent.getService(this, 0, pauseIntent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		
		builder.addAction(R.drawable.player_play,"播放",pendingPlayerIntent);
		builder.addAction(R.drawable.player_pause,"暂停",pendingPauseIntent);
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		manager.notify(17,builder.build());
	}
}
