package com.xhsc.async;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class DownLoadAsyncActivity extends Activity implements OnClickListener {

	GridView mGridview;
	Button mButton;
	Bitmap bitmap;
	private Executor mExecutor;
	String[] path = {
			"http://img4.imgtn.bdimg.com/it/u=128811874,840272376&fm=21&gp=0.jpg",
			"http://h.hiphotos.baidu.com/image/pic/item/48540923dd54564e854f5b30b1de9c82d1584f94.jpg",
			"http://c.hiphotos.baidu.com/image/h%3D360/sign=624e1ab9be3eb1355bc7b1bd961fa8cb/7a899e510fb30f24a0e3da52ca95d143ad4b0361.jpg",
			"http://c.hiphotos.baidu.com/image/h%3D360/sign=cca8acd1cc1b9d1695c79c67c3dfb4eb/bba1cd11728b4710037cc3c2c1cec3fdfc032368.jpg",
			"http://h.hiphotos.baidu.com/image/h%3D360/sign=a2907fe8e51190ef1efb94d9fe1a9df7/3ac79f3df8dcd1009d045724708b4710b9122f1e.jpg",
			"http://h.hiphotos.baidu.com/image/h%3D360/sign=b9b0c7669a510fb367197191e932c893/b999a9014c086e0642e8b69406087bf40bd1cba9.jpg",
			"http://g.hiphotos.baidu.com/image/h%3D360/sign=649b9cce1c178a82d13c79a6c602737f/6c224f4a20a44623ef4ac3609a22720e0cf3d734.jpg",
			"http://g.hiphotos.baidu.com/image/h%3D360/sign=caa2d267cfef7609230b9f991edca301/6d81800a19d8bc3e7763d030868ba61ea9d345e5.jpg",
			"http://h.hiphotos.baidu.com/image/h%3D360/sign=efe4d20a249759ee555066cd82fb434e/0dd7912397dda1444a2adab5b0b7d0a20cf48692.jpg",
			"http://g.hiphotos.baidu.com/image/h%3D360/sign=bf40c922952bd4075dc7d5fb4b889e9c/9f2f070828381f305f40daa3ab014c086e06f05b.jpg",
			"http://d.hiphotos.baidu.com/image/h%3D360/sign=12d15e005b82b2b7b89f3fc201accb0a/d009b3de9c82d1587f2a9fb5820a19d8bc3e420e.jpg",
			"http://b.hiphotos.baidu.com/image/h%3D360/sign=d215c4558444ebf872716239e9f8d736/37d12f2eb9389b50f6b71d048635e5dde7116e18.jpg",
			"http://h.hiphotos.baidu.com/image/h%3D360/sign=92cf362a71f08202329297397bfafb8a/63d9f2d3572c11df96686d2a612762d0f703c27a.jpg",
			"http://img5.imgtn.bdimg.com/it/u=3580210867,3098509580&fm=21&gp=0.jpg",
			"http://e.hiphotos.baidu.com/image/h%3D360/sign=23d2cf38b08f8c54fcd3c3290a282dee/c9fcc3cec3fdfc031ec6ea6ed03f8794a5c226ad.jpg",
			"http://img0.imgtn.bdimg.com/it/u=1070902365,2619384777&fm=21&gp=0.jpg",
			"http://img1.imgtn.bdimg.com/it/u=2111648732,3690624201&fm=23&gp=0.jpg",
			"http://img0.imgtn.bdimg.com/it/u=2081529157,1978722497&fm=23&gp=0.jpg",
			"http://img5.imgtn.bdimg.com/it/u=2531484665,1615000788&fm=23&gp=0.jpg",
			"http://img0.imgtn.bdimg.com/it/u=3135582527,842621827&fm=23&gp=0.jpg",
			"http://img4.imgtn.bdimg.com/it/u=3756685971,1441134629&fm=23&gp=0.jpg",
			"http://img0.imgtn.bdimg.com/it/u=3472918996,2339968434&fm=23&gp=0.jpg",
			"http://img3.imgtn.bdimg.com/it/u=1050285812,2225196415&fm=23&gp=0.jpg" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.async_gridview_layout);
		
		mButton = (Button) findViewById(R.id.async_download_btn);
		mGridview = (GridView) findViewById(R.id.async_gridView);
		mButton.setOnClickListener(this);
		mExecutor = new ThreadPoolExecutor(10, 150, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
	}

	@Override
	public void onClick(View v) {

		/*MyAsyncTask myAsyncTask = new MyAsyncTask();
		myAsyncTask.execute(path);*/
		
		OptimalAdapter adapters = new OptimalAdapter(this);
		mGridview.setAdapter(adapters);
		adapters.setPath(path);
		
	}
	/**
	 * 
	 * @param downLoadImage
	 * @return下载网络图片，返回个BitMap对象
	 */
	public Bitmap downLoadImage(String url) {
		try {
			Log.v("tag", ""+url+"\n");
			URL urls = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			bitmap = BitmapFactory.decodeStream(is);
			Log.v("tag", ""+bitmap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bitmap;
	}

	/**
	 * 
	 * @author Optimal最优的意思，下载图片融入到适配器，只刷新一次getview方法
	 * 但缺点是图片错乱
	 *
	 */
	public class OptimalAdapter extends BaseAdapter{

		LayoutInflater layoutInflater;
		Context context;
		String[] paths = new String[23];
		public OptimalAdapter(Context context) {
			this.context = context;
			layoutInflater = LayoutInflater.from(context);
			
		}
		public void setPath(String[] path) {
			this.paths = path;
			notifyDataSetChanged();
		}
		@Override
		public int getCount() {
			return paths.length;
		}

		@Override
		public Object getItem(int position) {
			return paths[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final ImageView imageView;
			if (convertView == null) {
				convertView = layoutInflater.inflate(R.layout.async_gridview_item_layout, null);
				imageView = (ImageView) convertView.findViewById(R.id.async_item_imageview);
				convertView.setTag(imageView);
			} else {
				imageView = (ImageView) convertView.getTag();
			}

			new AsyncTask<String, Void, Bitmap>() {
				Bitmap bitmaps;
				@Override
				protected Bitmap doInBackground(String... params) {
					bitmaps = downLoadImage(params[0]);
					return bitmaps;
				}

				protected void onPostExecute(Bitmap result) {
					imageView.setImageBitmap(result);
				};
				
//			}.execute(paths[position]);//单任务一个一个执行
			}.executeOnExecutor(mExecutor, paths[position]);//多线程池同时运行多个线程
			return convertView;
		}
		
	}
	/**
	 * 
	 * @author GidviewAdapter MyAsyncTask
	 * 虽是一次性赋值，
	 *
	 */
	public class GidviewAdapter extends BaseAdapter {

		private ArrayList<Bitmap> images = new ArrayList<Bitmap>();
		private Context context;
		LayoutInflater layouInflater;

		public GidviewAdapter(Context context) {

			this.context = context;
			layouInflater = LayoutInflater.from(context);

		}

		public void setImages(ArrayList<Bitmap> images) {
			this.images = images;
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return images.size();
		}

		@Override
		public Object getItem(int position) {
			return images.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				convertView = layouInflater.inflate(R.layout.async_gridview_item_layout, null);
				imageView = (ImageView) convertView.findViewById(R.id.async_item_imageview);
				convertView.setTag(imageView);
			} else {
				imageView = (ImageView) convertView.getTag();
			}

			imageView.setImageBitmap(images.get(position));
			return convertView;
		}
	}

	public class MyAsyncTask extends AsyncTask<String[], Void, ArrayList<Bitmap>> {

		@Override
		protected ArrayList<Bitmap> doInBackground(String[]... params) {
			String[] paths = new String[9];
			paths = params[0];
			ArrayList<Bitmap> bitArrayList = new ArrayList<Bitmap>();
			for (int i = 0; i < paths.length; i++) {
				Log.v("tag", "paths[i]:"+paths[i]+"\n");
				Log.v("tag", "doInBackground加载资源"+downLoadImage(paths[i]));
				bitArrayList.add(downLoadImage(paths[i]));
			}
			return bitArrayList;
		}

		@Override
		protected void onPostExecute(ArrayList<Bitmap> result) {
			super.onPostExecute(result);
			GidviewAdapter adapter = new GidviewAdapter(DownLoadAsyncActivity.this);
			Log.v("tag", "onPostExecute设置数据源");
			mGridview.setAdapter(adapter);
			adapter.setImages(result);

		}

	}



	
	
	
	
	
	/**
	 * 通过在异步任务中循环加载图片，不但刷新适配器实现
	 * 不提倡，原因:
	 * 1.重复刷新适配器执行getView方法 
	 * 2.不能实现图片同步加载,相当于当线程执行.
	 */
	public void loadPictureByPublishProgress(){
		new AsyncTask<String, Bitmap, Void>() {

			@Override
			protected Void doInBackground(String... params) {
				for (int i = 0; i < params.length; i++) {
					Bitmap bm = downLoadImage(params[i]);
					publishProgress(bm);
				}
				return null;
			}

			protected void onProgressUpdate(Bitmap... values) {
//				mAdapter.addDate(values[0]);
			}

		}.execute(path);

	}
	
	public class MyGridViewAdapter extends BaseAdapter {
		private ArrayList<Bitmap> list = new ArrayList<Bitmap>();
		private LayoutInflater infalter;

		public void addDate(Bitmap bm) {
			list.add(bm);
			notifyDataSetChanged();
		}

		public MyGridViewAdapter(Context context) {
			infalter = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final ImageView imageview;
			if (convertView == null) {
				convertView = infalter.inflate(R.layout.async_gridview_item_layout, null);
				imageview = (ImageView) convertView.findViewById(R.id.async_item_imageview);
				convertView.setTag(imageview);
			} else {
				imageview = (ImageView) convertView.getTag();
			}

			Bitmap bitmap = (Bitmap) getItem(position);
			imageview.setImageBitmap(bitmap);

			return convertView;
		}

	}
}
