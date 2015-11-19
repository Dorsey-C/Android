package com.xhsc.layout.ui.listview;

import com.xhsc.layout.relativelayout.R;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewAdapterActivity extends Activity {
	String[] array  = {"张三","李四","王武","赵六","赵倩","孙丽"}; 
	private ListView mlistView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_adapter_activity);
		mlistView = (ListView) findViewById(R.id.array_adapter_listview);
		//第一个参数是上下文context,第二个参数是listView中每一个item的布局，第三个参数是要显示的信息
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.adapter_listview_item_layout, array);
		mlistView.setAdapter(arrayAdapter);
		mlistView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				TextView textView = (TextView)view;
				Toast.makeText(ListViewAdapterActivity.this, "position " + position + " ,"+ textView.getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}
