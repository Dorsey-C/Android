package com.xhsc.store.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class StoreFileActivity extends Activity{
	ImageView mImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.store_file_layout);
		mImage = (ImageView)findViewById(R.id.store_file_image);
	
	}
	public void storeOnClick(View v) throws IOException{
		switch (v.getId()) {
		case R.id.internal_write_btn:
			/*内部存储数据*/
			File file = new File(this.getFilesDir(), "mmm.png");
			try {
				FileOutputStream os = new FileOutputStream(file);
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meituan_image1);
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);
				os.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
		
		case R.id.internal_read_btn:
			/*内部读取数据*/
			File file1 = new File(this.getFilesDir(),"mmm.png");
			Bitmap bitmap = BitmapFactory.decodeFile(file1.getPath());
			mImage.setImageBitmap(bitmap);
			
			break;
		case R.id.external_write_btn:
			/*外部公共存储数据*/
			File publicFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			Log.v("tag","DIRECTORY_PICTURES  :"+publicFile);
			String dir = publicFile.getAbsolutePath();
			
			
			if (!publicFile.exists()) {
				publicFile.mkdir();
			}
			
			
			Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.meituan_image2);
			File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "waibugonggong.png");
			
			if (!file2.exists()) {
				file2.createNewFile();
			}
			
			try {
				FileOutputStream os = new FileOutputStream(file2);
				
				bitmap1.compress(Bitmap.CompressFormat.PNG, 100, os);
				os.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
			
		case R.id.external_read_btn:
			/*外部公共存储读取数据*/
			File file3 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"waibugonggong.png");
			Bitmap bitmap2 = BitmapFactory.decodeFile(file3.getPath());
			mImage.setImageBitmap(bitmap2);
			break;
		case R.id.external_write_private_btn:
			/*外部私有存储数据*/
			File filedir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
			File file4 = new File(filedir, "waibusiyou.png");
			try {
				FileOutputStream os = new FileOutputStream(file4);
				Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.meituan_image8);
				bitmap3.compress(Bitmap.CompressFormat.PNG, 100, os);
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case R.id.external_read_private_btn:
			/*外部私有存储读取数据*/
			File file5 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),"waibusiyou.png");
			Bitmap bitmap4 = BitmapFactory.decodeFile(file5.getPath());
			mImage.setImageBitmap(bitmap4);
			break;

		default:
			break;
		}
	}
}
