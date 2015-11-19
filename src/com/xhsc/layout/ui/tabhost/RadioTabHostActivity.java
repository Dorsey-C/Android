package com.xhsc.layout.ui.tabhost;

import com.xhsc.layout.relativelayout.R;
import com.xhsc.layout.ui.progressbar.ProgressBarActivity;
import com.xhsc.layout.ui.spinners.SpinnersActivity;
import com.xhsc.layout.ui.viewpager.ViewPagerActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class RadioTabHostActivity extends TabActivity implements OnCheckedChangeListener {
	private static final String TAB_ONE_TAG = "tab1";
	private static final String TAB_TWO_TAG = "tab2";
	private static final String TAB_THREE_TAG = "tab3";
	private RadioGroup mRadioGroup;
	private TabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.tab_radio_main_layout);
		/**
		 * 在onCreate方法中色图ContenView（）方法后用findViewByID（）方法可以省略this.findViewById()中的this，其他地方都需要采用view.的方式调用，否则易空指针
		 */
		mRadioGroup = (RadioGroup) findViewById(R.id.tab_radio_group);
		/**
		 * 实例化mTabHost，采用getTabHost方法，而不是new 方法
		 */
		mTabHost = getTabHost();
		
		
		/**
		 * 构造引导页的选项卡
		 * 构造一个页卡(TabSpec)：页卡项和页卡内容
		 */
		TabSpec tabSpec1 = mTabHost.newTabSpec(TAB_ONE_TAG);
		tabSpec1.setIndicator("首页");
		tabSpec1.setContent(new Intent(this, SpinnersActivity.class));

		TabSpec tabSpec2 = mTabHost.newTabSpec(TAB_TWO_TAG);
		tabSpec2.setIndicator("首页");
		tabSpec2.setContent(new Intent(this, ProgressBarActivity.class));

		TabSpec tabSpec3 = mTabHost.newTabSpec(TAB_THREE_TAG);
		tabSpec3.setIndicator("首页");
		tabSpec3.setContent(new Intent(this, ViewPagerActivity.class));

		/**
		 * 将页卡添加到TabHost (ViewGroup)
		 */
		mTabHost.addTab(tabSpec1);
		mTabHost.addTab(tabSpec2);
		mTabHost.addTab(tabSpec3);

		mRadioGroup.setOnCheckedChangeListener(this);
		
		/**
		 * TabHost页卡转换监听事件处理
		 */
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				Toast.makeText(RadioTabHostActivity.this, "tabId "+tabId, Toast.LENGTH_SHORT);
				
			}
		});

	}

	
	/**
	 * checkedId :RadioGroup子View RadioButon ID
	 */
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.tab_radio_one:
			mTabHost.setCurrentTabByTag(TAB_ONE_TAG);
			break;

		case R.id.tab_radio_two:
			mTabHost.setCurrentTabByTag(TAB_TWO_TAG);
			break;

		case R.id.tab_radio_three:
			mTabHost.setCurrentTabByTag(TAB_THREE_TAG);
			break;
		default:
			break;
		}

	}

}
