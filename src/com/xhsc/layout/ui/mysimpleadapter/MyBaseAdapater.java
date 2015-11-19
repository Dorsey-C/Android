package com.xhsc.layout.ui.mysimpleadapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.xhsc.layout.relativelayout.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//实现特定需求下的适配器，采用构造方法传值，数据写死了，实际当中资源往往是从网络去取值的，提供set方法修改数据源
public class MyBaseAdapater extends BaseAdapter {
	ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
	Context context;
	LayoutInflater layoutInflater;
	public MyBaseAdapater(ArrayList<HashMap<String, Object>> arrayList,Context context) {
		this.arrayList = arrayList;
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
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
		ViewHolder holder;
		if(convertView==null){
			//一级优化，避免重复实例化View v 在分页列表项目过多时造成内存资源耗尽系统崩溃，在为空时实例化
			v = layoutInflater.inflate(R.layout.adapter_meituan_simpleadapter_item_layout, null);
			
			
			//二级优化，避免重复获得实例，ImageView iconImg  TextView titleTxt  TextView contentTxt
			holder = new ViewHolder();
			holder.iconImg = (ImageView)v.findViewById(R.id.meituan_simpleadapter_item_imageview);
			holder.titleTxt = (TextView)v.findViewById(R.id.meituan_simpleadapter_item_title);
			holder.contentTxt = (TextView)v.findViewById(R.id.meituan_simpleadapter_item_content);
			
			//setTag()只能保存一个对象，所以采用内部类保存数据
			v.setTag(holder);
		}else{
			v =convertView;
			holder = (ViewHolder)v.getTag();
		}
		
		 
		
		HashMap<String, Object> item = (HashMap<String, Object>)getItem(position);
		
		int icon = (Integer)item.get("icon");
		String title = (String)item.get("title");
		String content = (String)item.get("content");
		
		holder.iconImg.setImageResource(icon);
		holder.titleTxt.setText(title);
		holder.contentTxt.setText(content);
		
		return v;
	}
	class ViewHolder{
		ImageView iconImg;
		TextView titleTxt;
		TextView contentTxt;
		
	}
}
