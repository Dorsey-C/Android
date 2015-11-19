package com.xhsc.layout.ui.meituan;

import java.util.ArrayList;

import com.xhsc.layout.relativelayout.R;

import android.R.array;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyMeiTuanBaseAdapter extends BaseAdapter {
	ArrayList<MeiTuan> arrayList = new ArrayList<MeiTuan>();

	LayoutInflater layoutInflater;

	public MyMeiTuanBaseAdapter(Context context) {

		this.layoutInflater = LayoutInflater.from(context);
	}

	public void setListData(ArrayList<MeiTuan> arrayList) {
		this.arrayList = arrayList;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {

		return arrayList.size();
	}

	@Override
	public Object getItem(int position) {

		return arrayList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		ViewHodler viewHodler;
		if (convertView == null) {
			v = layoutInflater.inflate(R.layout.my_baseadapter_meituan_item_layout, null);
			viewHodler = new ViewHodler();
			viewHodler.iconImg = (ImageView) v.findViewById(R.id.meituan_mybaseadapter_item_imageview);
			viewHodler.titleTxt = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_title);
			viewHodler.contentTxt = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_content);
			viewHodler.nowPriceTxt = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_nowprice);
			viewHodler.oldPriceTxt = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_oldprice);

			viewHodler.score = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_score);
			v.setTag(viewHodler);

		} else {
			v = convertView;
			viewHodler = (ViewHodler) v.getTag();
		}

		MeiTuan mTuan = (MeiTuan) getItem(position);
		viewHodler.iconImg.setBackgroundResource(mTuan.getIcon());
		viewHodler.titleTxt.setText(mTuan.getTitle());
		viewHodler.contentTxt.setText(mTuan.getContent());

		viewHodler.nowPriceTxt.setText(mTuan.getNowPrice());

		if (mTuan.getOldPrice().endsWith("元")){
			viewHodler.oldPriceTxt.setText((String)mTuan.getOldPrice());

			viewHodler.oldPriceTxt.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		}else{
			viewHodler.oldPriceTxt.setBackgroundResource(R.drawable.a3v);//(Integer)mTuan.getOldPrice()
		}

		viewHodler.score.setText(mTuan.getScore());

		return v;
	}

	class ViewHodler {
		ImageView iconImg;
		TextView titleTxt;
		TextView contentTxt;
		TextView nowPriceTxt;
		TextView oldPriceTxt;
		TextView score;
	}
}
