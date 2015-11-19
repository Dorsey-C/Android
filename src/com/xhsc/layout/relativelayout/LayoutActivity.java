package com.xhsc.layout.relativelayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xhsc.layout.linearlayoutactivity.LinearLayoutActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class LayoutActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		List<Map<String, Object>> data = getData();

		setListAdapter(new SimpleAdapter(this, data,
				android.R.layout.simple_list_item_1, new String[] { "title" },
				new int[] { android.R.id.text1 }));

	}

	public List<Map<String, Object>> getData() {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		addItem(data, "线型布局", LinearLayoutActivity.class);
		addItem(data, "相对布局", RelativeLayoutActivity.class);
		addItem(data, "单帧布局", FrameLayoutActivity.class);
		addItem(data, "网络布局", GridLayoutActivity.class);
		addItem(data, "表格布局", TableLayoutActivity.class);
		addItem(data, "嵌套线性布局", Linear_LayoutActivity.class);
		
		return data;
	}

	public void addItem(List<Map<String, Object>> data, String name, Class<?> c) {
		addItem(data, name, new Intent(this, c));
	}

	protected void addItem(List<Map<String, Object>> data, String name,
			Intent intent) {
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("title", name);
		temp.put("intent", intent);
		data.add(temp);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Map<String, Object> map = (Map<String, Object>) l .getItemAtPosition(position);

		Intent intent = (Intent) map.get("intent");
		startActivity(intent);

	}
}
