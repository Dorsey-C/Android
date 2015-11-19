package com.xhsc.layout.relativelayout;

import android.R.anim;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import com.xhsc.layout.linearlayoutactivity.LinearLayoutActivity;
import com.xhsc.layout.relativelayout.R;

public class Linear_LayoutActivity extends Activity {
	String[] arrayList = { "单帧布局", "线性布局", "网格布局", "相对布局", "表格布局", "主线型布局" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_linearlayout1_layout);

	}

	
}
