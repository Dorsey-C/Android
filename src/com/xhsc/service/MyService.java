package com.xhsc.service;

import java.io.File;
import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.nfc.Tag;
import android.os.Environment;
import android.os.IBinder;
import android.os.Message;
import android.renderscript.Mesh.TriangleMeshBuilder;
import android.util.Log;
import android.view.ViewDebug.FlagToString;

public class MyService extends Service {

	public static final int PLAYER_STATE = 1;// 播放
	public static final int PASUE_STATE = 2; // 停止
	private boolean flag = true;
	private MediaPlayer mMediaPlayer;

	@Override
	public void onCreate() {
		super.onCreate();
		Log.v("tag", "onCreate>>>>>>");
		intiMusic();
	}

	public void intiMusic() {
//		String path1 = "file://" + Environment.getExternalStorageDirectory() + "/music";
//		File file = new File("file://" + Environment.getExternalStorageDirectory() + "/music");
//		if (!file.exists()) {
//			file.mkdir();
//		}
//		Log.v("tag", "file>>>>>>>" + file.getAbsolutePath());
		
		File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);//mnt/sdcard/Music
		String path = "file://" + file.getAbsolutePath() + "/qianlvyouhun.mp3";
		mMediaPlayer = new MediaPlayer();
		try {
			mMediaPlayer.setDataSource(path);
			mMediaPlayer.prepare();
			mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mp) {
					stopSelf();
				}
			});

			new Thread(new Runnable() {

				@Override
				public void run() {
					while (flag) {
						if (mMediaPlayer.isPlaying()) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							int duration = mMediaPlayer.getDuration();
							int current = mMediaPlayer.getCurrentPosition();

							Message msg = Message.obtain();
							msg.what = 1;
							msg.arg1 = duration;
							msg.arg2 = current;
							
							TestServcieActivity.mHandler.sendMessage(msg);

						}
					}
				}
			}).start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("tag", "onStartCommand>>>>>>");
		if (intent == null) {
			return super.onStartCommand(intent, flags, startId);
		}
		int playState = intent.getIntExtra("PLAYER", 0);
		switch (playState) {
		case PLAYER_STATE:
			mMediaPlayer.start();

			break;

		case PASUE_STATE:
			mMediaPlayer.pause();
			break;
		default:
			break;
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i("tag", "onBind>>>>");
		return null;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.w("tag", "onUnbind>>>>>");
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		
		super.onDestroy();
		Log.v("tag", "onDestroy>>>>>");
		if (mMediaPlayer != null) {
			flag = false;
			mMediaPlayer.stop();
//			mMediaPlayer = null;手动置为null,便于垃圾回收，告诉垃圾系统这东西我不用了。但是因为上面线程播放是并发执行的，startService不会因为组件摧毁了而停止，进程仍在进行，所以这里让他自己回收，flag作为循环开关
			
		}
	}
}
