package com.xhsc.layout.ui.menu;

import com.xhsc.layout.relativelayout.R;
import com.xhsc.layout.ui.spinners.SpinnersActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.option_menu_layout);
	}

	/**
	 * 菜单创建使用onCreateOptionsMenu（）方法 即可用解析XML的方法也可使用代码添加的方法
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_test, menu);

		// 代码设置添加的方法
		menu.add(1, 13, 4, "主页");
		menu.add(1, 14, 5, "商家");
		return super.onCreateOptionsMenu(menu);

	}

	/**
	 * 菜单监听事件处理
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_delete:
			/**
			 * 隐式调用系统内部程序启动打电话界面
			 */
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:13438897635"));
			startActivity(intent);
			break;

		case R.id.menu_add:
			/**
			 * 隐式调用方法，需要使用setAction方法 并且在xml的manifest文件中需要启动的activity下使用
			 * <intent-filter> <action android:name="com.xhsc.menu"/> <category
			 * android:name="android.intent.category.DEFAULT"/> </intent-filter>
			 * 
			 * 缺点效率相对低些需要寻找匹配 优点可以调用系统资源，不如打电话启动地图等
			 * setAction("")中的命名可自己定义但得与Manifest文件中
			 * <action android:name="">name的参数内容相同
			 */
			intent = new Intent();
			intent.setAction("com.xhsc.menu");
			startActivity(intent);
			break;

		case R.id.menu_app:

			startActivity(new Intent(this, SpinnersActivity.class));
			break;
			
		case 14:

			startActivity(new Intent(this, SpinnersActivity.class));
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
