package com.xhsc.layout.ui.viewpager;

import java.util.ArrayList;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts.Data;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

/**
 * 
 * @author scxh 翻页滑屏，及小圆点
 */
public class ViewPagerActivity extends Activity {
	private ViewPager mViewPager;
	
	ImageView mImageView1,mImageView2,mImageView3;
	int oldPosition = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter_viewpager_layout);
		mViewPager = (ViewPager) findViewById(R.id.viewpager_layout);
		ArrayList<View> data = new ArrayList<View>();
		mImageView1 = ((ImageView) findViewById(R.id.viewpager_dot1));
		mImageView2 = ((ImageView) findViewById(R.id.viewpager_dot2));
		mImageView3 = ((ImageView) findViewById(R.id.viewpager_dot3));
		
		
		setArraylistView(data);
		/*
		 * inflate是解析布局的，是R.layout而非R.Id不然会出现资源找不到异常 findViewByID（）实例化控件的
		 * 
		 */

		ViewPagerBaseAdapeter adapeter = new ViewPagerBaseAdapeter();
		mViewPager.setAdapter(adapeter);
		adapeter.setData(data);
		// 默认第一个小圆点被选中
//		mImgData.get(0).setImageResource(R.drawable.dot_choice);
		// 翻页转变监听
		ViewPagerOnPageChangeListener();
		int n = Integer.MAX_VALUE / 2 % data.size();  
        int itemPosition = Integer.MAX_VALUE / 2 - n;  
          
        mViewPager.setCurrentItem(itemPosition);

	}

	public void ViewPagerOnPageChangeListener() {
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				Log.i("tag", "onPageSelected  " + arg0);
				/*mImgData.get(arg0).setImageResource(R.drawable.dot_choice);
				mImgData.get(oldPosition).setImageResource(R.drawable.dot_no_choice);
				oldPosition = arg0;*/
				switch (arg0%3) {
				case 0:
					mImageView1.setImageResource(R.drawable.dot_choice);
					mImageView2.setImageResource(R.drawable.dot_no_choice);
					mImageView3.setImageResource(R.drawable.dot_no_choice);
					break;

				case 1:
					mImageView1.setImageResource(R.drawable.dot_no_choice);
					mImageView2.setImageResource(R.drawable.dot_choice);
					mImageView3.setImageResource(R.drawable.dot_no_choice);
					break;

				case 2:
					mImageView1.setImageResource(R.drawable.dot_no_choice);
					mImageView2.setImageResource(R.drawable.dot_no_choice);
					mImageView3.setImageResource(R.drawable.dot_choice);
					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				Log.d("tag", "onPageScrolled  " + arg0);

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				Log.v("tag", "onPageScrollStateChanged  " + arg0);

			}
		});
		
		
	}

	/*public void setArrayListImageView() {
		mImgData = new ArrayList<ImageView>();
		mImgData.add((ImageView) findViewById(R.id.viewpager_dot1));
		mImgData.add((ImageView) findViewById(R.id.viewpager_dot2));
		mImgData.add((ImageView) findViewById(R.id.viewpager_dot3));
	}*/

	public void setArraylistView(ArrayList<View> data) {

		View v1 = LayoutInflater.from(this).inflate(R.layout.adapter_viewpager_item1_layout, null);
		data.add(v1);
		View v2 = LayoutInflater.from(this).inflate(R.layout.adapter_viewpager_item2_layout, null);
		data.add(v2);
		View v3 = LayoutInflater.from(this).inflate(R.layout.adapter_viewpager_item3_layout, null);
		data.add(v3);
	}

	public class ViewPagerBaseAdapeter extends PagerAdapter {
		ArrayList<View> data = new ArrayList<View>();

		public void setData(ArrayList<View> data) {
			this.data = data;
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {

			return data.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {

			return arg0 == arg1;
		}

		/**
		 * 重写以下两个方法，一是加载最近几个键面，摧毁前几个打开的键面节约资源
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v = data.get(position);
			container.addView(v);
			Log.v("tag", "instantiateItem position " + position);
			return v;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			View v = data.get(position);
			container.removeView(v);// 这里是remove而不是add方法，否则加载最后一页之后会出现非法描述异常java.lang.IllegalStateException
			Log.v("tag", "destroyItem position " + position);
		}
	}
}
