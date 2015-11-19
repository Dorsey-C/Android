package com.xhsc.layout.ui.meituan;

import java.util.ArrayList;
import java.util.HashMap;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MeiTuanSimpleAdapterActivity extends Activity {
	ListView listView ;
	ArrayList<HashMap<String, Object>> arrayList;
	HashMap<String, Object> item;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter_simple_adapter_layout);
		listView = (ListView)findViewById(R.id.meituan_listview_simple_adapter);
		String[] from = {"icon","title","content"};
		int[] to = {R.id.meituan_simpleadapter_item_imageview,R.id.meituan_simpleadapter_item_title,R.id.meituan_simpleadapter_item_content};
		SimpleAdapter adapter = new SimpleAdapter(this, getHashpMap(), R.layout.adapter_meituan_simpleadapter_item_layout, from, to);
		listView.setAdapter(adapter);
		itemClickListener();
		
		
	}
	
	private void itemClickListener(){
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				SimpleAdapter simpleAdapter = (SimpleAdapter)parent.getAdapter();
				HashMap<String, Object> item = (HashMap<String, Object>)simpleAdapter.getItem(position);
				String content = (String)item.get("content");
				Toast.makeText(MeiTuanSimpleAdapterActivity.this,content, Toast.LENGTH_SHORT).show();
			}
		});
	}
	private ArrayList<HashMap<String, Object>> getHashpMap(){
		arrayList = new ArrayList<HashMap<String,Object>>();
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image1);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image2);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image3);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image4);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image5);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image6);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image7);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image8);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image1);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image2);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image3);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		
		item = new HashMap<String, Object>();
		item.put("icon", R.drawable.meituan_image4);
		item.put("title", "焖烧哥自助焖锅");
		item.put("content", "仅售55元，价值88元单人自助晚餐！节假日通用，提供免费WiFi！");
		arrayList.add(item);
		
		return arrayList;
	}
}
