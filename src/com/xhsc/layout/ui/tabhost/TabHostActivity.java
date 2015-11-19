package com.xhsc.layout.ui.tabhost;

import com.xhsc.layout.relativelayout.R;
import com.xhsc.layout.ui.progressbar.ProgressBarActivity;
import com.xhsc.layout.ui.spinners.SpinnersActivity;
import com.xhsc.layout.ui.viewpager.ViewPagerActivity;

import android.app.ActionBar.Tab;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabHostActivity extends TabActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tab_host_layout);
	
	TabHost tabHost = getTabHost();
	TabSpec tabSpec1 = tabHost.newTabSpec("tab1");
	tabSpec1.setIndicator(createIndictorView("自定义"));
	tabSpec1.setContent(new Intent(this,SpinnersActivity.class));
	
	
	TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
	tabSpec2.setIndicator(createIndictorView("卖家"));
	tabSpec2.setContent(new Intent(this,ProgressBarActivity.class));
	
	TabSpec tabSpec3 = tabHost.newTabSpec("tab3");
	tabSpec3.setIndicator(createIndictorView("更多"));
	
	tabSpec3.setContent(new Intent(this,ViewPagerActivity.class));
	tabHost.addTab(tabSpec1);
	tabHost.addTab(tabSpec2);
	tabHost.addTab(tabSpec3);
	
	
}
public View createIndictorView(String tab){
	View v =LayoutInflater.from(this).inflate(R.layout.tab_tabwiget_item_layout, null);
	TextView textView = (TextView)v.findViewById(R.id.tab_item_widget_textview);
	textView.setText(tab);
	return v ;
}
}
