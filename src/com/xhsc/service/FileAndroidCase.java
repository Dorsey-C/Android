package com.xhsc.service;

import java.io.File;

import android.os.Environment;
import android.test.AndroidTestCase;
import android.util.Log;

public class FileAndroidCase extends AndroidTestCase  {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testFileCreat(){
		String path1 = "file://" + Environment.getExternalStorageDirectory() + "/pic/"; //  file://mnt/sdcard/music
		File file = new File(path1);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	public void testGetFile(){
		File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
		Log.v("tag", ""+file.getAbsoluteFile());
		if (!file.exists()) {
			file.mkdirs();
		}
		
	}
}
