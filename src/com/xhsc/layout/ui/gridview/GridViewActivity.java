package com.xhsc.layout.ui.gridview;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridViewActivity extends Activity {
	private GridView mGridView;
	private int[] mImages = { R.drawable.m3, R.drawable.m4, R.drawable.m8,
			R.drawable.m3, R.drawable.m4, R.drawable.m8, R.drawable.m3,
			R.drawable.m4, R.drawable.m8, R.drawable.m3, R.drawable.m4, R.drawable.m8,
			R.drawable.m3, R.drawable.m4, R.drawable.m8, R.drawable.m3,
			R.drawable.m4, R.drawable.m8 };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter_gridview_layout);
		mGridView = (GridView)findViewById(R.id.adapter_gridview);
		ImageGridViewAdapter imageGridViewAdapter = new ImageGridViewAdapter(this);
		mGridView.setAdapter(imageGridViewAdapter);
		imageGridViewAdapter.setData(mImages);
		
		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(GridViewActivity.this, "postion "+position, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
	
	public class ImageGridViewAdapter extends BaseAdapter{
		private int[] images = {};
		private Context context;
		private LayoutInflater layoutInflater;
		public ImageGridViewAdapter(Context context) {
			this.context = context;
			layoutInflater = LayoutInflater.from(context);
		}
		/**
		 * 设置数据源
		 * @param images
		 */
		public void setData(int[] images){
			this.images = images;
			notifyDataSetChanged();//通知适配器刷新数据源
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return images.length;
		}
		
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return images[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if(convertView == null){
			convertView = layoutInflater.inflate(R.layout.item_grid_imageview_layout, null);
			imageView = (ImageView)convertView.findViewById(R.id.imageview);
			convertView.setTag(imageView);
		}else{
			imageView = (ImageView)convertView.getTag();
		}
		
		imageView.setImageResource((Integer)getItem(position));
		imageView.setBackgroundResource((Integer)getItem(position));
			return convertView;
		}
		
	}
}
