package com.xhsc.layout.ui.mysimpleadapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.xhsc.layout.relativelayout.R;
import com.xhsc.layout.ui.meituan.MeiTuanSimpleAdapterActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MySimpleAdapterActivity extends Activity {
	ListView listView ;
	ArrayList<HashMap<String, Object>> arrayList;
	HashMap<String, Object> item;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter_simple_adapter_layout);
		listView = (ListView)findViewById(R.id.meituan_listview_simple_adapter);
		
		MyBaseAdapater myBaseAdapater = new MyBaseAdapater(getHashpMap(), this);
		listView.setAdapter(myBaseAdapater);
		
	}
	
	/*private void itemClickListener(){
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
//				SimpleAdapter simpleAdapter = (SimpleAdapter)parent.getAdapter();
				MyBaseAdapater myBaseAdapater = new MyBaseAdapater(arrayList, this);
				HashMap<String, Object> item = (HashMap<String, Object>)myBaseAdapater.getItem(position);
				String content = (String)item.get("content");
				Toast.makeText(MySimpleAdapterActivity.this,content, Toast.LENGTH_SHORT).show();
			}
		});
	}*/
	
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
