package com.xhsc.layout.ui.meituan;

import java.util.ArrayList;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MeiTuanMyBaseAdapterActivity extends Activity {
	private ListView listView;
	private MyMeiTuanBaseAdapter myMeiTuanBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter_simple_adapter_layout);
		listView = (ListView)findViewById(R.id.meituan_listview_simple_adapter);
		myMeiTuanBaseAdapter = new MyMeiTuanBaseAdapter( this);
		listView.setAdapter(myMeiTuanBaseAdapter);
		myMeiTuanBaseAdapter.setListData(getData());
	}
	
	public ArrayList<MeiTuan> getData(){
		ArrayList<MeiTuan> listData = new ArrayList<MeiTuan>();
		
		MeiTuan msg = new MeiTuan();
		msg.setIcon(R.drawable.meituan_image1);
		msg.setTitle("1【多店通用】乡村基");
		msg.setContent("20元代金券！全场通用，可叠加使用，提供免费WiFi！");
		msg.setNowPrice("9.9元");
		msg.setOldPrice("20元");
		msg.setScore("4.9分（4546）");
		listData.add(msg);
		
		msg = new MeiTuan();
		msg.setIcon(R.drawable.meituan_image1);
		msg.setTitle("2【多店通用】乡村基");
		msg.setContent("20元代金券！全场通用，可叠加使用，提供免费WiFi！");
		msg.setNowPrice("20元");
		msg.setOldPrice("465");
		msg.setScore("4.8分（546）");
		listData.add(msg);
		
		msg = new MeiTuan();
		msg.setIcon(R.drawable.meituan_image1);
		msg.setTitle("2【多店通用】乡村基");
		msg.setContent("20元代金券！全场通用，可叠加使用，提供免费WiFi！");
		msg.setNowPrice("20元");
		msg.setOldPrice("465");
		msg.setScore("4.8分（546）");
		listData.add(msg);
		
		msg = new MeiTuan();
		msg.setIcon(R.drawable.meituan_image1);
		msg.setTitle("2【多店通用】乡村基");
		msg.setContent("20元代金券！全场通用，可叠加使用，提供免费WiFi！");
		msg.setNowPrice("20元");
		msg.setOldPrice("465");
		msg.setScore("4.8分（546）");
		listData.add(msg);
		
		msg = new MeiTuan();
		msg.setIcon(R.drawable.meituan_image1);
		msg.setTitle("2【多店通用】乡村基");
		msg.setContent("20元代金券！全场通用，可叠加使用，提供免费WiFi！");
		msg.setNowPrice("20元");
		msg.setOldPrice("465");
		msg.setScore("4.8分（546）");
		listData.add(msg);
		
		return listData;
	}
}
