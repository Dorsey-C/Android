package com.xhsc.store.sharedpreference;

import com.xhsc.layout.relativelayout.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/*Android平台给我们提供了一个SharedPreferences类，它是一个轻量级的存储类，
特别适合用于保存软件配置参数。使用SharedPreferences保存数据，
其背后是用xml文件存放数据，文件存放*/

/*获取SharedPreferences的两种方式:
1 调用Context对象的getSharedPreferences()方法
2 调用Activity对象的getPreferences()方法
两种方式的区别:
调用Context对象的getSharedPreferences()方法获得的SharedPreferences对象可以被同一应用程序下的其他组件共享.
调用Activity对象的getPreferences()方法获得的SharedPreferences对象只能在该Activity中使用.*/

/*SharedPreferences的四种操作模式:
Context.MODE_PRIVATE
Context.MODE_APPEND
Context.MODE_WORLD_READABLE
Context.MODE_WORLD_WRITEABLE
 
Context.MODE_PRIVATE：为默认操作模式,代表该文件是私有数据,只能被应用本身访问,在该模式下,写入的内容会覆盖原文件的内容
Context.MODE_APPEND：模式会检查文件是否存在,存在就往文件追加内容,否则就创建新文件.
Context.MODE_WORLD_READABLE和Context.MODE_WORLD_WRITEABLE用来控制其他应用是否有权限读写该文件.
MODE_WORLD_READABLE：表示当前文件可以被其他应用读取.
MODE_WORLD_WRITEABLE：表示当前文件可以被其他应用写入.*/
public class SharePreferenceActivity extends Activity implements OnClickListener {
	private Button mAddBtn, mFindBtn;
	private SharedPreferences mSharePreferences;
//注意代码封装性
	private static final String MESSAGE = "message";
	private static final String USER_NAME = "username";
	private static final String NAME = "com.xhsc.store.SHARE_MESSAGE";//文件名
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.preference_view_layout);
		mAddBtn = (Button) findViewById(R.id.preference_add_btn);
		mFindBtn = (Button) findViewById(R.id.preference_find_btn);

		//注意因为是实现监听接口，所以需要注册
		mAddBtn.setOnClickListener(this);
		mFindBtn.setOnClickListener(this);
		
		/**使用方法步奏1、实例化SharePreference*/
		mSharePreferences = getSharedPreferences(NAME,MODE_PRIVATE);
		
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.preference_add_btn:
			/**使用方法步奏2、添加数据到Sharepreference*/
			String message = "Android数据存储学习";
			//a、实例化Editor  b、调用put方法，写入信息  c、提交信息
			SharedPreferences.Editor editor = mSharePreferences.edit();
			editor.putString(MESSAGE,message);
			editor.putString(USER_NAME, "张三");
			editor.commit();
			Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
			break;
		
		case R.id.preference_find_btn:
			/**从Sharepreference获取数据步凑*/
			
			String msg = mSharePreferences.getString(MESSAGE, "");
			String userName  = mSharePreferences.getString(USER_NAME, "");
			Toast.makeText(this, "保储信息是 :"+msg+ " 用户名 ："+userName, Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}

}
