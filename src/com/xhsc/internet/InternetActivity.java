package com.xhsc.internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpConnection;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class InternetActivity extends Activity {
	// 只要消息队列有消息，此方法就调用
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			ImageView imgView = (ImageView) findViewById(R.id.internet_imageview);
			imgView.setImageBitmap((Bitmap) msg.obj);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.internet_layout);

	}

	public void downLoadImage(View v) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// 1、确定网址
				String path = "http://pic39.nipic.com/20140226/18071023_164300608000_2.jpg";
				// 2、获取Uri
				try {
					URL uri = new URL(path);
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
						// 8、从流中读取数据，构造一个图片对象GoogleAPI
						Bitmap bm = BitmapFactory.decodeStream(is);
						// 9、把图片设置到IU ImageView中,网络耗时刷新主线程,创建消息；
						Message msg = new Message();
						// 把bm存入消息中
						msg.obj = bm;
						handler.sendMessage(msg);
						Log.i("", "网络请求成功");
					} else {
						Log.v("tag", "网络请求失败");
					}

				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}).start();
	}

	public Bitmap getInternetPicture(String UrlPath) {
		Bitmap bm = null;
		// 1、确定网址
		// http://pic39.nipic.com/20140226/18071023_164300608000_2.jpg
		String urlpath = UrlPath;
		// 2、获取Url
		try {
			URL url = new URL(urlpath);

			// 3、获取连接对象、此时还没有建立连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
				// 8、从流中读取数据，构造一个图片对象GoogleAPI
				bm = BitmapFactory.decodeStream(is);
				// 9、把图片设置到UI主线程
				// ImageView中,获取网络资源是耗时操作需放在子线程中进行,通过创建消息发送消息给主线程刷新控件；

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
	
	public void onClick(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String urlpath = "http://pic39.nipic.com/20140226/18071023_164300608000_2.jpg";
				Bitmap bm = getInternetPicture(urlpath);
				Message msg = new Message();
				// 把bm存入消息中,发送到主线程
				msg.obj = bm;
				handler.sendMessage(msg);
			}
		}).start();
	}
}
