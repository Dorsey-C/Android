package com.xhsc.notification;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

	public static final String ACTION_PALYER = "com.xhsc.notification.ACTION_PALYER";
	public static final String ACTION_PAUSE = "com.xhsc.notification.ACTION_PAUSE";
	MediaPlayer mMediaPlayer;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		if(intent.getIntExtra("PALY_STATE", -1) == 1){
			String path = intent.getStringExtra("MUSIC_PATH");
			try {
				if(mMediaPlayer == null){
					mMediaPlayer = new MediaPlayer();
				}
				
				mMediaPlayer.reset();
				mMediaPlayer.setDataSource(path);
				//媒体播放器设置资源时要在prepare之前否者IllegalStateException
				mMediaPlayer.prepare();
				
				mMediaPlayer.start();
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			if(mMediaPlayer==null){
				return super.onStartCommand(intent, flags, startId);
			}
			if(mMediaPlayer.isPlaying())mMediaPlayer.pause();
		}
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	
}
