package com.xhsc.internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class InternetCacheActivity extends Activity {

	// 只要消息队列有消息，此方法就调用
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			ImageView imgView = (ImageView) findViewById(R.id.internet_cache_imageview);
			imgView.setImageBitmap((Bitmap) msg.obj);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.internet_cache_layout);
	}

	public void downLoadImageCache(View v) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				String urlpath = "http://pic39.nipic.com/20140226/18071023_164300608000_2.jpg";
				Bitmap bm = getInternetPicture(urlpath);
				Message msg = new Message();
				// 把bm存入消息中,发送到主线程
				msg.obj = bm;
				handler.sendMessage(msg);
			}
		}).start();
	}

	public Bitmap getInternetPicture(String UrlPath) {
		Bitmap bm = null;
		// 1、确定网址
		// http://pic39.nipic.com/20140226/18071023_164300608000_2.jpg
		String urlpath = UrlPath;
		// 2、获取Uri
		try {
			URL uri = new URL(urlpath);

			// 3、获取连接对象、此时还没有建立连接
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			// 4、初始化连接对象
			// 设置请求的方法，注意大写
			connection.setRequestMethod("GET");
			// 读取超时
			connection.setReadTimeout(5000);
			// 设置连接超时
			connection.setConnectTimeout(5000);
			// 5、建立连接
			connection.connect();

			// 6、获取成功判断,获取响应码
			if (connection.getResponseCode() == 200) {
				// 7、拿到服务器返回的流，客户端请求的数据，就保存在流当中
				InputStream is = connection.getInputStream();
				// 8、开启文件输出流，把读取到的字节写到本地缓存文件
				File file = new File(getCacheDir(), getFileName(urlpath));
				FileOutputStream fos = new FileOutputStream(file);
				int len = 0;
				byte[] b = new byte[1024];
				while ((len = is.read(b)) != -1) {
					fos.write(b, 0, len);
				}
				fos.close();
				is.close();
				//9、 通过图片绝对路径，创建Bitmap对象

				bm = BitmapFactory.decodeFile(file.getAbsolutePath());

				Log.i("", "网络请求成功");

			} else {
				Log.v("tag", "网络请求失败");
				bm = null;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bm;

	}

	public String getFileName(String path) {
		int index = path.lastIndexOf("/");
		return path.substring(index + 1);
	}
}
