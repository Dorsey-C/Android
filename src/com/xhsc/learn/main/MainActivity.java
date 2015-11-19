package com.xhsc.learn.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xhsc.async.DownLoadAsyncActivity;
import com.xhsc.async.MyAsyncActivity;
import com.xhsc.broadcast.BroadcastSendActivity;
import com.xhsc.handler.HandlerActivity;
import com.xhsc.handler.HandlerMainThreadStartActivity;
import com.xhsc.internet.InternetActivity;
import com.xhsc.internet.InternetCacheActivity;
import com.xhsc.launchmodel.SingleInstanceActivtiy;
import com.xhsc.launchmodel.StandardActivity;
import com.xhsc.layout.event.EventActivity;
import com.xhsc.layout.relativelayout.LayoutActivity;
import com.xhsc.layout.ui.dialog.ProgressDialogActivty;
import com.xhsc.layout.ui.gridview.GridViewActivity;
import com.xhsc.layout.ui.listview.ListViewAdapterActivity;
import com.xhsc.layout.ui.meituan.MeiTuanMyBaseAdapterActivity;
import com.xhsc.layout.ui.meituan.MeiTuanSimpleAdapterActivity;
import com.xhsc.layout.ui.menu.MenuActivity;
import com.xhsc.layout.ui.mysimpleadapter.MySimpleAdapterActivity;
import com.xhsc.layout.ui.progressbar.ProgressBarActivity;
import com.xhsc.layout.ui.spinners.SpinnersActivity;
import com.xhsc.layout.ui.stylesshape.MyShapeActivity;
import com.xhsc.layout.ui.tabhost.RadioTabHostActivity;
import com.xhsc.layout.ui.tabhost.TabHostActivity;
import com.xhsc.layout.ui.viewpager.ViewPagerActivity;
import com.xhsc.layout.widget.ButtonActivity;
import com.xhsc.layout.widget.EditTextActivtiy;
import com.xhsc.layout.widget.ImageViewActivity;
import com.xhsc.layout.widget.RadioActivity;
import com.xhsc.layout.widget.TextViewActivity;
import com.xhsc.notification.NotificationActivity;
import com.xhsc.parameter.ParameterReceiveActivity;
import com.xhsc.parameter.ParameterStatusActivity;
import com.xhsc.service.TestServcieActivity;
import com.xhsc.store.file.StoreFileActivity;
import com.xhsc.store.sharedpreference.SharePreferenceActivity;
import com.xhsc.webview.WebRequestActivity;
import com.xhsc.webview.WebViewActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	
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

		addItem(data, "布局学习", LayoutActivity.class);
		addItem(data, "控件TextView", TextViewActivity.class);
		addItem(data, "控件Button和生命周期", ButtonActivity.class);
		addItem(data, "控件EditText", EditTextActivtiy.class);
		addItem(data, "控件ImageView", ImageViewActivity.class);
		addItem(data, "Android事件学习", EventActivity.class);
		addItem(data, "控件RadioButton学习", RadioActivity.class);
		addItem(data, "启动模式Standard标准模式学习", StandardActivity.class);
		addItem(data, "启动模式SingleInstance单实例模式学习", SingleInstanceActivtiy.class);
		addItem(data, "参数类型传递学习", ParameterStatusActivity.class);
		addItem(data, "参数类型接收", ParameterReceiveActivity.class);
		addItem(data, "ListViewAdapter", ListViewAdapterActivity.class);
		addItem(data, "访美团MeiTuanSimpleAdapter", MeiTuanSimpleAdapterActivity.class);
		addItem(data, "自定义BaseAdapter", MySimpleAdapterActivity.class);
		addItem(data, "自定义访美团MyBaseAdapter", MeiTuanMyBaseAdapterActivity.class);
		addItem(data, "自定义SpinnerBaseAdapter", SpinnersActivity.class);
		addItem(data, "自定义九宫格GridViewActivity", GridViewActivity.class);
		addItem(data, "自定义滑屏控件ViewPager", ViewPagerActivity.class);
		addItem(data, "自定义进度条ProgressBar", ProgressBarActivity.class);
		addItem(data, "自定义对话框Dialog", ProgressDialogActivty.class);
		addItem(data, "自定义引导选项卡TabHost", TabHostActivity.class);
		addItem(data, "自定义RadioButtonTabHost", RadioTabHostActivity.class);
		addItem(data, "菜单学习MenuActivity", MenuActivity.class);
		addItem(data, "自定义控件美化Shape", MyShapeActivity.class);
		addItem(data, "子线程消息处理handler", HandlerActivity.class);
		addItem(data, "主线程子线程消息处理handler", HandlerMainThreadStartActivity.class);
		addItem(data, "轻量级数据存储学习SharedPreference", SharePreferenceActivity.class);
		addItem(data, "文件内部外部存储StoreFileActivity", StoreFileActivity.class);
		addItem(data, "组件service之StartService", TestServcieActivity.class);
		addItem(data, "获取网络资源InternetActivity", InternetActivity.class);
		addItem(data, "网络缓存图片查看器", InternetCacheActivity.class);
		addItem(data, "广播发送消息", BroadcastSendActivity.class);
		addItem(data, "发送通知 ", NotificationActivity.class);
		addItem(data, "异步任务AsyncTask ", MyAsyncActivity.class);
		addItem(data, "异步AsyncTask下载网络资源图片 ", DownLoadAsyncActivity.class);
		addItem(data, "HTML网页资源加载", WebViewActivity.class);
		addItem(data, "HTML请求服务器数据", WebRequestActivity.class);
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
